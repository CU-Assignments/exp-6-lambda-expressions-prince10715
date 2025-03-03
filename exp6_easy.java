
import java.util.*;

class Worker {
    String fullName;
    int years;
    double income;

    public Worker(String fullName, int years, double income) {
        this.fullName = fullName;
        this.years = years;
        this.income = income;
    }

    @Override
    public String toString() {
        return fullName + " - Age: " + years + ", Salary: " + income;
    }
}

public class exp6_easy{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Worker> workforce = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name, age, and salary: ");
            String fullName = scanner.next();
            int years = scanner.nextInt();
            double income = scanner.nextDouble();
            workforce.add(new Worker(fullName, years, income));
        }

        workforce.sort(Comparator.comparingDouble(w -> w.income));

        for (Worker w : workforce) {
            System.out.println(w);
        }
        scanner.close();
    }
}
