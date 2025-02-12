package dto;

import java.sql.Date;

public class Expense {
    private int expenseID;
    private String title;
    private String category;
    private double amount;
    private Date dateIncurred;

    public Expense(int expenseID, String title, String category, double amount, Date dateIncurred) {
        this.expenseID = expenseID;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    public void setDateIncurred(Date dateIncurred) {
        this.dateIncurred = dateIncurred;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }


    public int getExpenseID() { return expenseID; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public Date getDateIncurred() { return dateIncurred; }


    @Override
    public String toString() {
        return "Expense{" +
                "expenseID=" + expenseID +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", dateIncurred=" + dateIncurred +
                '}';
    }
}

