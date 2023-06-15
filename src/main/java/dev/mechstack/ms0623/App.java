package dev.mechstack.ms0623;

import java.io.IOException;
import java.util.Scanner;

import dev.mechstack.ms0623.cli.CheckoutCLI;
import dev.mechstack.ms0623.cli.RentalAgreementCLI;
import dev.mechstack.ms0623.form.CheckoutForm;
import dev.mechstack.ms0623.model.RentalAgreementModel;
import dev.mechstack.ms0623.repository.ToolTypesRepository;
import dev.mechstack.ms0623.repository.ToolsRepository;
import dev.mechstack.ms0623.service.RentalAgreementService;

public class App 
{
  public static void main( String[] args )
  {

    ToolTypesRepository toolTypes = new ToolTypesRepository("/toolTypes.json");

    ToolsRepository tools = new ToolsRepository(toolTypes, "/tools.json");

    Scanner scanner = new Scanner(System.in);
    try {
      while (true) {
        CheckoutForm checkoutForm = CheckoutCLI.checkoutForm(scanner, tools);
        RentalAgreementModel rentalAgreement = RentalAgreementService.getRentalAgreementByCheckoutForm(checkoutForm, tools);
        RentalAgreementCLI.print(rentalAgreement);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    scanner.close();
  }
}
