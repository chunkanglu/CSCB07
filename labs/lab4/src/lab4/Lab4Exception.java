package lab4;

import java.lang.Exception;

@SuppressWarnings("serial")
public class Lab4Exception extends Exception {
	String message;
	
	public Lab4Exception(String message) {
		this.message = message;
	}
}
