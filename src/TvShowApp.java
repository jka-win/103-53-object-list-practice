import java.util.ArrayList;
import java.util.Scanner;

public class TvShowApp {
  public static void main(String[] args) {
    var shows = new ArrayList<TvShow>();
    try (var scanner = new Scanner(System.in)) {
      while (true) {
        System.out.println("Adding a new show; enter a blank name to quit.");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        if (name.isBlank())
          break;

        System.out.print("Number of episodes: ");
        int episodes = Integer.parseInt(scanner.nextLine());
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        shows.add(new TvShow(name, episodes, genre));
        System.out.println();
      }
    }

    for (TvShow show : shows) {
      System.out.println(show);
    }
  }
}
