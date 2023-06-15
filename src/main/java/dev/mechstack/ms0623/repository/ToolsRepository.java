package dev.mechstack.ms0623.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dev.mechstack.ms0623.model.ToolModel;
import dev.mechstack.ms0623.model.ToolTypeModel;

import org.json.JSONArray;
import org.json.JSONObject;

public class ToolsRepository {

  protected String filePath;
  protected ToolTypesRepository toolTypes;

  public ToolsRepository(ToolTypesRepository toolTypes, String filePath) {
    this.toolTypes = toolTypes;
    this.filePath = filePath;
  }

  public ToolModel get(String toolCode) throws IOException, NoSuchElementException {
    List<ToolModel> tools = getAll();
    for (ToolModel tool : tools) {
      if (tool.getToolCode().equals(toolCode)) {
        return tool;
      }
    }
    throw new NoSuchElementException(toolCode);
  }

  public List<ToolModel> getAll() throws IOException, NoSuchElementException {
    InputStream jsonResource = getClass().getResourceAsStream(filePath);
    if (jsonResource == null) {
      throw new FileNotFoundException("Tools json file not found");
    }
    String json = new String(jsonResource.readAllBytes(), StandardCharsets.UTF_8);

    JSONArray jsonArray = new JSONArray(json);
    List<ToolModel> tools = new ArrayList<>();

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      ToolTypeModel toolType = toolTypes.get(jsonObject.getString("toolType"));
      ToolModel tool = new ToolModel(jsonObject.getString("toolCode"), toolType, jsonObject.getString("brand"));
      tools.add(tool);
    }

    return tools;
  }

}
