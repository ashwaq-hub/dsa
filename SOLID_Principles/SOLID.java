/**
 * 1. Single Responsibility Principle (SRP) "A class should have one, and only
 * one, reason to change."
 * 
 * Instead of one giant User class that handles database logic, email sending,
 * and profile updates, we split them.
 * 
 */

// Good: This class ONLY handles user data
class User {
	private String email;

	public String getEmail() {
		return email;
	}
}

// Good: This class ONLY handles sending messages
class EmailService {
	public void sendEmail(String message) {
		System.out.println("Sending: " + message);
	}
}

/**
 * 
 * 2. Open/Closed Principle (OCP) "Software entities should be open for
 * extension, but closed for modification."
 * 
 * If you want to add SMS notifications, you shouldn't have to rewrite your
 * existing Notification class. Use an interface instead.
 * 
 */

interface MessageSender {
	void send(String message);
}

class EmailSender implements MessageSender {
	public void send(String message) {
		/* Email logic */ }
}

class SmsSender implements MessageSender {
	public void send(String message) {
		/* SMS logic */ }
}

/*
 * 
 * 3. Liskov Substitution Principle (LSP)
 * "Subtypes must be substitutable for their base types."
 * 
 * Essentially: don't inherit from a class and then break its expected behavior
 * (like a Square inheriting from Rectangle but breaking the area logic).
 * 
 * 
 * 4. Interface Segregation Principle (ISP)
 * "Clients should not be forced to depend on methods they do not use."
 * 
 * Don't create a "Fat Interface." Split them so a SimplePrinter isn't forced to
 * implement a fax() method it can't use.
 * 
 */
interface Printer {
	void print();
}

interface FaxMachine {
	void fax();
}

class BasicPrinter implements Printer {
	public void print() {
		System.out.println("Printing...");
	}
}

/**
 * 
 * 5. Dependency Inversion Principle (DIP) "Depend on abstractions, not
 * concretions."
 * 
 * High-level modules shouldn't depend on low-level modules. They should both
 * depend on interfaces.
 * 
 */

class NotificationManager {
	private MessageSender sender;

	// We inject the interface, not a specific class
	public NotificationManager(MessageSender sender) {
		this.sender = sender;
	}

	public void notifyUser(String msg) {
		sender.send(msg);
	}
}

/*
 * Putting it all together (The "Simple" Program)
 */
public class SOLID {
	public static void main(String[] args) {
		// Create our objects
		User user = new User();
		EmailService emailService = new EmailService();

		// Use Dependency Injection to create a NotificationManager
		NotificationManager notificationManager = new NotificationManager(emailService);

		// Notify the user
		notificationManager.notifyUser("Hello, " + user.getEmail() + "!");
	}
}