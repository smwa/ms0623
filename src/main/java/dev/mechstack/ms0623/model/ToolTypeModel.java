package dev.mechstack.ms0623.model;

import java.math.BigDecimal;

public class ToolTypeModel {

  protected String toolType;
  protected BigDecimal dailyCharge;
  protected Boolean weekdayCharge;
  protected Boolean weekendCharge;
  protected Boolean holidayCharge;

  public ToolTypeModel(String toolType, BigDecimal dailyCharge, Boolean weekdayCharge, Boolean weekendCharge, Boolean holidayCharge) {
    this.toolType = toolType;
    this.dailyCharge = dailyCharge;
    this.weekdayCharge = weekdayCharge;
    this.weekendCharge = weekendCharge;
    this.holidayCharge = holidayCharge;
  }

  public String getToolType() {
    return toolType;
  }

  public BigDecimal getDailyCharge() {
    return dailyCharge;
  }

  public Boolean getWeekdayCharge() {
    return weekdayCharge;
  }

  public Boolean getWeekendCharge() {
    return weekendCharge;
  }

  public Boolean getHolidayCharge() {
    return holidayCharge;
  }

}
