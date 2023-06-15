package dev.mechstack.ms0623.cli;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import dev.mechstack.ms0623.exception.ValidationException;
import dev.mechstack.ms0623.form.CheckoutForm;
import dev.mechstack.ms0623.model.Tool;
import dev.mechstack.ms0623.repository.Tools;

public class CheckoutCLI {
  public static CheckoutForm checkoutForm(Tools toolsRepository) throws IOException {
    Scanner scanner = null;
    List<Tool> tools = toolsRepository.getAll();
    try {
      scanner = new Scanner(System.in);
      while (true) {
        CheckoutForm checkoutForm = new CheckoutForm();
        System.out.println("Starting checkout");
  
        System.out.println("Type the corresponding tool code from the following for the tool to checkout.");
        for (int i = 0; i < tools.size(); i++) {
          System.out.println("Code\tType\tBrand");
          System.out.print(tools.get(i).getToolCode());
          System.out.print("\t");
          System.out.print(tools.get(i).getToolType());
          System.out.print("\t");
          System.out.print(tools.get(i).getBrand());
          System.out.println("");
        }
        checkoutForm.toolCode = scanner.nextLine().toUpperCase();

        System.out.println("Enter how many days to checkout. Must be at least 1.");
        checkoutForm.rentalDayCount = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter a discount amount in percent as a whole number. Must be from 0 to 100.");
        checkoutForm.discountPercent = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter a checkout date.");
        String[] dateParts = scanner.nextLine().split("/", 3);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000 + Integer.parseInt(dateParts[2]));
        calendar.set(Calendar.MONTH, Integer.parseInt(dateParts[0]));
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateParts[1]));
        checkoutForm.checkoutDate = calendar.getTime();
        
        try {
          checkoutForm.validate();
        }
        catch (ValidationException e) {
          System.err.println(e.getMessage());
          System.err.println("Checkout was not successful. Try again.");
          continue;
        }
        return checkoutForm;
      }
    }
    finally {
      if (scanner != null) {
        scanner.close();
      }
    }
  }
}
