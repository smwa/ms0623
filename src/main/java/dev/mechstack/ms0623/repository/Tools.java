package dev.mechstack.ms0623.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import dev.mechstack.ms0623.model.Tool;

import org.json.JSONArray;
import org.json.JSONObject;

public class Tools {

  protected String filePath;

  public Tools(String filePath) {
    this.filePath = filePath;
  }

  public List<Tool> getAll() throws IOException {
    InputStream jsonResource = getClass().getResourceAsStream(filePath);
    if (jsonResource == null) {
      throw new FileNotFoundException("Tools json file not found");
    }
    String json = new String(jsonResource.readAllBytes(), StandardCharsets.UTF_8);

    JSONArray jsonArray = new JSONArray(json);
    List<Tool> tools = new ArrayList<>();

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      Tool tool = new Tool(jsonObject.getString("toolCode"), jsonObject.getString("toolType"), jsonObject.getString("brand"));
      tools.add(tool);
    }

    return tools;
  }

}
