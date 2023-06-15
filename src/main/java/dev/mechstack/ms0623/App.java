package dev.mechstack.ms0623;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import dev.mechstack.ms0623.model.ToolModel;
import dev.mechstack.ms0623.repository.ToolTypesRepository;
import dev.mechstack.ms0623.repository.ToolsRepository;

public class App 
{
  public static void main( String[] args )
  {

    ToolTypesRepository toolTypes;
    toolTypes = new ToolTypesRepository("/toolTypes.json");

    List<ToolModel> tools;
    try {
      tools = new ToolsRepository(toolTypes, "/tools.json").getAll();
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
