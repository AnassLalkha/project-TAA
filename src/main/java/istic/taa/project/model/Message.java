package istic.taa.project.model;

import istic.taa.project.constants.Constants;

public class Message {
	private boolean isConfirmation = false;
	private String username;
	private String subject;
	private String email;
	private static final String CONFIRM_TEMPLATE = "<div><p>Hello $0,<br/><br/></p><p>Your account have beeb created to validate your email click on this link <a href=\"$1\"</p><br/><p>Best regards</p>";
	private static final String DELETE_TEMPLTE = "<div>Hello $0, <bt/></div> We are sorry that you leave us.<br/> please click on this email if you are really sure you want delete your accout <a href \"$1\"</div><br/><p>Best regards<p>";

	public Message(String username, boolean isConfirmation, String email) {
		this.username = username;
		this.isConfirmation = isConfirmation;
		this.email = email;
		if (isConfirmation) {
			this.subject = Constants.SUBJECT_CONFIRM_ACCOUNT;
		} else {
			this.subject = Constants.SUBJECT_DELETE_ACCOUNT;
		}
	}

	public String getEmail() {
		return this.email;
	}

	public String getSubject() {
		return subject;
	}

	public String doTemplate() {
		if (isConfirmation) {
			return CONFIRM_TEMPLATE.replace("$0", username).replaceAll("$1", buildLinkConfirmation());
		}
		return DELETE_TEMPLTE.replace("$0", username).replaceAll("$1", buildLinkDelete());
	}

	private String buildLinkDelete() {
		return "";
	}

	private String buildLinkConfirmation() {
		return "";
	}
}
