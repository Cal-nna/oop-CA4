package Main;

import dao.ExpenseDAO;
import dao.IncomeDAO;
import dto.Expense;

import java.sql.Date;
import java.util.Scanner;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        ExpenseDAO expenseDAO = new ExpenseDAO();
        IncomeDAO incomeDAO = new IncomeDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. List Expenses");
            System.out.println("2. Add Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. List Income");
            System.out.println("5. Add Income");
            System.out.println("6. Delete Income");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> expenseDAO.getAllExpenses().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Enter title of expense: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    Date date = Date.valueOf(scanner.next());
                    expenseDAO.addExpense(new Expense(0, title, category, amount, date));
                }
                case 3 -> {
                    System.out.print("Enter the ID of the expense you wish to delete: ");
                    int id = scanner.nextInt();
                    expenseDAO.deleteExpense(id);
                }
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
