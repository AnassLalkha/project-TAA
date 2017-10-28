package istic.taa.project.wrappers;

import java.util.List;

import istic.taa.project.constants.Operations;
import istic.taa.project.model.Weather;

public class WeatherWrapper extends GenericWrapper {
	private List<Weather> list;

	public WeatherWrapper(Operations o, String status, List<Weather> l) {
		super(o.toString(), status);
		this.list = l;
	}

	public List<Weather> getList() {
		return list;
	}

	public void setList(List<Weather> list) {
		this.list = list;
	}
}
