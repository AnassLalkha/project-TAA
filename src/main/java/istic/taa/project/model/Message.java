package istic.taa.project.model;

import istic.taa.project.constants.Constants;

public class Message {
	private String type;
	private String username;
	private String subject;
	private String email;
	private User user;
	private static final String CONFIRM_TEMPLATE = "<div><p>Hello $0,<br/><br/></p><p>Your account have beeb created to validate your email click on this link <a href=\"$1\"</p><br/><p>Best regards</p>";
	private static final String DELETE_TEMPLTE = "<div>Hello $0, <bt/></div> We are sorry that you leave us.<br/> please click on this email if you are really sure you want delete your accout <a href \"$1\"</div><br/><p>Best regards<p>";

	public Message(String username, String type, String email) {
		this.username = username;
		this.email = email;
		if (type.equals("u")) {
		} else if (type.equals("d")) {
			this.subject = Constants.SUBJECT_DELETE_ACCOUNT;
		}
	}

	public Message(User user, String type) {
		this.user = user;
		this.type = type;
		if (type.equals("c")) {
			this.subject = Constants.SUBJECT_CONFIRM_ACCOUNT;
		} else if (type.equals("d")) {
			this.subject = Constants.SUBJECT_DELETE_ACCOUNT;
		}

	}

	public String getEmail() {
		if (email == null) {
			return this.user.getEmail();
		} else {
			return this.email;
		}
	}

	public String getSubject() {
		return subject;
	}

	public String doTemplate() {
		if (type.equals("c")) {
			return CONFIRM_TEMPLATE.replace("$0", getUsername()).replace("$1", buildLinkConfirmation());
		} else if (type.equals("d")) {
			return DELETE_TEMPLTE.replace("$0", getUsername()).replace("$1", buildLinkDelete());
		} else {
			return "";
		}
	}

	private String buildLinkDelete() {
		return "";
	}

	public String getUsername() {
		if (this.username == null) {
			this.username = user.getUsername();
		}
		return username;
	}

	private String buildLinkConfirmation() {
		return "http://localhost:8080/interface/v1/perm/validate-mail?q=" + this.user.getValidationCode();
	}
}
