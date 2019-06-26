package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class UnsuitableAgeCategoryException extends CannotBoardException {
	private static final String DEFAULT_AGE = "Your age category cannot take it!.";
	private String message;

	public UnsuitableAgeCategoryException() {
		this.message = super.getMessage() + DEFAULT_AGE;
	}

	public UnsuitableAgeCategoryException(String message) {
		this.message = super.getMessage() + message;
	}

	public String getMessage() {
		return message;
	}
}
