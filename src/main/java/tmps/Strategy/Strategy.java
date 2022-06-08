package tmps.Strategy;

import tmps.Compartiment;

import java.util.ArrayList;

public interface Strategy {
  Object execute(ArrayList<Compartiment> compartimentList);
}
