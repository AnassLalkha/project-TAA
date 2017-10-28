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
	private int result;
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

	@Override
	public int hashCode() {
		result = 54;
		int prime = 1;
		result = result + prime * ((name == null) ? 0 : name.hashCode());
		result = result + prime * ((localtime == null) ? 0 : localtime.hashCode());
		result = result + prime * ((country == null) ? 0 : country.hashCode());
		result = result + prime * ((lattitude == null) ? 0 : lattitude.hashCode());
		result = result + prime * ((longitude == null) ? 0 : longitude.hashCode());
		result = result + prime * ((region == null) ? 0 : region.hashCode());
		result = result + prime * ((weatherFk == null) ? 0 : weatherFk.hashCode());
		availableActivities.stream().forEach(fa -> 
			result = result + prime * ((fa == null) ? 0 : fa.hashCode())
		);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		Location other = (Location) obj;
		if (!other.name.equals(this.name) || !other.localtime.equals(this.localtime)
				|| !other.country.equals(this.country) || !other.lattitude.equals(this.lattitude)
				|| !other.longitude.equals(this.longitude) || !other.region.equals(this.region)
				|| !other.weatherFk.equals(this.weatherFk) || other.identifier != this.identifier) {
			return false;
		}
		return (this.availableActivities.equals(other.availableActivities));
	}
}
