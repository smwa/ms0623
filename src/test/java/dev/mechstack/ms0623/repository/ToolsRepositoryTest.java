package dev.mechstack.ms0623.repository;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

import org.junit.Test;

import dev.mechstack.ms0623.model.ToolModel;
import dev.mechstack.ms0623.model.ToolTypeModel;

class ToolTypesRepositoryMock extends ToolTypesRepository {
  public ToolTypesRepositoryMock(String filePath) {
    super(filePath);
  }

  @Override
  public ToolTypeModel get(String toolTypeCode) throws IOException, NoSuchElementException {
    ToolTypeModel toolType = new ToolTypeModel(toolTypeCode, new BigDecimal(1.00), true, true, false);
    return toolType;
  }
}

public class ToolsRepositoryTest {
  @Test(expected = NoSuchElementException.class)
  public void main() throws IOException {
    ToolsRepository tools = new ToolsRepository(new ToolTypesRepositoryMock(""), "/toolsTest.json");
    assertEquals("Length of tools json", 1, tools.getAll().size());
    assertEquals("Correct tool type", 1.00, tools.getAll().get(0).getToolType().getDailyCharge().doubleValue(), 0.01);
    ToolModel tool = tools.get("CHNS");
    assertEquals(tool.getToolCode(), "CHNS");
    tools.get("NULL");
  }
}
