package tmps;

public interface CatalogBuilder {
  void AddCompartiment(String titlu);

  void AddPiece(int index, String titlu, String descriere, int pret);

  void AddClonedPiece(int indexCompartiment, int indexPiece);

  void RemoveCompartiment(int index);

  void RemovePiece(int indexCompartimet, int indexPiece);

  void ReloadedCatalog();

  void ShowMainCatalog();

  void ShowSubCatalog(int indexCompartiment);

  void ShowBasket(ClientBascket bascket);
}
