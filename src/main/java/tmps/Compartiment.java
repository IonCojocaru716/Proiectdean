package tmps;

import java.util.ArrayList;

public class Compartiment{
  private String name;
  private ArrayList<Piece> compartimentPieces = new ArrayList<Piece>();

  public Compartiment(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<Piece> getPieces() {
    return this.compartimentPieces;
  }

  public void AddPiece(String titlu, String descriere, int pret){
    this.compartimentPieces.add(new Piece(titlu, descriere, pret));
  }

  public void AddClonedPiece(Piece piece){
    this.compartimentPieces.add(piece);
  }

  public void RemovePiece(int index){
    this.compartimentPieces.remove(index);
  }

  public Object copy() {
    return this;
  }

}
