package tmps;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Catalog catalog = new Catalog();
    int thisCompartiment = 0;
    CatalogMemento catalogMemento;
    boolean isExit = true;
    ClientBascket bascket = new ClientBascket();
    boolean isCompartiment = false;
    String command;

    catalog.ReloadedCatalog();
    catalog.ShowMainCatalog();

    catalogMemento = new CatalogMemento(catalog.getCatalogForSave());

    while (isExit) {
      command = InputString();

      if (command.contains("exit")) isExit = false;//iese din app

      else if (command.contains("restoreBackup")) {

        catalog.loadBackup(catalogMemento); // reia backupul
        System.out.println("Backup este restaurat");

      } else if (command.contains("add")) {

        CreatePieceOrCompartiment(command, catalog);//adauga compartiment sau produs
        isCompartiment = false;

      } else if (command.contains("backup")) {

        catalogMemento = new CatalogMemento(catalog.getCatalogForSave()); // facem backup la catalog
        System.out.println("Backup este facut");

      } else if (command.contains("remove")) {

        RemovePieceOrCompartiment(command, catalog);// stergem un produs sau compartiment
        isCompartiment = false;

      } else if (command.contains("clonePiece")) {

        ClonePiece(catalog); // clonam un produs
        isCompartiment = false;

      } else if (isNumeric(command) && isCompartiment) {

        bascket.addPieceBasket(thisCompartiment, Integer.parseInt(command));
        System.out.println("Produsul " + catalog.getCompartimentList().
            get(thisCompartiment).getPieces().
            get(Integer.parseInt(command)).
            getTitlu() + " a fost adaugat in cos");

      } else if (isNumeric(command) && !isCompartiment) {

        catalog.ShowSubCatalog(Integer.parseInt(command));
        thisCompartiment = Integer.parseInt(command);
        isCompartiment = true;

      } else if ((command.contains("back") && isCompartiment) || command.contains("main")) {

        catalog.ShowMainCatalog();
        isCompartiment = false;

      } else if (command.contains("basket")) {

        catalog.ShowBasket(bascket);// deschidem cosul cu produse(piese)

      }
    }
  }

  static void CreatePieceOrCompartiment(String string, Catalog catalog) {

    if (string.contains("Compartiment")) {

      String titlu = InputString("Inserati titlul compartimentului: ");
      catalog.AddCompartiment(titlu);
      catalog.ShowMainCatalog();

    } else if (string.contains("Piece")) {

      int index = InputInt("Inserati indexul compartimentului: ");
      String titlu = InputString("Inserati titlul piesei: ");
      String descriere = InputString("Inserati descrierea piesei: ");
      int pret = InputInt("Inserati pretul piesei: ");

      catalog.AddPiece(index, titlu, descriere, pret);
      catalog.ShowMainCatalog();

    } else {
      System.out.println("Incerceti 'add'+(Compartiment sau Piece)");
    }
  }

  static void RemovePieceOrCompartiment(String string, Catalog catalog) {

    if (string.contains("Compartiment")) {

      int indexCompartiment = InputInt("Inserati indexul compartimentului: ");

      catalog.RemoveCompartiment(indexCompartiment);
      catalog.ShowMainCatalog();

    } else if (string.contains("Piece")) {

      int indexCompartiment = InputInt("Inserati indexul compartimentului: ");
      int indexPiece = InputInt("Inserati indexul piesei: ");

      catalog.RemovePiece(indexCompartiment, indexPiece);
      catalog.ShowMainCatalog();

    } else {
      System.out.println("Incerceti 'remove'+(Compartiment sau Piece)");
    }
  }

  public static void ClonePiece(Catalog catalog) {
    int indexCompartiment = InputInt("Inserati indexul compartimentului: ");
    int indexPiece = InputInt("Inserati indexul piesei: ");

    catalog.AddClonedPiece(indexCompartiment, indexPiece);
    catalog.ShowMainCatalog();
  }

  public static boolean isNumeric(String str) {
    return str != null && str.matches("[-+]?\\d*\\.?\\d+");
  }

  public static String InputString(String string) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(string);
    return scanner.nextLine();
  }

  public static String InputString() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public static int InputInt(String string) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(string);
    return scanner.nextInt();
  }
}
