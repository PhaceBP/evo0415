package hu.evosoft.javasetraining.annotations;

import hu.evosoft.javasetraining.annotations.Todo.Level;

@Todo(description = "Really important task!", level = Level.CRITICAL)
public class Task {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
