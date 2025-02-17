package controller;

import repository.RepoConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LogIn extends JFrame implements ActionListener {
    JLabel label,label1,label2;
    JTextField field1;
    JPasswordField pField;

    JButton button1,button2,button3,button4;
    LogIn(){
        super("Bank Accounts Management");
        // Logo
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/logo.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(10,10,150,100);
        add(image);

        label=new JLabel("Welcome to MoneyBank ATM");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Gill Sans MT",Font.BOLD,38));
        label.setBounds(200,40,700,43);
        add(label);
        // Card Number
        label1=new JLabel("Card no: ");
        label1.setFont(new Font("Constantia",Font.BOLD,28));
        label1.setForeground(Color.WHITE);
        label1.setBounds(150,190,383,30);
        add(label1);

        field1=new JTextField(15);
        field1.setBounds(325,190,235,30);
        field1.setFont(new Font("Arial",Font.BOLD,25));
        add(field1);

        // PIN
        label2=new JLabel("PIN: ");
        label2.setFont(new Font("Constantia",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,250,383,30);
        add(label2);

        pField=new JPasswordField(15);
        pField.setBounds(325,250,235,30);
        pField.setFont(new Font("Arial",Font.BOLD,30));
        add(pField);

        button1= new JButton("SIGN IN");
        button1.setFont(new Font("Constantia",Font.BOLD,18));
        button1.setForeground(Color.BLACK);
        button1.setBackground(new Color(178,165,255));
        button1.setBounds(325,300,115,30);
        button1.addActionListener(this);
        add(button1);

        button2= new JButton("CLEAR");
        button2.setFont(new Font("Constantia",Font.BOLD,18));
        button2.setForeground(Color.BLACK);
        button2.setBackground(new Color(178,165,255));
        button2.setBounds(450,300,115,30);
        button2.addActionListener(this);
        add(button2);

        button3= new JButton("REGISTER");
        button3.setFont(new Font("Constantia",Font.BOLD,18));
        button3.setForeground(Color.BLACK);
        button3.setBackground(new Color(178,165,255));
        button3.setBounds(325,350,235,30);
        button3.addActionListener(this);
        add(button3);

        // Background
        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("images/Bg.png"));
        Image i5=i4.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel imageB=new JLabel(i6);
        imageB.setBounds(0,0,850,480);
        add(imageB);
        setLayout(null);
        setUndecorated(true);

        setLocation(450,200);

        setSize(850,480);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    try{
        if(e.getSource() ==button1){
            RepoConnection repo=new RepoConnection();
            String cardno= field1.getText();
            String pins=new String(pField.getPassword());
            String q = "SELECT * FROM login WHERE card_no = '" + cardno + "' AND pin = '" + pins + "'";
            ResultSet resultSet=repo.statement.executeQuery(q);
            if(resultSet.next()){
                setVisible(false);
                new Transaction(pins);
            }else {
                JOptionPane.showMessageDialog(null,"Incorrect Card Number Or Pin");
            }
        } else if (e.getSource()==button2) {
            field1.setText("");
            pField.setText("");

        } else if (e.getSource()==button3) {
            new Register();

        }
    }catch (Exception E){
        E.printStackTrace();
    }
    }

    public static void main(String[] args) {
        LogIn logIn = new LogIn();
    }
}
