package dev.mechstack.ms0623.cli;

import dev.mechstack.ms0623.model.RentalAgreementModel;
import dev.mechstack.ms0623.service.RentalAgreementService;

public class RentalAgreementCLI {
  public static void print(RentalAgreementModel rentalAgreement) {
    System.out.println(RentalAgreementService.getRentalAgreementPrintFormat(rentalAgreement));
  }
}
