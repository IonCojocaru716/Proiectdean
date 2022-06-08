package tmps;

import java.util.ArrayList;

public class CatalogMemento {
  private final ArrayList<Compartiment> menuBackup;

  public CatalogMemento(ArrayList<Compartiment> menuBackup) {
    this.menuBackup = menuBackup;
  }

  public ArrayList<Compartiment> getCatalogBackup() {
    return menuBackup;
  }
}
