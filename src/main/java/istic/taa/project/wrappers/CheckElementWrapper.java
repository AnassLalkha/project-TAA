package istic.taa.project.wrappers;

import istic.taa.project.constants.Operations;

public class CheckElementWrapper extends GenericWrapper{
	private boolean exist;
	private String checkedElement;

	public CheckElementWrapper(String element, boolean exist, String status, Operations o) {
		super(o.toString(), status);
		this.exist = exist;
		this.checkedElement = element;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public String getCheckedElement() {
		return checkedElement;
	}

	public void setCheckedElement(String checkedElement) {
		this.checkedElement = checkedElement;
	}
}
