package tmps;

public class Prototype {

  Piece clonePiece(Piece piece) {
    return (Piece) piece.copy();
  }

}
