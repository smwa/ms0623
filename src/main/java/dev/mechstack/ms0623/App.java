package dev.mechstack.ms0623;

import java.io.IOException;
import java.util.List;

import dev.mechstack.ms0623.model.Tool;
import dev.mechstack.ms0623.model.ToolType;
import dev.mechstack.ms0623.repository.ToolTypes;
import dev.mechstack.ms0623.repository.Tools;

public class App 
{
  public static void main( String[] args )
  {

    List<ToolType> toolTypes;
    try {
      toolTypes = new ToolTypes("/toolTypes.json").getAll();
    } catch (IOException e) {
      System.err.println("Tool types json file is missing or corrupt");
      return;
    }

    List<Tool> tools;
    try {
      tools = new Tools("/tools.json").getAll();
    } catch (IOException e) {
      System.err.println("Tools json file is missing or corrupt");
      return;
    }

    System.out.println(tools.get(0).getToolCode());
    System.out.println(toolTypes.get(0).getToolType());
  }
}
