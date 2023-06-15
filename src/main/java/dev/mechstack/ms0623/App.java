package dev.mechstack.ms0623;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import dev.mechstack.ms0623.model.Tool;
import dev.mechstack.ms0623.repository.ToolTypes;
import dev.mechstack.ms0623.repository.Tools;

public class App 
{
  public static void main( String[] args )
  {

    ToolTypes toolTypes;
    toolTypes = new ToolTypes("/toolTypes.json");

    List<Tool> tools;
    try {
      tools = new Tools(toolTypes, "/tools.json").getAll();
    } catch (IOException e) {
      System.err.println("Tools json file is missing or corrupt");
      return;
    }
    catch (NoSuchElementException e) {
      System.err.println("Tools contains non-existent tooltype");
      e.printStackTrace();
      return;
    }

    System.out.println(tools.get(0).getToolCode());
    try {
      System.out.println(toolTypes.getAll().get(0).getToolType());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
