package istic.taa.project.model;

import istic.taa.project.model.FavouriteLocation;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, unique = true)
	private String email;
	@Id
	@GeneratedValue
	@Column(nullable = false, unique = true)
	private long identifier;
	@ManyToOne(targetEntity = FavouriteLocation.class)
	@JoinColumn(name = "favourite_location_fk", referencedColumnName = "identifier")
	private List<FavouriteLocation> favouriteLocations;
	@Column(name = "deletion_code", nullable = true)
	private String deletionCode;

	public String getDeletionCode() {
		return deletionCode;
	}

	public void setDeletionCode(String deletionCode) {
		this.deletionCode = deletionCode;
	}

	public boolean isValidatedMail() {
		return validatedMail;
	}

	public void setValidatedMail(boolean validatedMail) {
		this.validatedMail = validatedMail;
	}

	@Column(name = "validated_mail", nullable = true)
	private boolean validatedMail;

	public User(String username, String password, String mail) {
		this.username = username;
		this.password = password;
		this.email = mail;
		this.validatedMail = false;
	}

	public User() {
		this.validatedMail = false;
	}

	public List<FavouriteLocation> getFavouriteLocations() {
		return this.favouriteLocations;
	}

	public void setFavouriteLocations(List<FavouriteLocation> favouriteLocations) {
		this.favouriteLocations = favouriteLocations;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}
}
