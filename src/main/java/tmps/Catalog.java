package tmps;

import tmps.Strategy.WorkingWithFiles;

import java.util.ArrayList;
// ->Composite
public class Catalog extends WorkingWithFiles implements CatalogBuilder {

  private ArrayList<Compartiment> compartimentList = new ArrayList<Compartiment>();

  private ShowCatalogFunctions showCatalogFunctions = new ShowCatalogFunctions();
  private Prototype prototype = new Prototype();

  public ArrayList<Compartiment> getCompartimentList() {
    return this.compartimentList;
  }

  @Override
  public void AddCompartiment(String titlu) {

    this.compartimentList.add(new Compartiment(titlu));
    SaveCatalog(this.compartimentList);
    ReloadedCatalog();
  }

  @Override
  public void AddPiece(int index, String titlu, String descriere, int grame, int pret) {

    this.compartimentList.get(index).AddPiece(titlu, descriere, grame, pret);
    SaveCatalog(this.compartimentList);
    ReloadedCatalog();
  }

  @Override
  public void AddClonedPiece(int indexCompartiment, int indexPiece) {

    this.compartimentList.get(indexCompartiment).AddClonedPiece(
        prototype.clonePiece(
            this.compartimentList.get(indexCompartiment).getPieces().get(indexPiece)
        )
    );
    SaveCatalog(this.compartimentList);
    ReloadedCatalog();
  }

  @Override
  public void RemoveCompartiment(int index) {
    this.compartimentList.remove(index);
    SaveCatalog(this.compartimentList);
    ReloadedCatalog();
  }

  @Override
  public void RemovePiece(int indexCompartimet, int indexPiece) {

    this.compartimentList.get(indexCompartimet).RemovePiece(indexPiece);
    SaveCatalog(this.compartimentList);
    ReloadedCatalog();
  }

  @Override
  public void ReloadedCatalog() {
    this.compartimentList = (ArrayList<Compartiment>) super.ReloadCatalog();
  }

  @Override
  public void ShowMainCatalog() {
    showCatalogFunctions.ShowMainCatalog(this.compartimentList);
  }

  @Override
  public void ShowSubCatalog(int indexCompartiment) {
    showCatalogFunctions.ShowSubCatalog(indexCompartiment, this.compartimentList);
  }

  @Override
  public void ShowBasket(ClientBascket bascket) {
    showCatalogFunctions.ShowBasket(bascket, this.compartimentList);
  }

  //Memento
  public ArrayList<Compartiment> getCatalogForSave(){
    return this.compartimentList;
  }

  //Memento
  public void loadBackup(CatalogMemento catalogMemento){
    this.compartimentList = catalogMemento.getCatalogBackup();
  }
}
