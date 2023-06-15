package dev.mechstack.ms0623.form;

import java.util.Date;

import dev.mechstack.ms0623.exception.ValidationException;

public class CheckoutForm {
  public String toolCode = "";
  public Integer rentalDayCount = 0;
  public Integer discountPercent = 0;
  public Date checkoutDate;

  public void validate() throws ValidationException {
    if (toolCode.length() != 4) {
      throw new ValidationException("The tool code must be a valid tool.");
    }
    if (rentalDayCount < 1) {
      throw new ValidationException("Number of rental days must be at least 1.");
    }
    if (discountPercent < 0 || discountPercent > 100) {
      throw new ValidationException("The discount percent must be at least 0, and at most 100. If unsure, enter 0.");
    }
    if (checkoutDate == null) {
      throw new ValidationException("You must enter a checkout date. Use the format mm/dd/yy where mm is the month with 2 digits(like 01 or 12), dd is the day with 2 digits(like 09 or 31), and yy is the year with 2 digits(like 23 for 2023 or 15 for 2015).");
    }
  }
}
