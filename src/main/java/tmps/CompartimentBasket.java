package tmps;

import java.util.ArrayList;

public class CompartimentBasket {
  private int indexComaprtiment;
  private ArrayList<PieceBasket> pieceBaskets = new ArrayList<PieceBasket>();

  public CompartimentBasket(int indexCompartiment) {
    this.indexComaprtiment = indexCompartiment;
  }

  public void addIndexPiece(int indexPiece){
    PieceBasket piece = new PieceBasket();
    piece.indexPiece = indexPiece;
    pieceBaskets.add(piece);
  }

  public int getIndexComaprtiment() {
    return indexComaprtiment;
  }

  public ArrayList<PieceBasket> getPieceBaskets() {
    return this.pieceBaskets;
  }
}
