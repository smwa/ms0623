package dev.mechstack.ms0623.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import dev.mechstack.ms0623.model.ToolType;

import org.json.JSONArray;
import org.json.JSONObject;

public class ToolTypes {

  protected String filePath;

  public ToolTypes(String filePath) {
    this.filePath = filePath;
  }

  public List<ToolType> getAll() throws IOException {
    InputStream jsonResource = getClass().getResourceAsStream(filePath);
    if (jsonResource == null) {
      throw new FileNotFoundException("Tool types json file not found");
    }
    String json = new String(jsonResource.readAllBytes(), StandardCharsets.UTF_8);

    JSONArray jsonArray = new JSONArray(json);
    List<ToolType> toolTypes = new ArrayList<>();

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      ToolType toolType = new ToolType(
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
