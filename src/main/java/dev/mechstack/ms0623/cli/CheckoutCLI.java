package dev.mechstack.ms0623.cli;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import dev.mechstack.ms0623.exception.ValidationException;
import dev.mechstack.ms0623.form.CheckoutForm;
import dev.mechstack.ms0623.model.ToolModel;
import dev.mechstack.ms0623.repository.ToolsRepository;

public class CheckoutCLI {
  public static CheckoutForm checkoutForm(Scanner scanner, ToolsRepository toolsRepository) throws IOException {
    List<ToolModel> tools = toolsRepository.getAll();
    while (true) {
      CheckoutForm checkoutForm = new CheckoutForm();
      System.out.println("Starting checkout");

      System.out.println("Type the corresponding tool code from the following for the tool to checkout.");
      String FORMAT_STRING = "%4s%36s%36s\n";
      System.out.format(FORMAT_STRING, "Code", "Type", "Brand");
      for (int i = 0; i < tools.size(); i++) {
        System.out.format(FORMAT_STRING, tools.get(i).getToolCode(), tools.get(i).getToolType().getToolType(), tools.get(i).getBrand());
      }
      try {
        checkoutForm.toolCode = scanner.nextLine().toUpperCase().strip();
      }
      catch (InputMismatchException e) {}
      // Check that tool exists
      try {
        toolsRepository.get(checkoutForm.toolCode);
      }
      catch (NoSuchElementException e) {
        checkoutForm.toolCode = "";
      }

      System.out.println("Enter a checkout date, in the format mm/dd/yy.");
      checkoutForm.setCheckoutDate(scanner.nextLine());

      System.out.println("Enter how many days to checkout. Must be at least 1.");
      try {
        checkoutForm.rentalDayCount = scanner.nextInt();
      }
      catch (InputMismatchException e) {}
      scanner.nextLine();

      System.out.println("Enter a discount amount in percent as a whole number. Must be from 0 to 100.");
      try {
        checkoutForm.discountPercent = scanner.nextInt();
      }
      catch (InputMismatchException e) {}
      scanner.nextLine();
      
      try {
        checkoutForm.validate();
      }
      catch (ValidationException e) {
        System.err.println(e.getMessage());
        System.err.println("Checkout was not successful. Try again.");
        continue;
      }
      catch (NumberFormatException e) {
        System.err.println("Invalid number. Checkout was not successful. Try again.");
        continue;
      }
      return checkoutForm;
    }
  }
}
