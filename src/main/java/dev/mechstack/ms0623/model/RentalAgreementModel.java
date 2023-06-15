package dev.mechstack.ms0623.model;

import java.math.BigDecimal;
import java.util.Date;

import dev.mechstack.ms0623.cli.RentalAgreementCLI;

public class RentalAgreementModel {

  protected String toolCode;
  protected String toolType;
  protected String toolBrand;
  protected Integer rentalDayCount;
  protected Date checkoutDate;
  protected Date dueDate;
  protected BigDecimal dailyRentalCharge;
  protected Integer chargeableDayCount;
  protected BigDecimal prediscountCharge;
  protected Integer discountPercent;
  protected BigDecimal discountAmount;
  protected BigDecimal finalCharge;

  public RentalAgreementModel(ToolModel tool, Integer rentalDayCount, Integer discountPercent, Date checkoutDate) {
    toolCode = tool.getToolCode();
    toolType = tool.getToolType().getToolType();
    toolBrand = tool.getBrand();
    this.rentalDayCount = rentalDayCount;
    this.checkoutDate = checkoutDate;
    dailyRentalCharge = tool.getToolType().getDailyCharge();

    // TODO
    dueDate = checkoutDate;
    chargeableDayCount = 1;
    prediscountCharge = new BigDecimal(2000003);
    this.discountPercent = discountPercent;
    discountAmount = new BigDecimal(2651616191.23);
    finalCharge = new BigDecimal(0055156165);
  }

  public String getToolCode() {
    return toolCode;
  }

  public String getToolType() {
    return toolType;
  }

  public String getToolBrand() {
    return toolBrand;
  }

  public Integer getRentalDayCount() {
    return rentalDayCount;
  }

  public Date getCheckoutDate() {
    return checkoutDate;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public BigDecimal getDailyRentalCharge() {
    return dailyRentalCharge;
  }

  public Integer getChargeableDayCount() {
    return chargeableDayCount;
  }

  public BigDecimal getPrediscountCharge() {
    return prediscountCharge;
  }

  public Integer getDiscountPercent() {
    return discountPercent;
  }

  public BigDecimal getDiscountAmount() {
    return discountAmount;
  }

  public BigDecimal getFinalCharge() {
    return finalCharge;
  }

  public void print() {
    RentalAgreementCLI.print(this);
  }

}
