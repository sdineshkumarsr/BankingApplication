package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    String pin;
    JButton b1,b2,b3,b4,b5,b6,b7;
    public Transaction(String pin){
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

        JLabel label2=new JLabel("Please Select Your Transaction");
        label2.setFont(new Font("Times New Roman",Font.BOLD,20));
        label2.setForeground(Color.white);
        label2.setBounds(390,230,400,35);
        l1.add(label2);

        b1=new JButton("DEPOSIT");
        b1.setBounds(165,300,250,45);
        b1.setFont(new Font("Arial Black",Font.BOLD,16));
        b1.setBackground(new Color(217, 234, 253));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);
        b2=new JButton("FAST CASH");
        b2.setBounds(165,370,250,45);
        b2.setFont(new Font("Arial Black",Font.BOLD,16));
        b2.setBackground(new Color(217, 234, 253));
        b2.setForeground(Color.BLACK);
         b2.addActionListener(this);
        l1.add(b2);
        b3=new JButton("PIN CHANGE");
        b3.setBounds(165,440,250,45);
        b3.setFont(new Font("Arial Black",Font.BOLD,16));
        b3.setBackground(new Color(217, 234, 253));
        b3.setForeground(Color.BLACK);
         b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("CASH WITHDRAWAL");
        b4.setBounds(600,300,250,45);
        b4.setFont(new Font("Arial Black",Font.BOLD,16));
        b4.setBackground(new Color(217, 234, 253));
        b4.setForeground(Color.BLACK);
         b4.addActionListener(this);
        l1.add(b4);
        b5=new JButton("MINI STATEMENT");
        b5.setBounds(600,370,250,45);
        b5.setFont(new Font("Arial Black",Font.BOLD,16));
        b5.setBackground(new Color(217, 234, 253));
        b5.setForeground(Color.BLACK);
         b5.addActionListener(this);
        l1.add(b5);
        b6=new JButton("BALANCE ENQUIRY");
        b6.setBounds(600,440,250,45);
        b6.setFont(new Font("Arial Black",Font.BOLD,16));
        b6.setBackground(new Color(217, 234, 253));
        b6.setForeground(Color.BLACK);
         b6.addActionListener(this);
        l1.add(b6);
        b7=new JButton("EXIT");
        b7.setBounds(600,510,250,45);
        b7.setFont(new Font("Arial Black",Font.BOLD,16));
        b7.setBackground(new Color(217, 234, 253));
        b7.setForeground(Color.BLACK);
         b7.addActionListener(this);
        l1.add(b7);



        getContentPane().setBackground(new Color(232, 249, 255));
        setLayout(null);
        setSize(1195,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            //Deposit
            if(e.getSource()==b1){
                new Deposit(pin);
                setVisible(false);
            //FastCash
            } else if (e.getSource()==b2) {
                new FastCash(pin);
                setVisible(false);
            //PinChange
            } else if (e.getSource()==b3) {
                new PinChange(pin);
                setVisible(false);

            } else if (e.getSource()==b4) {
                new Withdraw(pin);
                setVisible(false);
            //Mini Statement
            } else if (e.getSource()==b5) {
                new Mini(pin);
                setVisible(false);

            } else if (e.getSource()==b6) {
                new Balance(pin);
                setVisible(false);

            } else if (e.getSource()==b7) {
                System.exit(0);
                setVisible(false);

            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
