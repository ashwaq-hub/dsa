/*
 * Java is a great language for learning OOP because it was designed
 * specifically around these principles. Unlike Python, Java is strictly typed,
 * meaning it enforces these rules much more rigidly.
 * 
 * Here is the "Payment System" example rewritten in Java.
 * 
 * The "All-in-One" Java Example
 * 
 */

// 1. ABSTRACTION: An interface defines what a class MUST do.
interface PaymentMethod {
	void processPayment(double amount);
}

// 2. INHERITANCE: "implements" shows that CreditCard is a type of PaymentMethod
class CreditCard implements PaymentMethod {
	// 3. ENCAPSULATION: "private" hides data from the outside world.
	private String cardNumber;
	private String cvv;

	public CreditCard(String cardNumber, String cvv) {
		this.cardNumber = cardNumber;
		this.cvv = cvv;
	}

	// 4. POLYMORPHISM: The specific implementation for CreditCard
	@Override
	public void processPayment(double amount) {
		System.out.println("Processing Credit Card payment of $" + amount);
		System.out.println("Card ending in: " + cardNumber.substring(cardNumber.length() - 4));
	}
}

class PayPal implements PaymentMethod {
	private String email;

	public PayPal(String email) {
		this.email = email;
	}

	@Override
	public void processPayment(double amount) {
		System.out.println("Logging into PayPal for " + email);
		System.out.println("Payment of $" + amount + " successful.");
	}
}

// --- MAIN EXECUTION ---
public class Main {
	public static void main(String[] args) {
		// Polymorphism in action: Both objects are treated as 'PaymentMethod'
		PaymentMethod myCard = new CreditCard("1234567890123456", "123");
		PaymentMethod myPayPal = new PayPal("user@example.com");

		checkout(myCard, 100.00);
		checkout(myPayPal, 50.00);
	}

	// This method accepts ANY PaymentMethod (Polymorphism)
	public static void checkout(PaymentMethod method, double amount) {
		method.processPayment(amount);
	}
}

/*
 * Interfaces vs. Abstract Classes: In Java, we use interface for pure
 * abstraction (defining behavior) and abstract class if we want to share some
 * base code.
 * 
 * Access Modifiers: Java uses keywords like private, public, and protected. In
 * the example above, if you tried to access myCard.cardNumber from the Main
 * class, the compiler would throw an error. This is Encapsulation at work.
 * 
 * The @Override Annotation: This is a safety feature. It tells the compiler,
 * "I am intentionally providing a specific version of a method from the parent."
 */

/*
Quick Comparison TablePillarJava ImplementationPurposeAbstractioninterface or abstract classHides complexity; focuses on what instead of how.Encapsulationprivate variables + public getters/settersProtects data from unauthorized access.Inheritanceextends or implementsAllows a class to derive features from another.PolymorphismMethod OverridingAllows one interface to be used for a general class of actions.

{
  "oop_pillars_java": [
    {
      "pillar": "Abstraction",
      "java_implementation": "interface or abstract class",
      "purpose": "Hides complexity; focuses on 'what' instead of 'how'."
    },
    {
      "pillar": "Encapsulation",
      "java_implementation": "private variables + public getters/setters",
      "purpose": "Protects data from unauthorized access and modification."
    },
    {
      "pillar": "Inheritance",
      "java_implementation": "extends (classes) or implements (interfaces)",
      "purpose": "Allows a class to derive features and behavior from another."
    },
    {
      "pillar": "Polymorphism",
      "java_implementation": "Method Overriding (@Override) or Overloading",
      "purpose": "Allows one interface to be used for a general class of actions."
    }
  ]
}
  
*/