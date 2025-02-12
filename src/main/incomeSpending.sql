DROP DATABASE IF EXISTS `income_and_spending`;
CREATE DATABASE `income_and_spending`;
--Create the Expenses table
CREATE TABLE Expenses (
    expenseID int(11) NOT NULL AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    category varchar(50) NOT NULL,
    amount DOUBLE NOT NULL,
    dateIncurred DATE NOT NULL,
    PRIMARY KEY  (`expenseID`)
);

--Create the Income table
CREATE TABLE Income (
    incomeID INT(11) PRIMARY KEY AUTOINCREMENT,
    title varchar(50) NOT NULL,
    amount DOUBLE NOT NULL,
    dateEarned DATE NOT NULL,
    PRIMARY KEY  (`incomeID`)
);

-- Insert expense records
INSERT INTO Expenses (title, category, amount, dateIncurred)
VALUES
('weekly shop', 'groceries', 47.50, '2025-01-07'),
('gym membership', 'fitness', 30.00, '2025-01-09');

-- Insert income records
INSERT INTO Income (title, amount, dateEarned)
VALUES
('babysitting', 60.00, '2025-01-05'),
('Bar work', 100.00, '2025-01-07');
