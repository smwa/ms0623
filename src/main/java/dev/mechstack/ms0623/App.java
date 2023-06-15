package dev.mechstack.ms0623;

import java.io.IOException;

import dev.mechstack.ms0623.cli.CheckoutCLI;
import dev.mechstack.ms0623.form.CheckoutForm;
import dev.mechstack.ms0623.repository.ToolTypesRepository;
import dev.mechstack.ms0623.repository.ToolsRepository;

public class App 
{
  public static void main( String[] args )
  {

    ToolTypesRepository toolTypes = new ToolTypesRepository("/toolTypes.json");

    ToolsRepository tools = new ToolsRepository(toolTypes, "/tools.json");

    try {
      while (true) {
        CheckoutForm checkoutForm = CheckoutCLI.checkoutForm(tools);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
