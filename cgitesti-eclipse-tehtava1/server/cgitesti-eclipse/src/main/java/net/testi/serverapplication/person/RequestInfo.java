package net.testi.serverapplication.person;

public class RequestInfo {
	private String message;
	
	public RequestInfo(String m) {
		this.message=m;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
