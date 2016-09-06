package studentSolution.exception;

/**
 * @author alex.gomez
 *
 */
public class StudentSolutionException extends Exception {

	private static final long serialVersionUID = -4712577972249554195L;

	private String userMessage;

	public StudentSolutionException() {
		super();
	}

	/**
	 * @param message
	 */
	public StudentSolutionException(String userMessage) {
		super();
		this.userMessage = userMessage;
	}

	/**
	 * @return the userMessage
	 */
	public String getUserMessage() {
		return userMessage;
	}

	/**
	 * @param userMessage
	 *            the userMessage to set
	 */
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
}
