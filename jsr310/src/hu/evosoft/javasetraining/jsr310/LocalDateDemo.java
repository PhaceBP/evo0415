package hu.evosoft.javasetraining.jsr310;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateDemo {

	public static void main(String[] args) {

		// The LocalDate represents a date in ISO format (yyyy-MM-dd) without time.
		LocalDate localDate = LocalDate.now();

		System.out.println("LocalDate: " + localDate);

		System.out.println(LocalDate.of(2019, 04, 16));

		System.out.println(LocalDate.parse("2019-04-16"));

		////////////////////////////////////////////////////////

		LocalDate tomorrow = LocalDate.now().plusDays(1);

		System.out.println("LocalDate +1 day : " + tomorrow);

		////////////////////////////////////////////////////////

		LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);

		System.out.println("Previous month, same day: " + previousMonthSameDay);

		////////////////////////////////////////////////////////

		DayOfWeek sunday = LocalDate.parse("2019-04-18").getDayOfWeek();

		System.out.println("Which day was at 2019-04-18 ? " + sunday);

		int twelve = LocalDate.parse("2019-04-18").getDayOfMonth();

		System.out.println("Which day was at 2016-06-12 ? " + twelve);

		/////////////////////////////////////////////////////////

		boolean leapYear = LocalDate.now().isLeapYear();

		System.out.println("Is leap year? " + leapYear);

		/////////////////////////////////////////////////////////

		boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));

		System.out.println("Not before: " + notBefore);

		boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));

		System.out.println("Is after: " + isAfter);

		////////////////////////////////////////////////////////

		LocalDate firstDayOfTheMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("First day of 2016.06: " + firstDayOfTheMonth);
		LocalDate nextMonday = LocalDate.parse("2016-06-12").with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println("Next monday: " + nextMonday);
	}

}
