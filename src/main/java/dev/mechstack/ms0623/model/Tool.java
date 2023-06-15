package dev.mechstack.ms0623.model;

public class Tool {

  protected String toolCode;
  protected ToolType toolType;
  protected String brand;

  public Tool(String toolCode, ToolType toolType, String brand) {
    this.toolCode = toolCode;
    this.toolType = toolType;
    this.brand = brand;
  }

  public String getToolCode() {
    return toolCode;
  }

  public ToolType getToolType() {
    return toolType;
  }

  public String getBrand() {
    return brand;
  }

}
