package controller;

import repository.RepoConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener {
    public static String pin;
    JPasswordField newP,RNew;
    JButton b1,b2,b3;
    PinChange(String pin){
        this.pin=pin;
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
        getContentPane().setBackground(new Color(232, 249, 255));
        setLayout(null);
        setSize(1195, 1080);
        setLocation(0, 0);
        setVisible(true);
        JLabel label2 = new JLabel("CHANGE YOUR PIN");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label2.setForeground(Color.YELLOW);
        label2.setBounds(450, 250, 400, 35);
        l1.add(label2);
        JLabel label3 = new JLabel("New PIN");
        label3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label3.setForeground(Color.white);
        label3.setBounds(200, 300, 200, 35);
        l1.add(label3);
        JLabel label4 = new JLabel("Re-Enter New PIN");
        label4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label4.setForeground(Color.white);
        label4.setBounds(200, 350, 300, 35);
        l1.add(label4);

        newP=new JPasswordField();
        newP.setBounds(380,300,200,30);
        newP.setFont(new Font("Arial",Font.BOLD,30));
        newP.setBackground(new Color(217, 234, 253));
        l1.add(newP);

        RNew=new JPasswordField();
        RNew.setBounds(380,350,200,30);
        RNew.setFont(new Font("Arial",Font.BOLD,30));
        RNew.setBackground(new Color(217, 234, 253));
        l1.add(RNew);

        b1=new JButton("SUBMIT");
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Submit
            if (e.getSource() == b1) {
                String pass1 = newP.getText().trim();
                String pass2 = RNew.getText().trim();

                if (pass1.isEmpty() && pass2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter 4 digit Pin");
                    return;
                }

                if ((!pass1.matches("\\d+")) && (!pass2.matches("\\d+"))) { // Ensures only digits
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid Pin");
                    return;
                }
                if ((pass1.length() != 4) || (pass2.length() != 4)) {
                    JOptionPane.showMessageDialog(null, "PIN should be in 4 digits");
                }
                if (!pass1.equals(pass2)) {
                    JOptionPane.showMessageDialog(null, "Password Mismatch");
                }

                RepoConnection repo = new RepoConnection();
                String q1 = "UPDATE bank SET pin = '" + pass1 + "' WHERE pin = '" + pin + "'";
                String q2 = "UPDATE login SET pin = '" + pass1 + "' WHERE pin = '" + pin + "'";
                String q3 = "UPDATE registrationthree SET pin = '" + pass1 + "' WHERE pin = '" + pin + "'";

                repo.statement.executeUpdate(q1);
                repo.statement.executeUpdate(q2);
                repo.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                setVisible(false);
                new Transaction(pass1);
            } else if (e.getSource() == b2) {
                newP.setText("");
                RNew.setText("");
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
        }catch (Exception E) {
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
