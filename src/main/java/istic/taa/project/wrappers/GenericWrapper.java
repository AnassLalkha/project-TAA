package istic.taa.project.wrappers;

public class GenericWrapper {
	protected String operation;
	protected String status;
	protected String token;

	public GenericWrapper(String o, String s) {
		this.operation = o;
		this.status = s;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
