package dev.mechstack.ms0623;

import java.io.IOException;
import java.util.List;

import dev.mechstack.ms0623.model.Tool;
import dev.mechstack.ms0623.repository.Tools;

public class App 
{
  public static void main( String[] args )
  {
    List<Tool> tools;
    try {
      tools = new Tools("/tools.json").getAll();
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }
    System.out.println(tools.get(0).getBrand());
  }
}
