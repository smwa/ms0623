package dev.mechstack.ms0623.model;

public class ToolModel {

  protected String toolCode;
  protected ToolTypeModel toolType;
  protected String brand;

  public ToolModel(String toolCode, ToolTypeModel toolType, String brand) {
    this.toolCode = toolCode;
    this.toolType = toolType;
    this.brand = brand;
  }

  public String getToolCode() {
    return toolCode;
  }

  public ToolTypeModel getToolType() {
    return toolType;
  }

  public String getBrand() {
    return brand;
  }

}
