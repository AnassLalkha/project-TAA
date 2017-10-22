package istic.taa.project.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "t_current")
@JsonIgnoreProperties(value = { "temp_f", "wind_mph", "pressure_in", "precip_in", "feelslike_f", "vis_km",
		"vis_miles" })
public class Current implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5706135141028050008L;
	@JsonIgnore
	@GeneratedValue
	@Id
	private long identifier;
	@JsonProperty("last_updated_epoch")
	@Column(name = "last_updated_epoch")
	Long lastUpdateEpoch;
	@JsonProperty("last_updated")
	@Column(name = "last_updated")
	String lastUpdated;
	@Column(name = "temp_c", columnDefinition="Decimal(10,2)")
	@JsonProperty("temp_c")
	private double temperature;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "condition_fk", referencedColumnName = "id")
	@JsonProperty("condition")
	private Condition condition;
	@JsonProperty("wind_kph")
	@Column(name = "wind_kph", columnDefinition="Decimal(10,2)")
	private double windSpeed;
	@JsonProperty("wind_degree")
	@Column(name = "wind_degree", columnDefinition="Decimal(10,2)")
	private double windDegress;
	@JsonProperty("wind_dir")
	@Column(name = "wind_dir")
	private String windDir;
	@JsonProperty("pressure_mb")
	@Column(name = "pressure_mb", columnDefinition="Decimal(10,2)")
	private double pressure;
	@JsonProperty("precip_mm")
	@Column(name = "precip_mm", columnDefinition="Decimal(10,2)")
	private double precipitation;
	@JsonProperty("humidity")
	@Column(name = "humidity", columnDefinition="Decimal(10,2)")
	private double humidity;
	@JsonProperty("feelslike_c")
	@Column(name = "feelslike_c", columnDefinition="Decimal(10,2)")
	private double feelsLike;
	@JsonProperty("cloud")
	@Column(name = "cloud", columnDefinition="Decimal(10,2)")
	private double cloud;

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getWindDegress() {
		return windDegress;
	}

	public void setWindDegress(double windDegress) {
		this.windDegress = windDegress;
	}

	public String getWindDir() {
		return windDir;
	}

	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}

	@JsonProperty("is_day")
	private int isDay;

	public long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}

	public Long getLastUpdateEpoch() {
		return lastUpdateEpoch;
	}

	public void setLastUpdateEpoch(Long lastUpdateEpoch) {
		this.lastUpdateEpoch = lastUpdateEpoch;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public int getIsDay() {
		return isDay;
	}

	public void setIsDay(int isDay) {
		this.isDay = isDay;
	}

}
