package hu.evosoft.javasetraining.jsr310;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class LocalDateTimeDemo {

	public static void main(String[] args) {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		// Jump to 25 hours and 3 minutes into the future
		LocalDateTime inTheFuture = localDateTime.plusHours(25).plusMinutes(3);
		
		System.out.println(inTheFuture);
		
		// We could do the same on localTime or localDate
		System.out.println(localDateTime.toLocalTime().plusHours(25).plusMinutes(3));
		System.out.println(localDateTime.toLocalDate().plusMonths(2));
		
		
		// We could also use TemportalAmount (in this case a Duration and Period)
		System.out.println(localDateTime.toLocalTime().plus(Duration.ofHours(25).plusMinutes(3)));
		System.out.println(localDateTime.toLocalDate().plus(Period.ofMonths(2)));

	}

}
