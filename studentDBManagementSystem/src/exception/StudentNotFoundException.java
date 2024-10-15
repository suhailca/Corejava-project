package exception;

public class StudentNotFoundException extends RuntimeException{
	
	String Message;

	public StudentNotFoundException(String message) {
		this.Message = message;
	}
	
	public String getMessage() {
		return Message;
	}

}
