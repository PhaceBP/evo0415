package hu.evosoft.javasetraining.reflection.lab1;

import java.io.Serializable;
import java.util.Date;

public class ReflectionLab implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Date timeStamp;
	public Boolean isValid;

	public ReflectionLab(String id) {
		this.id = id;
	}

	public ReflectionLab() {
	}

	public boolean accessGranted() {
		return isValid;
	}

	public String getId() {
		return id;
	}

	@Secure(role = Roles.ADMIN)
	public void setId(String id) {
		this.id = id;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(@Secure Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
}
