package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		
		try {
			
			System.out.println("Hello World!!");
			int i = 1/0;
			System.out.println("Completed");

		}
		catch(Exception ex) {
			
			System.out.println("Inside catch block");
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			
		}
		finally {
			
			System.out.println("Inside finally block");
		}
		
	}

}
