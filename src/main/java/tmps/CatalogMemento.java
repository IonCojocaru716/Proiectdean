package tmps;

import java.util.ArrayList;

public class CatalogMemento {
  private final ArrayList<Compartiment> catalogBackup;

  public CatalogMemento(ArrayList<Compartiment> catalogBackup) {
    this.catalogBackup = catalogBackup;
  }

  public ArrayList<Compartiment> getCatalogBackup() {
    return catalogBackup;
  }
}
