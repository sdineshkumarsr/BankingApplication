package controller;

import repository.RepoConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1, b2, b3;

    public Withdraw(String pin) {
        super("Withdraw");
        this.pin = pin;

        ImageIcon machine = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image img = machine.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(img);
        JLabel l1 = new JLabel(img1);
        l1.setBounds(0, 0, 1150, 830);
        add(l1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(130, 138, 150, 100);
        l1.add(image);

        JLabel label1 = new JLabel("WELCOME TO MONEY BANK ATM");
        label1.setFont(new Font("Constantia", Font.BOLD, 20));
        label1.setForeground(Color.white);
        label1.setBounds(350, 180, 400, 35);
        l1.add(label1);

        JLabel label2 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label2.setForeground(Color.white);
        label2.setBounds(350, 250, 400, 35);
        l1.add(label2);

        JLabel label3 = new JLabel("Maximum withdrawal limit: RS.10,000");
        label3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label3.setForeground(Color.white);
        label3.setBounds(350, 290, 400, 35);
        l1.add(label3);

        JLabel label4 = new JLabel("Enter the amount in multiples of 100, 200 or 500");
        label4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label4.setForeground(Color.yellow);
        label4.setBounds(350, 320, 400, 35);
        l1.add(label4);

        textField = new JTextField();
        textField.setBounds(350, 350, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        textField.setBackground(new Color(217, 234, 253));
        textField.setForeground(Color.BLACK);
        l1.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(700, 400, 150, 35);
        b1.setFont(new Font("Arial Black", Font.BOLD, 16));
        b1.setBackground(new Color(217, 234, 253));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("CLEAR");
        b2.setBounds(700, 450, 150, 35);
        b2.setFont(new Font("Arial Black", Font.BOLD, 16));
        b2.setBackground(new Color(217, 234, 253));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l1.add(b2);

        b3 = new JButton("BACK");
        b3.setBounds(700, 500, 150, 35);
        b3.setFont(new Font("Arial Black", Font.BOLD, 16));
        b3.setBackground(new Color(217, 234, 253));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        l1.add(b3);

        getContentPane().setBackground(new Color(232, 249, 255));
        setLayout(null);
        setSize(1195, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                String amountText = textField.getText().trim();

                if (amountText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter an amount to withdraw.");
                    return;
                }

                if (!amountText.matches("\\d+")) { // Ensures only digits
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid numeric amount.");
                    return;
                }

                int amount = Integer.parseInt(amountText);
                Date date = new Date();

                if (amount <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                    return;
                } else if (amount > 10000) {
                    JOptionPane.showMessageDialog(null, "Sorry! Maximum withdrawal limit is ₹10,000 per transaction.");
                    return;
                } else if (amount % 100 != 0 && amount % 200 != 0 && amount % 500 != 0) {
                    JOptionPane.showMessageDialog(null, "Invalid amount! Enter multiples of 100, 200, or 500.");
                    return;
                }

                // Check Balance
                RepoConnection repo = new RepoConnection();
                ResultSet resultSet = repo.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
                int balance = 0;

                while (resultSet.next()) {
                    String type = resultSet.getString("type");
                    int txnAmount = resultSet.getInt("amount");

                    if (type.equals("Deposit")) {
                        balance += txnAmount;
                    } else if (type.equals("Withdrawal")) {
                        balance -= txnAmount;
                    }
                }

                if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance! Your balance is ₹" + balance);
                    return;
                }

                // Process Withdrawal
                repo.statement.executeUpdate("INSERT INTO bank VALUES('" + pin + "','" + date + "','Withdrawal','" + amount + "')");
<<<<<<< HEAD

                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully"+"\n Available balance: Rs."+Balance.getBalance());
=======
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
>>>>>>> e43088d45a00a3650d9dd16f9a9e8bf645a7b6e7

                setVisible(false);
                new Transaction(pin);
            } else if (e.getSource() == b2) { // Clear Button
                textField.setText("");
            } else if (e.getSource() == b3) { // Back Button
                setVisible(false);
                new Transaction(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
