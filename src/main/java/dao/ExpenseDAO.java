package dao;

import database.DatabaseConnection;
import dto.Expense;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
    public void addExpense(Expense expense) {
        String sql = "INSERT INTO Expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, expense.getTitle());
            stmt.setString(2, expense.getCategory());
            stmt.setDouble(3,expense.getAmount());
            stmt.setDate(4,expense.getDateIncurred());//CHANGE LATER
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteExpense(int expenseID) {
        String sql = "DELETE FROM Expenses WHERE expenseID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, expenseID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM Expenses";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                expenses.add(new Expense(
                        rs.getInt("expenseID"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getDouble("amount"),
                        rs.getDate("dateIncurred")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }
}
