import java.util.*;
import java.util.stream.Collectors;

class Item {
    String type;
    String title;
    double cost;

    public Item(String type, String title, double cost) {
        this.type = type;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return type + " - " + title + ": $" + cost;
    }
}

public class exp6_hard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> itemList = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter category, name, and price: ");
            String type = scanner.next();
            String title = scanner.next();
            double cost = scanner.nextDouble();
            itemList.add(new Item(type, title, cost));
        }

        Map<String, List<Item>> categorizedItems = itemList.stream()
                .collect(Collectors.groupingBy(i -> i.type));

        Map<String, Optional<Item>> expensiveItems = itemList.stream()
                .collect(Collectors.groupingBy(
                        i -> i.type,
                        Collectors.maxBy(Comparator.comparingDouble(i -> i.cost))
                ));

        double avgCost = itemList.stream()
                .mapToDouble(i -> i.cost)
                .average()
                .orElse(0.0);

        System.out.println("Products Categorized:");
        categorizedItems.forEach((type, items) -> System.out.println(type + ": " + items));

        System.out.println("\nMost Expensive Item in Each Category:");
        expensiveItems.forEach((type, item) -> item.ifPresent(i -> System.out.println(type + ": " + i)));

        System.out.println("\nOverall Average Price: $" + avgCost);
        scanner.close();
    }
}
