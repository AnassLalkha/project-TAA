package istic.taa.project.model;

import istic.taa.project.model.Location;
import istic.taa.project.model.Weather;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity {
	@Id
	@GeneratedValue
	private long identifier;
	@Column(length = 500)
	private String description;
	@Column
	private String name;
	@Column
	private String image;
	@OneToMany
	@JoinColumn(name = "adequate_weather")
	private List<Weather> adequateWeather;
	@OneToMany
	@JoinColumn(name = "location")
	private List<Location> locations;

	public long getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Weather> getAdequateWeather() {
		return this.adequateWeather;
	}

	public void setAdequateWeather(List<Weather> adequateWeather) {
		this.adequateWeather = adequateWeather;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
}
