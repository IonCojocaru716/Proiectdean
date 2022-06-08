package tmps.Strategy;

import tmps.Compartiment;
import tmps.Strategy.Strategy;

import java.util.ArrayList;

public class Context {
  private Strategy strategy;

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public Object executeStrategy(ArrayList<Compartiment> compartimentList){
    return strategy.execute( compartimentList);
  }
}
