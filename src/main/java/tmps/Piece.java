package tmps;

public class Piece {
  private String titlu;
  private String descriere;
  private int grame;
  private int pret;

  public Piece(String titlu, String descriere, int grame, int pret) {
    this.descriere = descriere;
    this.grame = grame;
    this.pret = pret;
    this.titlu = titlu;
  }

  public String getTitlu() {
    return titlu;
  }

  public String getDescriere() {
    return descriere;
  }

  public int getGrame() {
    return grame;
  }

  public int getPret() {
    return pret;
  }

  public Object copy() {
    return this;
  }
}
