package dev.mechstack.ms0623.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.junit.Test;

import dev.mechstack.ms0623.exception.ValidationException;
import dev.mechstack.ms0623.form.CheckoutForm;
import dev.mechstack.ms0623.repository.ToolTypesRepository;
import dev.mechstack.ms0623.repository.ToolsRepository;

public class RentalAgreementServiceTest {
  
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
  public void cannedTest2() throws ValidationException, NoSuchElementException, IOException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "LADW";
    form.setCheckoutDate("7/2/20");
    form.rentalDayCount = 3;
    form.discountPercent = 10;
    form.validate();

    ToolTypesRepository toolTypes = new ToolTypesRepository("/toolTypes.json");
    ToolsRepository tools = new ToolsRepository(toolTypes, "/tools.json");

    String agreementContents = RentalAgreementService.getRentalAgreementPrintFormat(RentalAgreementService.getRentalAgreementByCheckoutForm(form, tools));

    String newLine = "\n";
    String expectedAgreementContents = new StringBuilder()

      .append(newLine)
      .append("Rental Agreement").append(newLine)

      .append("Tool code: LADW").append(newLine)
      .append("Tool type: Ladder").append(newLine)
      .append("Tool brand: Werner").append(newLine)
      .append("Rental days: 3").append(newLine)
      .append("Check out date: 07/02/20").append(newLine)
      .append("Due date: 07/05/20").append(newLine)
      .append("Daily rental charge: $1.99").append(newLine)
      .append("Charge days: 2").append(newLine)
      .append("Pre-discount charge: $3.98").append(newLine)
      .append("Discount percent: 10%").append(newLine)
      .append("Discount amount: $0.40").append(newLine)
      .append("Final charge: $3.58").append(newLine)

