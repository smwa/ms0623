package dev.mechstack.ms0623.repository;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.junit.Test;

import dev.mechstack.ms0623.model.ToolTypeModel;

public class ToolTypesRepositoryTest {
  @Test(expected = NoSuchElementException.class)
  public void main() throws IOException {
    ToolTypesRepository toolTypes = new ToolTypesRepository("/toolTypesTest.json");
    assertEquals("Only one tooltype", toolTypes.getAll().size(), 1);
    ToolTypeModel toolType = toolTypes.get("Chainsaw");
    assertEquals("Daily charge loads from json", toolType.getDailyCharge().doubleValue(), 1.99, 0.01);
    assertEquals(toolType.getWeekdayCharge(), true);
    toolTypes.get("NoToolType");
  }
}
