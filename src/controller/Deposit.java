package controller;

import repository.RepoConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2,b3;
    public Deposit(String pin){
        super("Deposit");
        this.pin=pin;


        ImageIcon machine=new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image img=machine.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(img);
        JLabel l1=new JLabel(img1);
        l1.setBounds(0,0,1150,830);
        add(l1);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/logo.png"));
        Image i2=i1.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(130,138,150,100);
        l1.add(image);
        JLabel label1=new JLabel("WELCOME TO MONEY BANK ATM");
        label1.setFont(new Font("Constantia",Font.BOLD,20));
        label1.setForeground(Color.white);
        label1.setBounds(350,180,400,35);
        l1.add(label1);

        JLabel label2=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label2.setFont(new Font("Times New Roman",Font.BOLD,16));
        label2.setForeground(Color.white);
        label2.setBounds(350,250,400,35);
        l1.add(label2);

        textField=new TextField();
        textField.setBounds(350,350,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        textField.setBackground(new Color(217, 234, 253));
        textField.setForeground(Color.BLACK);
        l1.add(textField);

        b1=new JButton("DEPOSIT");
        b1.setBounds(700,400,150,35);
        b1.setFont(new Font("Arial Black",Font.BOLD,16));
        b1.setBackground(new Color(217, 234, 253));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("CLEAR");
        b2.setBounds(700,450,150,35);
        b2.setFont(new Font("Arial Black",Font.BOLD,16));
        b2.setBackground(new Color(217, 234, 253));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l1.add(b2);
        b3=new JButton("BACK");
        b3.setBounds(700,500,150,35);
        b3.setFont(new Font("Arial Black",Font.BOLD,16));
        b3.setBackground(new Color(217, 234, 253));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        l1.add(b3);



        getContentPane().setBackground(new Color(232, 249, 255));
        setLayout(null);
        setSize(1195,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource() == b1) {
            String amountText = textField.getText().trim();

            if (amountText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an amount to deposit.");
                return;
            }

            // Check if input is numeric
            if (!amountText.matches("\\d+")) { // Ensures only digits
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid numeric amount.");
                return;
            }

            int amount = Integer.parseInt(amountText);
            Date date = new Date();

            if (amount <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            } else if (amount > 100000) {
                JOptionPane.showMessageDialog(null, "Sorry! You can deposit up to 1 lakh rupees per transaction.");
            } else {
                RepoConnection repo = new RepoConnection();
                repo.statement.executeUpdate("INSERT INTO bank VALUES ('" + pin + "','" + date + "','Deposit','" + amount + "')");
               // int balance=Balance.getBalance();
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");

                setVisible(false);
                dispose();
                new Transaction(pin);
            }
        } else if (e.getSource() == b2) {
            textField.setText("");
        } else if (e.getSource() == b3) {
            int choice = JOptionPane.showConfirmDialog(
                    null, "Are you sure you want to go back?", "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                setVisible(false);
                new Transaction(pin);
            }
        }
        } catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("");

    }
}
