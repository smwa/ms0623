package dev.mechstack.ms0623.service;

import java.util.Calendar;

public class CalendarService {

  public static Boolean isWeekday(Calendar calendar) {
    return !isWeekend(calendar);
  }

  public static Boolean isWeekend(Calendar calendar) {
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    return day == Calendar.SATURDAY || day == Calendar.SUNDAY;
  }

  public static Boolean isHoliday(Calendar calendar) {
    Calendar laborDay = Calendar.getInstance();
    laborDay.setTime(calendar.getTime());
    laborDay.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    laborDay.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
    laborDay.set(Calendar.MONTH, Calendar.SEPTEMBER);

    if (laborDay.equals(calendar)) {
      return true;
    }

    Calendar independenceDay = Calendar.getInstance();
    independenceDay.setTime(calendar.getTime());
    independenceDay.set(Calendar.MONTH, Calendar.JULY);
    independenceDay.set(Calendar.DAY_OF_MONTH, 4);
    int independenceDayOfWeek = independenceDay.get(Calendar.DAY_OF_WEEK);
    if (independenceDayOfWeek == Calendar.SATURDAY) {
      independenceDay.add(Calendar.DAY_OF_YEAR, -1);
    }
    else if (independenceDayOfWeek == Calendar.SUNDAY) {
      independenceDay.add(Calendar.DAY_OF_YEAR, 1);
    }

    if (independenceDay.equals(calendar)) {
      return true;
    }

    return false;
  }

}
