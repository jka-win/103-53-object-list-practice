public class CounterApp {
  public static void main(String[] args) {
    System.out.println("Creating a counter...");
    var counter = new Counter();
    System.out.println(counter);
    System.out.println();

    System.out.println("Creating a counter with an initial value of 10...");
    counter = new Counter(10);
    System.out.println(counter);
    System.out.println();

    System.out.println("Checking the value of the counter...");
    System.out.println("Value: " + counter.value());
    System.out.println();

    System.out.println("Increasing the counter...");
    counter.increase();
    System.out.println(counter);
    System.out.println();

    System.out.println("Increasing the counter by 2...");
    counter.increase(2);
    System.out.println(counter);
    System.out.println();

    System.out.println("Decreasing the counter...");
    counter.decrease();
    System.out.println(counter);
    System.out.println();

    System.out.println("Decreasing the counter by 6...");
    counter.decrease(6);
    System.out.println(counter);
    System.out.println();
  }
}
