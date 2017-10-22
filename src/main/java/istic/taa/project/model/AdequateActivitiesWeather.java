package istic.taa.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adequate_activities_weather")
public class AdequateActivitiesWeather implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5366553612071251343L;
	@Id
	@GeneratedValue
	private long identifier;
	@Column(name = "title")
	private String title;
	@Column(name = "min_wind_condtion")
	private double minWindCondition;
	@Column(name = "min_temperature")
	private double minTemperature;
	@Column(name = "min_pluviometry")
	private double minPluviometry;
	@Column(name = "min_sunshine")
	private double minSunshine;
	@Column(name = "max_wind_condition")
	private double maxWindCondition;
	@Column(name = "max_temperature")
	private double maxTemperature;
	@Column(name = "max_pluviometry")
	private double maxPluviometry;
	@Column(name = "max_sunshine")
	private double maxSunshine;
	@Column(name = "min_humidity")
	private Double minHumidity;
	@Column(name = "max_humidity")
	private Double maxHumidity;
	
	public long getIdentifier() {
		return this.identifier;
	}
	
	public Double getMinHumidity() {
		return minHumidity;
	}

	public void setMinHumidity(Double minHumidity) {
		this.minHumidity = minHumidity;
	}

	public Double getMaxHumidity() {
		return maxHumidity;
	}

	public void setMaxHumidity(Double maxHumidity) {
		this.maxHumidity = maxHumidity;
	}

	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getMinWindCondition() {
		return this.minWindCondition;
	}

	public void setMinWindCondition(double minWindCondition) {
		this.minWindCondition = minWindCondition;
	}

	public double getMinTemperature() {
		return this.minTemperature;
	}

	public void setMinTemperature(double minTemperature) {
		this.minTemperature = minTemperature;
	}

	public double getMinPluviometry() {
		return this.minPluviometry;
	}

	public void setMinPluviometry(double minPluviometry) {
		this.minPluviometry = minPluviometry;
	}

	public double getMinSunshine() {
		return this.minSunshine;
	}

	public void setMinSunshine(double minSunshine) {
		this.minSunshine = minSunshine;
	}

	public double getMaxWindCondition() {
		return this.maxWindCondition;
	}

	public void setMaxWindCondition(double maxWindCondition) {
		this.maxWindCondition = maxWindCondition;
	}

	public double getMaxTemperature() {
		return this.maxTemperature;
	}

	public void setMaxTemperature(double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public double getMaxPluviometry() {
		return this.maxPluviometry;
	}

	public void setMaxPluviometry(double maxPluviometry) {
		this.maxPluviometry = maxPluviometry;
	}

	public double getMaxSunshine() {
		return this.maxSunshine;
	}

	public void setMaxSunshine(double maxSunshine) {
		this.maxSunshine = maxSunshine;
	}
}
