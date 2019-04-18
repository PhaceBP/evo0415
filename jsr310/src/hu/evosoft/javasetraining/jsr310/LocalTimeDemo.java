package hu.evosoft.javasetraining.jsr310;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalTime now = LocalTime.now();

		System.out.println("LocalTime now: " + now);

		////////////////////////////////////////////

		LocalTime sixThirty = LocalTime.parse("06:30");
		LocalTime sixThirty2 = LocalTime.of(6, 30);

		System.out.println("LocalTime sixThirty: " + sixThirty);
		System.out.println("LocalTime sixThirty2: " + sixThirty2);

		////////////////////////////////////////////

		LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);

		System.out.println("LocalTime sevenThirty: " + sevenThirty);

		////////////////////////////////////////////

		int six = LocalTime.parse("06:30").getHour();

		System.out.println("LocalTime sixThirty only hour: " + six);
		
		////////////////////////////////////////////
		
		boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
		
		System.out.println("LocalTime sixThirty is before sevenThirty: " + isbefore);
		
		
		////////////////////////////////////////////
		
		LocalTime maxTime = LocalTime.MAX;
				
		System.out.println("LocalTime MAX: " + maxTime);

	}

}
