package by.epam.tc.news_handler.exception;

public class ServiceException  extends Exception{
	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}

}
