package tmps;

public class Piece {
  private String titlu;
  private String descriere;
  private int pret;

  public Piece(String titlu, String descriere, int pret) {
    this.descriere = descriere;
    this.pret = pret;
    this.titlu = titlu;
  }

  public String getTitlu() {
    return titlu;
  }

  public String getDescriere() {
    return descriere;
  }

  public int getPret() {
    return pret;
  }

  public Object copy() {
    return this;
  }
}
