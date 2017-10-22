package istic.taa.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "t_condition")
public class Condition implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4862471128669929739L;
	@JsonIgnore
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "description")
	@JsonProperty("text")
	private String desc;
	@Column(name = "image_resource")
	@JsonProperty("icon")
	private String icon;
	@Column(name = "code")
	@JsonProperty("code")
	private String code;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
