import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// 1. Enums for type safety
enum VehicleType {
    MOTORCYCLE, CAR, TRUCK
}

// 2. Domain Models
abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() { return licensePlate; }
    public VehicleType getType() { return type; }
}

class Motorcycle extends Vehicle { public Motorcycle(String lp) { super(lp, VehicleType.MOTORCYCLE); } }
class Car extends Vehicle { public Car(String lp) { super(lp, VehicleType.CAR); } }
class Truck extends Vehicle { public Truck(String lp) { super(lp, VehicleType.TRUCK); } }

// 3. The Resource (Spot)
class ParkingSpot {
    private final int id;
    private final VehicleType targetType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int id, VehicleType targetType) {
        this.id = id;
        this.targetType = targetType;
    }

    public boolean isAvailable() { return parkedVehicle == null; }
    
    public boolean canFit(Vehicle v) {
        return isAvailable() && v.getType() == this.targetType;
    }

    public void park(Vehicle v) { this.parkedVehicle = v; }
    public void leave() { this.parkedVehicle = null; }
    public int getId() { return id; }
}

// 4. The Orchestrator (Parking Lot)
class ParkingLot {
    private final List<ParkingSpot> spots = new ArrayList<>();
    // Lookup table for O(1) retrieval by license plate
    private final Map<String, ParkingSpot> activeAssignments = new ConcurrentHashMap<>();

    public ParkingLot(int mcSpots, int carSpots, int truckSpots) {
        int id = 1;
        for (int i = 0; i < mcSpots; i++) spots.add(new ParkingSpot(id++, VehicleType.MOTORCYCLE));
        for (int i = 0; i < carSpots; i++) spots.add(new ParkingSpot(id++, VehicleType.CAR));
        for (int i = 0; i < truckSpots; i++) spots.add(new ParkingSpot(id++, VehicleType.TRUCK));
    }

    // Thread-safe entry
    public synchronized boolean entry(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.canFit(v)) {
                spot.park(v);
                activeAssignments.put(v.getLicensePlate(), spot);
                System.out.println(v.getType() + " [" + v.getLicensePlate() + "] parked at spot #" + spot.getId());
                return true;
            }
        }
        System.out.println("No availability for " + v.getType() + " [" + v.getLicensePlate() + "]");
        return false;
    }

    // Thread-safe exit
    public synchronized void exit(String licensePlate) {
        if (activeAssignments.containsKey(licensePlate)) {
            ParkingSpot spot = activeAssignments.remove(licensePlate);
            spot.leave();
            System.out.println("Vehicle [" + licensePlate + "] cleared spot #" + spot.getId());
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}

// 5. Main Execution
public class ParkingSystemApp {
    public static void main(String[] args) {
        ParkingLot myLot = new ParkingLot(2, 2, 1);

        Vehicle c1 = new Car("NYC-123");
        Vehicle c2 = new Car("LIT-777");
        Vehicle t1 = new Truck("BIG-LOAD");
        Vehicle c3 = new Car("FAIL-001"); // This should fail if car spots are full

        myLot.entry(c1);
        myLot.entry(c2);
        myLot.entry(t1);
        myLot.entry(c3); // No more car spots!

        myLot.exit("NYC-123");
        myLot.entry(c3); // Now it fits
    }
}
