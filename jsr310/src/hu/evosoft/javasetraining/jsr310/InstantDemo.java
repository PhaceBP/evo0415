package hu.evosoft.javasetraining.jsr310;

import java.time.Duration;
import java.time.Instant;

public class InstantDemo {

	public static void main(String[] args) {

		// Get the current time
		Instant instant = Instant.now();
		// Output format is ISO-8601
		System.out.println(instant);
		

		// Create from a String
		instant = Instant.parse("1995-10-23T10:12:35Z");
		
		System.out.println(instant);
		
		///////////////////////////////////////////////////////
		
		instant = Instant.now();
		instant.plus(Duration.ofHours(5).plusMinutes(4));
		
		System.out.println(instant);
		

	}

}
