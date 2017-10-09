package istic.taa.project.model;

import istic.taa.project.model.Activity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue
	private long identifier;
	@Column
	private String name;
	@ManyToOne(targetEntity = Activity.class)
	@JoinColumn(name = "available_activity_fk")
	private List<Activity> availableActivities;
	@Column
	private String longitude;
	@Column
	private String lattitude;

	public long getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Activity> getAvailableActivities() {
		return this.availableActivities;
	}

	public void setAvailableActivities(List<Activity> availableActivities) {
		this.availableActivities = availableActivities;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLattitude() {
		return this.lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
}
