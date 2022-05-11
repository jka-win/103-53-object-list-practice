import java.util.ArrayList;
import java.util.Scanner;

public class AnimalApp {
  public static void main(String[] args) {
    var animals = new ArrayList<Animal>();
    try (var scanner = new Scanner(System.in)) {
      while (true) {
        System.out.println("Adding a new animal; enter a blank name to quit.");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        if (name.isBlank())
          break;

        System.out.print("Is a dog (yes/no): ");
        boolean isDog = scanner.nextLine().trim().equalsIgnoreCase("yes");
        animals.add(new Animal(name, isDog));
        System.out.println();
      }
    }

    for (Animal animal : animals) {
      System.out.println(animal);
    }
  }
}
