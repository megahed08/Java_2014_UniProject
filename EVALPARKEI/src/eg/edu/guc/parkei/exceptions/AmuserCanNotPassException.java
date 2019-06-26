package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class AmuserCanNotPassException extends ParkeiException {
	private static final String DEFAULT_LOCATION = "You should go to its location to ride it!";
	private String message;

	public AmuserCanNotPassException() {
		this.message = super.getMessage() + DEFAULT_LOCATION;
	}

	public AmuserCanNotPassException(String message) {
		this.message = super.getMessage() + message;
	}

	public String getMessage() {
		return message;
	}
}
