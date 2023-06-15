package dev.mechstack.ms0623.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dev.mechstack.ms0623.model.ToolTypeModel;

import org.json.JSONArray;
import org.json.JSONObject;

public class ToolTypesRepository {

  protected String filePath;

  public ToolTypesRepository(String filePath) {
    this.filePath = filePath;
  }

  public ToolTypeModel get(String toolTypeCode) throws IOException, NoSuchElementException {
    List<ToolTypeModel> toolTypes = getAll();
    for (ToolTypeModel toolType : toolTypes) {
      if (toolType.getToolType().equals(toolTypeCode)) {
        return toolType;
      }
    }
    throw new NoSuchElementException(toolTypeCode);
  }

  public List<ToolTypeModel> getAll() throws IOException {
    InputStream jsonResource = getClass().getResourceAsStream(filePath);
    if (jsonResource == null) {
      throw new FileNotFoundException("Tool types json file not found");
    }
    String json = new String(jsonResource.readAllBytes(), StandardCharsets.UTF_8);

    JSONArray jsonArray = new JSONArray(json);
    List<ToolTypeModel> toolTypes = new ArrayList<>();

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      ToolTypeModel toolType = new ToolTypeModel(
        jsonObject.getString("toolType"),
        jsonObject.getBigDecimal("dailyCharge"),
        jsonObject.getBoolean("weekdayCharge"),
        jsonObject.getBoolean("weekendCharge"),
        jsonObject.getBoolean("holidayCharge")
      );
      toolTypes.add(toolType);
    }

    return toolTypes;
  }

}