      .toString();
    assertEquals("Rental agreement printable form matches", expectedAgreementContents, agreementContents);
  }
  
  @Test
  public void cannedTest3() throws ValidationException, NoSuchElementException, IOException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "CHNS";
    form.setCheckoutDate("7/2/15");
    form.rentalDayCount = 5;
    form.discountPercent = 25;
    form.validate();

    ToolTypesRepository toolTypes = new ToolTypesRepository("/toolTypes.json");
    ToolsRepository tools = new ToolsRepository(toolTypes, "/tools.json");

    String agreementContents = RentalAgreementService.getRentalAgreementPrintFormat(RentalAgreementService.getRentalAgreementByCheckoutForm(form, tools));

    String newLine = "\n";
    String expectedAgreementContents = new StringBuilder()

      .append(newLine)
      .append("Rental Agreement").append(newLine)

      .append("Tool code: CHNS").append(newLine)
      .append("Tool type: Chainsaw").append(newLine)
      .append("Tool brand: Stihl").append(newLine)
      .append("Rental days: 5").append(newLine)
      .append("Check out date: 07/02/15").append(newLine)
      .append("Due date: 07/07/15").append(newLine)
      .append("Daily rental charge: $1.49").append(newLine)
      .append("Charge days: 3").append(newLine)
      .append("Pre-discount charge: $4.47").append(newLine)
      .append("Discount percent: 25%").append(newLine)
      .append("Discount amount: $1.12").append(newLine)
      .append("Final charge: $3.35").append(newLine)

      .toString();
    assertEquals("Rental agreement printable form matches", expectedAgreementContents, agreementContents);
  }
  
  @Test
  public void cannedTest4() throws ValidationException, NoSuchElementException, IOException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKD";
    form.setCheckoutDate("9/3/15");
    form.rentalDayCount = 6;
    form.discountPercent = 0;
    form.validate();

    ToolTypesRepository toolTypes = new ToolTypesRepository("/toolTypes.json");
    ToolsRepository tools = new ToolsRepository(toolTypes, "/tools.json");

    String agreementContents = RentalAgreementService.getRentalAgreementPrintFormat(RentalAgreementService.getRentalAgreementByCheckoutForm(form, tools));

    String newLine = "\n";
    String expectedAgreementContents = new StringBuilder()

      .append(newLine)
      .append("Rental Agreement").append(newLine)

      .append("Tool code: JAKD").append(newLine)
      .append("Tool type: Jackhammer").append(newLine)
      .append("Tool brand: DeWalt").append(newLine)
      .append("Rental days: 6").append(newLine)
      .append("Check out date: 09/03/15").append(newLine)
      .append("Due date: 09/09/15").append(newLine)
      .append("Daily rental charge: $2.99").append(newLine)
      .append("Charge days: 3").append(newLine)
      .append("Pre-discount charge: $8.97").append(newLine)
      .append("Discount percent: 0%").append(newLine)
      .append("Discount amount: $0.00").append(newLine)
      .append("Final charge: $8.97").append(newLine)

      .toString();
    assertEquals("Rental agreement printable form matches", expectedAgreementContents, agreementContents);
  }
  
  @Test
  public void cannedTest5() throws ValidationException, NoSuchElementException, IOException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKR";
    form.setCheckoutDate("7/2/15");
    form.rentalDayCount = 9;
    form.discountPercent = 0;
    form.validate();

    ToolTypesRepository toolTypes = new ToolTypesRepository("/toolTypes.json");
    ToolsRepository tools = new ToolsRepository(toolTypes, "/tools.json");

    String agreementContents = RentalAgreementService.getRentalAgreementPrintFormat(RentalAgreementService.getRentalAgreementByCheckoutForm(form, tools));

    String newLine = "\n";
    String expectedAgreementContents = new StringBuilder()

      .append(newLine)
      .append("Rental Agreement").append(newLine)

      .append("Tool code: JAKR").append(newLine)
      .append("Tool type: Jackhammer").append(newLine)
      .append("Tool brand: Ridgid").append(newLine)
      .append("Rental days: 9").append(newLine)
      .append("Check out date: 07/02/15").append(newLine)
      .append("Due date: 07/11/15").append(newLine)
      .append("Daily rental charge: $2.99").append(newLine)
      .append("Charge days: 6").append(newLine)
      .append("Pre-discount charge: $17.94").append(newLine)
      .append("Discount percent: 0%").append(newLine)
      .append("Discount amount: $0.00").append(newLine)
      .append("Final charge: $17.94").append(newLine)

      .toString();
    assertEquals("Rental agreement printable form matches", expectedAgreementContents, agreementContents);
  }
  
  @Test
  public void cannedTest6() throws ValidationException, NoSuchElementException, IOException {
    CheckoutForm form = new CheckoutForm();
    form.toolCode = "JAKR";
    form.setCheckoutDate("7/2/20");
    form.rentalDayCount = 4;
    form.discountPercent = 50;
    form.validate();

    ToolTypesRepository toolTypes = new ToolTypesRepository("/toolTypes.json");
    ToolsRepository tools = new ToolsRepository(toolTypes, "/tools.json");

    String agreementContents = RentalAgreementService.getRentalAgreementPrintFormat(RentalAgreementService.getRentalAgreementByCheckoutForm(form, tools));

    String newLine = "\n";
    String expectedAgreementContents = new StringBuilder()

      .append(newLine)
      .append("Rental Agreement").append(newLine)

      .append("Tool code: JAKR").append(newLine)
      .append("Tool type: Jackhammer").append(newLine)
      .append("Tool brand: Ridgid").append(newLine)
      .append("Rental days: 4").append(newLine)
      .append("Check out date: 07/02/20").append(newLine)
      .append("Due date: 07/06/20").append(newLine)
      .append("Daily rental charge: $2.99").append(newLine)
      .append("Charge days: 1").append(newLine)
      .append("Pre-discount charge: $2.99").append(newLine)
      .append("Discount percent: 50%").append(newLine)
      .append("Discount amount: $1.50").append(newLine)
      .append("Final charge: $1.50").append(newLine)

      .toString();
    assertEquals("Rental agreement printable form matches", expectedAgreementContents, agreementContents);
  }

}
