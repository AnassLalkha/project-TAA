package istic.taa.project.exceptions;

public class TechnicalException extends IllegalArgumentException {
	private static final long serialVersionUID = -751001876576004007L;

	public TechnicalException(String str, Throwable e) {
		super(str, e);
	}

	public TechnicalException(String str) {
		super(str);
	}
}
