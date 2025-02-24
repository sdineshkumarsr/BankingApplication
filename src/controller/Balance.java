package controller;

import repository.RepoConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener {
    static String pin;
    JLabel label3;
    JButton backBtn;
    public Balance( String pin){
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
        label1.setFont(new Font("Constantia",Font.BOLD,25));
        label1.setForeground(Color.white);
        label1.setBounds(340,180,450,35);
        l1.add(label1);
        int balance = getBalance();
        JLabel label2=new JLabel("Available Balance: Rs.");
        label2.setFont(new Font("Constantia",Font.BOLD,25));
        label2.setForeground(Color.white);
        label2.setBounds(300,280,450,35);
        l1.add(label2);
         label3=new JLabel(String.valueOf(balance));
        label3.setFont(new Font("Arial Black",Font.BOLD,25));
        label3.setForeground(Color.white);
        label3.setBounds(559,276,450,35);
        l1.add(label3);
        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 500, 150, 35);
        backBtn.setFont(new Font("Arial Black", Font.BOLD, 16));
        backBtn.setBackground(new Color(217, 234, 253));
        backBtn.setForeground(Color.BLACK);
        backBtn.addActionListener(this);
        l1.add(backBtn);


        getContentPane().setBackground(new Color(232, 249, 255));
        setLayout(null);
        setSize(1195,1080);
        setLocation(0,0);
        setVisible(true);
    }

    public static int getBalance() {
        int balance = 0;
        try {
            RepoConnection repo = new RepoConnection();
            ResultSet resultSet = repo.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                int txnAmount = resultSet.getInt("amount");

                if (type.equals("Deposit")) {
                    balance += txnAmount;
                } else if (type.equals("Withdrawal")) {
                    balance -= txnAmount;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching balance! Please try again.");
        }
        return balance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            setVisible(false);
            dispose();
            new Transaction(pin);
        }
    }

    public static void main(String[] args) {
        new Balance("");
    }
}
