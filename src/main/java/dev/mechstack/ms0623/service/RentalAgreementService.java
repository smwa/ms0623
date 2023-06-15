package dev.mechstack.ms0623.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import dev.mechstack.ms0623.form.CheckoutForm;
import dev.mechstack.ms0623.model.RentalAgreementModel;
import dev.mechstack.ms0623.repository.ToolsRepository;

public class RentalAgreementService {

  public static RentalAgreementModel getRentalAgreementByCheckoutForm(CheckoutForm checkoutForm, ToolsRepository tools) throws NoSuchElementException, IOException {
    return new RentalAgreementModel(tools.get(checkoutForm.toolCode), checkoutForm.rentalDayCount, checkoutForm.discountPercent, checkoutForm.checkoutDate);
  }

  public static String getRentalAgreementPrintFormat(RentalAgreementModel rentalAgreement) {
    SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy");
    DecimalFormat decimalFormatter = new DecimalFormat("#,###.##");
    decimalFormatter.setMinimumFractionDigits(2);
    DecimalFormat integerFormatter = new DecimalFormat("#,###");

    String contents = "\nRental Agreement\n";

    contents = contents.concat(String.format("Tool code: %s\n", rentalAgreement.getToolCode()));
    contents = contents.concat(String.format("Tool type: %s\n", rentalAgreement.getToolType()));
    contents = contents.concat(String.format("Tool brand: %s\n", rentalAgreement.getToolBrand()));
    contents = contents.concat(String.format("Rental days: %s\n", integerFormatter.format(rentalAgreement.getRentalDayCount())));
    contents = contents.concat(String.format("Check out date: %s\n", dateFormatter.format(rentalAgreement.getCheckoutDate())));
    contents = contents.concat(String.format("Due date: %s\n", dateFormatter.format(rentalAgreement.getDueDate())));
    contents = contents.concat(String.format("Daily rental charge: $%s\n", decimalFormatter.format(rentalAgreement.getDailyRentalCharge())));
    contents = contents.concat(String.format("Charge days: %s\n", integerFormatter.format(rentalAgreement.getChargeableDayCount())));
    contents = contents.concat(String.format("Pre-discount charge: $%s\n", decimalFormatter.format(rentalAgreement.getPrediscountCharge())));
    contents = contents.concat(String.format("Discount percent: %s%%\n", integerFormatter.format(new BigDecimal(rentalAgreement.getDiscountPercent()))));
    contents = contents.concat(String.format("Discount amount: $%s\n", decimalFormatter.format(rentalAgreement.getDiscountAmount())));
    contents = contents.concat(String.format("Final charge: $%s\n", decimalFormatter.format(rentalAgreement.getFinalCharge())));
    
    contents.concat("\n");

    return contents;
  }
}
