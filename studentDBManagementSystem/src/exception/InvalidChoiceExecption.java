package exception;

public class InvalidChoiceExecption extends RuntimeException{
	String message;

	public InvalidChoiceExecption(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
