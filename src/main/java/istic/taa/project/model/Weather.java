package istic.taa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weather")
public class Weather {
	@Id
	@GeneratedValue
	private long identifier;
	@Column
	private String title;
	@Column
	private double minWindCondition;
	@Column
	private double minTemperature;
	@Column
	private double minPluviometry;
	@Column
	private double minSunshine;
	@Column
	private double maxWindCondition;
	@Column
	private double maxTemperature;
	@Column
	private double maxPluviometry;
	@Column
	private double maxSunshine;

	public long getIdentifier() {
		return this.identifier;
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
