package com.intellias.lesson24;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndTime {
    public static void main(String[] args) {
//        new Date() - do not use
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(LocalDate.of(2022, Month.DECEMBER, 29));
        System.out.println(LocalDate.parse("2015-10-25"));

        System.out.println(localDate.plus(5, ChronoUnit.DAYS));
        System.out.println(localDate.plusDays(5));
        System.out.println(localDate.atStartOfDay());
        System.out.println("day of week: " + localDate.getDayOfWeek());
        System.out.println("day of month: " + localDate.getDayOfMonth());
        System.out.println("is leap year: " + localDate.isLeapYear());

        System.out.println(LocalDate.parse("2016-06-12").isBefore(LocalDate.of(2016, 6, 11)));
        System.out.println(LocalDate.parse("2016-06-12").isAfter(LocalDate.of(2016, 6, 11)));

        System.out.println();
        System.out.println("LocalDateTime:");
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.AUGUST, 12, 12, 55);
        System.out.println(localDateTime);

        System.out.println();
        System.out.println("ZonedId:");
        ZoneId.getAvailableZoneIds().stream()
                .forEach(System.out::println);
        ZoneId paris = ZoneId.of("Europe/Paris");
        System.out.println(paris);
        System.out.println(ZonedDateTime.of(localDateTime, paris));
        System.out.println(ZonedDateTime.of(localDateTime, paris).toInstant());
        ZoneId pacific = ZoneId.of("US/Pacific");
        System.out.println(pacific);
        System.out.println(ZonedDateTime.of(localDateTime, pacific));
        System.out.println(ZonedDateTime.of(localDateTime, pacific).toInstant());

        System.out.println();
        System.out.println("Duration:");
        LocalTime now = LocalTime.now();
        System.out.println(Duration.between(now, now.plusHours(1)));
        System.out.println(Period.between(localDate, localDate.plusDays(2)));

        System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        System.out.println(LocalDateTime.ofInstant(new GregorianCalendar().toInstant(), ZoneId.systemDefault()));
    }
}
