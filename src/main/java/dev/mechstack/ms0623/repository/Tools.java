package dev.mechstack.ms0623.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.mechstack.ms0623.model.Tool;

public class Tools {

  protected String filePath;

  public Tools(String filePath) {
    this.filePath = filePath;
  }

  public List<Tool> getAll() throws StreamReadException, DatabindException, IOException {
    InputStream jsonResource = getClass().getResourceAsStream(filePath);
    
    if (jsonResource == null) {
      throw new FileNotFoundException("Tools json file not found");
    }

    ObjectMapper mapper = new ObjectMapper();
    String json = new String(jsonResource.readAllBytes(), StandardCharsets.UTF_8);
    return mapper.readValue(json, new TypeReference<List<Tool>>(){});
  }

}
