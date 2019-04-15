package hu.evosoft.javasetraining.annotations;

public class Secure {

	private int level;

	private Secure other;
	
	public Secure(int level) {
		this.level = level;
		other = new Secure(level + 1);
	}

	public Secure(Secure other) {

		this.level = other.level;
	}
}
