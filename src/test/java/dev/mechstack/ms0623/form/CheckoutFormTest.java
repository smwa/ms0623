package dev.mechstack.ms0623.form;

import org.junit.Test;

import dev.mechstack.ms0623.exception.ValidationException;

public class CheckoutFormTest {

  @Test(expected = ValidationException.class)
  public void emptyForm() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.validate();
  }

  @Test(expected = ValidationException.class)
  public void cannedTest1() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKR";
    form.setCheckoutDate("9/3/15");
    form.rentalDayCount = 5;
    form.discountPercent = 101;
    form.validate();
  }

  @Test
  public void cannedTest2() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "LADW";
    form.setCheckoutDate("7/2/20");
    form.rentalDayCount = 3;
    form.discountPercent = 10;
    form.validate();
  }

  @Test
  public void cannedTest3() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "CHNS";
    form.setCheckoutDate("7/2/15");
    form.rentalDayCount = 5;
    form.discountPercent = 25;
    form.validate();
  }

  @Test
  public void cannedTest4() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKD";
    form.setCheckoutDate("9/3/15");
    form.rentalDayCount = 6;
    form.discountPercent = 0;
    form.validate();
  }

  @Test
  public void cannedTest5() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKR";
    form.setCheckoutDate("7/2/15");
    form.rentalDayCount = 9;
    form.discountPercent = 0;
    form.validate();
  }

  @Test
  public void cannedTest6() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKR";
    form.setCheckoutDate("7/2/20");
    form.rentalDayCount = 4;
    form.discountPercent = 50;
    form.validate();
  }

  @Test
  public void happyPathBaseline() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKR";
    form.setCheckoutDate("7/2/20");
    form.rentalDayCount = 1;
    form.discountPercent = 0;
    form.validate();
  }

  @Test(expected = ValidationException.class)
  public void toolCodeTooLong() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKRR";
    form.setCheckoutDate("7/2/20");
    form.rentalDayCount = 1;
    form.discountPercent = 0;
    form.validate();
  }

  @Test(expected = ValidationException.class)
  public void rentalDayCountZero() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKR";
    form.setCheckoutDate("7/2/20");
    form.rentalDayCount = 0;
    form.discountPercent = 0;
    form.validate();
  }

  @Test(expected = ValidationException.class)
  public void discountPercentNegative() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKR";
    form.setCheckoutDate("7/2/20");
    form.rentalDayCount = 1;
    form.discountPercent = -1;
    form.validate();
  }

  @Test(expected = ValidationException.class)
  public void discountPercentOverOneHundred() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKR";
    form.setCheckoutDate("7/2/20");
    form.rentalDayCount = 1;
    form.discountPercent = 101;
    form.validate();
  }

  @Test(expected = ValidationException.class)
  public void invalidDate() throws ValidationException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKR";
    form.setCheckoutDate("13/2/20");
    form.rentalDayCount = 1;
    form.discountPercent = 0;
    form.validate();
  }
  
}
