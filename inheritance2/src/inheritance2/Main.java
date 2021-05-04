package inheritance2;

public class Main {

	public static void main(String[] args) {


		CustomerManager customerManager = new CustomerManager();
		
		DatabaseLogger databaseLogger = new DatabaseLogger();
		EmailLogger emailLogger = new EmailLogger();
		FileLogger fileLogger = new FileLogger();
		customerManager.add(databaseLogger);
		customerManager.add(fileLogger);
		customerManager.add(emailLogger);

	}

}
