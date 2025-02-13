package dao;

import database.DatabaseConnection;
import dto.Income;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO {
    public void addIncome(Income income) {
        String sql = "INSERT INTO Income (title, amount, dateEarned) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, income.getTitle());
            stmt.setDouble(2, income.getAmount());
            stmt.setDate(3, income.getDateEarned());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteIncome(int incomeID) {
        String sql = "DELETE FROM Income WHERE incomeID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, incomeID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Income> getAllIncome() {
        List<Income> incomes = new ArrayList<>();
        String sql = "SELECT * FROM Income";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                incomes.add(new Income(
                                        rs.getInt("incomeID"),
                        rs.getString("title"),
                        rs.getDouble("amount"),
                                        rs.getDate("dateEarned")
                                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incomes;
    }
}
