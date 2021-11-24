/**
 * Exception to be thrown when the length of a string exceeds a specified upper
 * limit. Constructs a StringTooLongException with the specified detail message.
 * 
 * @author lschoch
 * @version 1.0 CS-131-ON Lab4
 */
@SuppressWarnings("serial")
public class StringTooLongException extends Exception {
	StringTooLongException(String message) {
		super(message);
	}// end constructor

}// end class
