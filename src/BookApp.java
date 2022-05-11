import java.util.ArrayList;
import java.util.Scanner;

public class BookApp {
  public static void main(String[] args) {
    var books = new ArrayList<Book>();
    try (var scanner = new Scanner(System.in)) {
      while (true) {
        System.out.println("Adding a new book; enter a blank title to quit.");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        if (title.isBlank())
          break;

        System.out.print("Number of pages: ");
        int pages = Integer.parseInt(scanner.nextLine());
        System.out.print("Publication year: ");
        int published = Integer.parseInt(scanner.nextLine());
        books.add(new Book(title, pages, published));
        System.out.println();
      }

      System.out.print("Information to print (everything/name):");
      String choice = scanner.nextLine().trim();
      for (Book book : books) {
        if (choice.equalsIgnoreCase("name")) {
          System.out.println(book.getTitle());
        } else {
          System.out.println(book);
        }
      }
    }
  }
}
