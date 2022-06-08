package tmps;

import java.util.ArrayList;

public class ClientBascket {
  private ArrayList<CompartimentBasket> clientPieces = new ArrayList<CompartimentBasket>();
  private boolean isExistCompartiment = false;

  public void addPieceBasket(int indexCompartiment, int indexPiece) {

    for (CompartimentBasket compartimentBasket : clientPieces) {
      if (compartimentBasket.getIndexComaprtiment() == indexCompartiment)
        isExistCompartiment = true;
    }

    if (isExistCompartiment) {
      this.clientPieces.get(indexCompartiment).addIndexPiece(indexPiece);
    } else {
      CompartimentBasket compartimentBasket = new CompartimentBasket(indexCompartiment);
      compartimentBasket.addIndexPiece(indexPiece);
      this.clientPieces.add(compartimentBasket);
    }
    isExistCompartiment = false;
  }

  public ArrayList<CompartimentBasket> getClientPieces() {
    return clientPieces;
  }
}
