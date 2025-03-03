import java.util.*;
import java.util.stream.Collectors;

class Learner {
    String fullName;
    double score;

    public Learner(String fullName, double score) {
        this.fullName = fullName;
        this.score = score;
    }

    @Override
    public String toString() {
        return fullName + " - Marks: " + score;
    }
}

public class exp6_medium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Learner> learners = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name and marks: ");
            String name = scanner.next();
            double score = scanner.nextDouble();
            learners.add(new Learner(name, score));
        }

        List<Learner> filteredList = learners.stream()
                .filter(l -> l.score > 75)
                .sorted(Comparator.comparingDouble(l -> -l.score))
                .collect(Collectors.toList());

        filteredList.forEach(System.out::println);
        scanner.close();
    }
}
