package istic.taa.project.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize.Other;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "weather")

public class Weather implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -784080476239664777L;
	@JsonIgnore
	@Id
	@GeneratedValue
	private long id;

	@JsonProperty("location")
	@JoinColumn(name = "location", referencedColumnName = "identifier")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Location location;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Current.class)
	@JoinColumn(name = "current", referencedColumnName = "identifier")
	@JsonProperty("current")
	private Current current;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Current getCurrent() {
		return current;
	}

	public void setCurrent(Current current) {
		this.current = current;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int result = 33;
		int prime = 5;
		result = result + prime * ((location == null) ? 0 : location.hashCode());
		result = result + prime * ((current == null) ? 0 : current.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)  {
			return true;
		}
		if(obj == null) {
			if(this != null) {
				return false;
			}
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		Weather other = (Weather) obj;
		if(!other.location.equals(this.location) 
				|| !other.current.equals(this.current) 
				|| other.id != this.id){
			return false;
		}
		return true;
	}
}
