package istic.taa.project.wrappers;

public class CheckElementWrapper {
	private boolean exist;
	private String checkedElement;

	public CheckElementWrapper(String element, boolean exist) {
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
