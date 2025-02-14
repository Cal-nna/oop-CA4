package Main;

import dao.ExpenseDAO;
import dao.IncomeDAO;
import dto.Expense;
import dto.Income;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import Exceptions.DaoException;

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
                case 2 -> {try{
                    System.out.print("Enter title of expense: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    Date date = Date.valueOf(scanner.next());
                    expenseDAO.addExpense(new Expense(0, title, category, amount, date));
                    System.out.println("Successfully added expense");
                }catch (InputMismatchException e) {
                    System.out.println("Invalid input, ensure that you have given a valid number only");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input, make sure the date is of YYYY-MM-DD format");
                } }
                case 3 -> {try{
                    System.out.print("Enter the ID of the expense you wish to delete: ");
                    int id = scanner.nextInt();
                    expenseDAO.deleteExpense(id);
                    System.out.println("Successfully deleted");
                }catch (InputMismatchException e) {
                    System.out.println("Invalid input, Please enter a valid ID");
                } }
                case 4 -> incomeDAO.getAllIncome().forEach(System.out::println);
                case 5 -> {try{
                    System.out.print("Enter title of income: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    Date date = Date.valueOf(scanner.next());
                    incomeDAO.addIncome(new Income(0, title, amount, date));
                    System.out.println("Successfully added income");
                }catch (InputMismatchException e) {
                    System.out.println("Invalid input, ensure that you have given a valid number only");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input, make sure the date is of YYYY-MM-DD format");
                } }
                case 6 -> {try{
                    System.out.print("Enter the ID of the income you wish to delete: ");
                    int id = scanner.nextInt();
                    incomeDAO.deleteIncome(id);
                    System.out.println("Successfully deleted");
                }catch (InputMismatchException e) {
                    System.out.println("Invalid input, Please enter a valid ID");
                } }

                case 7 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
