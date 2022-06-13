package tmps;

import java.util.ArrayList;

public class ShowCatalogFunctions {
  private int forPurchase = 0;

  public void ShowMainCatalog(ArrayList<Compartiment> compartimentList) {
    EmptyLines();
    System.out.println("Magazin de piese");
    System.out.println("");

    for (int i = 0; i < compartimentList.size(); i++) {
      System.out.println(i + ". " + compartimentList.get(i).getName() + " -> ");
    }

    System.out.println("");
    System.out.println("Alegeti inserand numarul potrivit: ");
  }

  public void ShowSubCatalog(int indexCompartiment, ArrayList<Compartiment> compartimentList) {
    Compartiment compartiment = compartimentList.get(indexCompartiment);

    EmptyLines();
    System.out.println("Magazin de piese");
    System.out.println(indexCompartiment + ". " + compartiment.getName() + ": ");
    System.out.println("|----------List----------|");

    for (int i = 0; i < compartiment.getPieces().size(); i++) {
      System.out.println(i + ". " +
          compartiment.getPieces().get(i).getTitlu() +
          "\n|--|Pret: " +
          compartiment.getPieces().get(i).getPret() +
          " mdl" +
          "\n|--|Descriere: " +
          compartiment.getPieces().get(i).getDescriere());
    }

    System.out.println("");
    System.out.println("(back - inapoi || main - catalogul principal)");
    System.out.println("Alegeti inserand numarul potrivit: ");
  }

  public void ShowBasket(ClientBascket bascket, ArrayList<Compartiment> compartimentList) {
    forPurchase = 0;
    Compartiment compartiment;
    Piece piece;
    EmptyLines();
    System.out.println("Basket: ");
    System.out.println("|----------List----------|");

    for (int i = 0; i < bascket.getClientPieces().size(); i++) {

      compartiment = compartimentList.get(getIndexCompartimentList(bascket, i));
      System.out.println(
          getIndexCompartimentList(bascket, i) + ". " +
              compartiment.getName() + " :"
      );
      for (int j = 0; j < bascket.getClientPieces().get(i).getPieceBaskets().size(); j++) {

        piece = compartiment.getPieces().get(getIndexPieceList(bascket, i, j));
        System.out.println("-------------------");
        System.out.println(
            "|--|" +
                getIndexPieceList(bascket, i, j) +
                ". " +
                piece.getTitlu() +
                "\n|--|--|Pret: " +
                piece.getPret() +
                " mdl");
        forPurchase += piece.getPret();
      }
    }
    System.out.println("");
    System.out.println("Total spre achitare: " + forPurchase + " mdl");
    System.out.println("");
  }

  private int getIndexPieceList(ClientBascket bascket, int i, int j) {
    return bascket.getClientPieces().get(i).getPieceBaskets().get(j).indexPiece;
  }

  private int getIndexCompartimentList(ClientBascket bascket, int i) {
    return bascket.getClientPieces().get(i).getIndexComaprtiment();
  }

  public void EmptyLines() {
    for (int i = 0; i < 10; i++) {
      System.out.println("\n");
    }
  }
}
