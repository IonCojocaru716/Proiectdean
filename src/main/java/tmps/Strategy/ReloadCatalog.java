package tmps.Strategy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import tmps.Compartiment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReloadCatalog implements Strategy{
  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private Path fileName = Path.of("C:\\Users\\Ionel\\Desktop\\ProiectAnTMPS\\src\\main\\java\\tmps\\catalog.txt");

  @Override
  public Object execute(ArrayList<Compartiment> compartimentList) {
    try {
      return gson.fromJson(Files.readString(fileName), new TypeToken<ArrayList<Compartiment>>(){}.getType());
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
