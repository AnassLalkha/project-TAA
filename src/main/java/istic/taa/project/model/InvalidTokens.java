package istic.taa.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invalid_tokens")
public class InvalidTokens {
	@Id
	@GeneratedValue
	private Long identifier;
	@Column(name = "value", unique = true, nullable = false, length = 600)
	private String value;
	@JoinColumn(referencedColumnName = "username")
	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private User user;

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public InvalidTokens() {

	}

	public InvalidTokens(String v, User u) {
		this.value = v;
		this.user = u;
	}
}
