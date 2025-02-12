package dto;

import java.sql.Date;

public class Income {
    private int incomeID;
    private String title;
    private double amount;
    private Date dateEarned;

    public Date getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(Date dateEarned) {
        this.dateEarned = dateEarned;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(int incomeID) {
        this.incomeID = incomeID;
    }

    public Income(int incomeID, double amount, String title, Date dateEarned) {
        this.incomeID = incomeID;
        this.amount = amount;
        this.title = title;
        this.dateEarned = dateEarned;
    }

    @Override
    public String toString() {
        return "Income{" +
                "incomeID=" + incomeID +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", dateEarned=" + dateEarned +
                '}';
    }
}
