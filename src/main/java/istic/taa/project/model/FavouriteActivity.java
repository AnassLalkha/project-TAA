package istic.taa.project.model;

import istic.taa.project.model.Activity;
import istic.taa.project.model.User;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favourite_activities")
public class FavouriteActivity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3652768428450238745L;
	@Id
	@GeneratedValue
	private long identifier;
	@OneToOne(targetEntity = Activity.class)
	@JoinColumn(name = "activity_fk", nullable = false, referencedColumnName = "identifier")
	private Activity activity;
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "user_fk", referencedColumnName = "identifier", nullable = false)
	private User user;

	public long getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
