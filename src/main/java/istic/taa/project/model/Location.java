package istic.taa.project.model;

import istic.taa.project.model.Activity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "location")
public class Location implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1815064957611545771L;
	@JsonIgnore
	@Id
	@GeneratedValue
	private long identifier;
	@JsonProperty("name")
	@Column
	private String name;
	@JsonProperty
	@ManyToOne(targetEntity = Activity.class)
	@JoinColumn(name = "available_activity_fk")
	private List<Activity> availableActivities;
	@JsonProperty("lon")
	@Column
	private String longitude;
	@JsonProperty("lat")
	@Column
	private String lattitude;
	@Column(name = "local_time")
	@JsonProperty("localtime")
	private String localtime;
	@JsonProperty("localtime_epoch")
	private String localtimeEpoch;
	@JsonProperty("tz_id")
	private String tzId;
	@Column(name = "country")
	@JsonProperty("country")
	private String country;
	@Column(name = "region")
	@JsonProperty("region")
	private String region;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "weather_fk", nullable = true)
	private Weather weatherFk;

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

	public String getLocaltime() {
		return localtime;
	}

	public void setLocaltime(String localtime) {
		this.localtime = localtime;
	}

	public String getLocaltimeEpoch() {
		return localtimeEpoch;
	}

	public void setLocaltimeEpoch(String localtimeEpoch) {
		this.localtimeEpoch = localtimeEpoch;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Weather getWeatherFk() {
		return weatherFk;
	}

	public void setWeatherFk(Weather weatherFk) {
		this.weatherFk = weatherFk;
	}

	public String getTzId() {
		return tzId;
	}

	public void setTzId(String tzId) {
		this.tzId = tzId;
	}

}
