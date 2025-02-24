package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastCash extends JFrame implements ActionListener {
    FastCash(){
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {

    }
}
