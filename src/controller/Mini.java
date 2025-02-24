package controller;

import repository.RepoConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    static String pin;
    JButton b1;
    Mini(String pin){
        this.pin=pin;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(400,600);
        setLocation(500,200);
//        ImageIcon machine=new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
//        Image img=machine.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
//        ImageIcon img1=new ImageIcon(img);
//        JLabel l1=new JLabel(img1);
//        l1.setBounds(0,0,1150,830);
//        add(l1);
//        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/logo.png"));
//        Image i2=i1.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(130,138,150,100);
//        l1.add(image);
//        JLabel label1=new JLabel("WELCOME TO MONEY BANK ATM");
//        label1.setFont(new Font("Constantia",Font.BOLD,25));
//        label1.setForeground(Color.white);
//        label1.setBounds(340,180,450,35);
//        l1.add(label1);

        JLabel label1= new JLabel("MINI STATEMENT");
        label1.setFont(new Font("Constantia",Font.BOLD,20));
        label1.setForeground(Color.BLACK);
        label1.setBounds(20,20,200,20);
        add(label1);

        JLabel label2= new JLabel();
        label2.setBounds(20,140,400,250);;
        add(label2);

        JLabel label3= new JLabel();
        label3.setBounds(20,50,350,20);
        label3.setFont(new Font("Arial Black",Font.BOLD,16));
        add(label3);

        JLabel label4= new JLabel();
        label4.setBounds(470,550,300,20);
        add(label4);

        JLabel label5= new JLabel();
        label5.setBounds(20,430,300,20);
        add(label5);

        try{
            RepoConnection repo=new RepoConnection();
            ResultSet resultSet=repo.statement.executeQuery("SELECT * FROM login WHERE pin = '"+pin+"'");
            while(resultSet.next()){
                label3.setText("Card Number: "+resultSet.getString("card_no").substring(0,4)+"XXXXXXXX"+resultSet.getString("card_no").substring(12));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            int balance=0;
            RepoConnection repo=new RepoConnection();
            ResultSet resultSet = repo.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            while (resultSet.next()) {
                label2.setText(label2.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getInt("amount")+"<br><br><html>");


                String type = resultSet.getString("type");
                int txnAmount = resultSet.getInt("amount");
                if (type.equals("Deposit")) {
                    balance += txnAmount;
                } else if (type.equals("Withdrawal")) {
                    balance -= txnAmount;
                }
            }
            label5.setText("Your total balance in Rs: "+balance);

        }catch (Exception e){
            e.printStackTrace();
        }

        b1=new JButton("Exit");
        b1.setBounds(20,500,100,25);
        b1.setFont(new Font("Arial Black",Font.BOLD,16));
        b1.setBackground(new Color(217, 234, 253));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Transaction(pin);
        setVisible(false);

    }

    public static void main(String[] args) {
        new Mini("");

    }
}
