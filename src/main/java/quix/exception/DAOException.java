package quix.exception;

public class DAOException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private final static String HEADER = "Error in DAO";

	public DAOException() {
		super(HEADER);
	}
	
	public DAOException(String message) {
		super(message);
	}
}
