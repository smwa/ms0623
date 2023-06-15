package dev.mechstack.ms0623.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dev.mechstack.ms0623.model.Tool;
import dev.mechstack.ms0623.model.ToolType;

import org.json.JSONArray;
import org.json.JSONObject;

public class Tools {

  protected String filePath;
  protected ToolTypes toolTypes;

  public Tools(ToolTypes toolTypes, String filePath) {
    this.toolTypes = toolTypes;
    this.filePath = filePath;
  }

  public List<Tool> getAll() throws IOException, NoSuchElementException {
    InputStream jsonResource = getClass().getResourceAsStream(filePath);
    if (jsonResource == null) {
      throw new FileNotFoundException("Tools json file not found");
    }
    String json = new String(jsonResource.readAllBytes(), StandardCharsets.UTF_8);

    JSONArray jsonArray = new JSONArray(json);
    List<Tool> tools = new ArrayList<>();

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      ToolType toolType = toolTypes.get(jsonObject.getString("toolType"));
      Tool tool = new Tool(jsonObject.getString("toolCode"), toolType, jsonObject.getString("brand"));
      tools.add(tool);
    }

    return tools;
  }

}
