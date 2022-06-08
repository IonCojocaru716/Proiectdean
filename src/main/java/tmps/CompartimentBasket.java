package tmps;

import java.util.ArrayList;

public class CompartimentBasket {
  private int indexComaprtiment;
  private ArrayList<PieceBasket> pieceBaskets = new ArrayList<PieceBasket>();

  public CompartimentBasket(int indexCompartiment) {
    this.indexComaprtiment = indexCompartiment;
  }

  public void addIndexProduct(int indexProduct){
    PieceBasket product = new PieceBasket();
    product.indexPiece = indexProduct;
    pieceBaskets.add(product);
  }

  public int getIndexComaprtiment() {
    return indexComaprtiment;
  }

  public ArrayList<PieceBasket> getProductBaskets() {
    return this.pieceBaskets;
  }
}
