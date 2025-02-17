package controller;

import repository.RepoConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Registration3 extends JFrame implements ActionListener {
    String formno;
    JRadioButton rb1,rb2,rb3,rb4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit;
   public Registration3(String appno){
        super("NEW USER REGISTRATION");
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/logo1.png"));
        Image i2=i1.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,100,75);
        add(image);
        JLabel label1= new JLabel("Account Details");
        label1.setBounds(275,20,600,40);
        label1.setFont(new Font("Arial Black",Font.BOLD,30));
        add(label1);
        this.formno=appno;

        //pageno
       JLabel pg= new JLabel("Page 3");
       pg.setFont(new Font("Open Sans",Font.BOLD,16));
       pg.setBounds(750,5,100,22);
       add(pg);
        JLabel label2= new JLabel("Application no: "+ formno);
        label2.setBounds(330,63,600,40);;
        label2.setFont(new Font("Arial Black",Font.BOLD,16));
        label2.setForeground(new Color(86,2,21));
        add(label2);

        JLabel label3 = new JLabel("Account Type: ");
        label3.setFont(new Font( "Constantia",Font.BOLD,20));
        label3.setBounds(100,110,150,30);
        add(label3);
        // Radiobutton
       rb1=new JRadioButton("Savings Account");
       rb1.setFont(new Font("Open Sans",Font.BOLD,14));
       rb1.setBounds(100,140,175,30);
       rb1.setBackground(new Color(244,204,233));
       add(rb1);
       rb2=new JRadioButton("Current Account");
       rb2.setFont(new Font("Open Sans",Font.BOLD,14));
       rb2.setBounds(100,170,175,30);
       rb2.setBackground(new Color(244,204,233));
       add(rb2);
       rb3=new JRadioButton("Fixed Deposit Account");
       rb3.setFont(new Font("Open Sans",Font.BOLD,14));
       rb3.setBounds(350,140,225,30);
       rb3.setBackground(new Color(244,204,233));
       add(rb3);
       rb4=new JRadioButton("Recurring Deposit Account");
       rb4.setFont(new Font("Open Sans",Font.BOLD,14));
       rb4.setBounds(350,170,225,30);
       rb4.setBackground(new Color(244,204,233));
       add(rb4);
       ButtonGroup buttonGroup=new ButtonGroup();
       buttonGroup.add(rb1);
       buttonGroup.add(rb2);
       buttonGroup.add(rb3);
       buttonGroup.add(rb4);
       // CardNumber

//       JLabel label4 = new JLabel("Debit Card Number");
//       label4.setFont(new Font( "Constantia",Font.BOLD,20));
//       label4.setBounds(100,220,225,30);
//       add(label4);
//       JLabel label5 = new JLabel("(16 digit card number)");
//       label5.setFont(new Font( "Constantia",Font.PLAIN,14));
//       label5.setBounds(100,240,225,30);
//       add(label5);

       JLabel label6 = new JLabel("Services Required");
       label6.setFont(new Font( "Constantia",Font.BOLD,20));
       label6.setBounds(100,280,200,30);
       add(label6);

       c1=new JCheckBox("SMS Alert");
       c1.setFont(new Font("Open Sans",Font.BOLD,14));
       c1.setBounds(100,310,225,30);
       c1.setBackground(new Color(244,204,233));
       add(c1);
       c2=new JCheckBox("Internet Banking");
       c2.setFont(new Font("Open Sans",Font.BOLD,14));
       c2.setBounds(100,340,225,30);
       c2.setBackground(new Color(244,204,233));
       add(c2);
       c3=new JCheckBox("E-Statement");
       c3.setFont(new Font("Open Sans",Font.BOLD,14));
       c3.setBounds(350,310,225,30);
       c3.setBackground(new Color(244,204,233));
       add(c3);
       c4=new JCheckBox("Cheque Book");
       c4.setFont(new Font("Open Sans",Font.BOLD,14));
       c4.setBounds(350,340,225,30);
       c4.setBackground(new Color(244,204,233));
       add(c4);
       c5=new JCheckBox("Email Alerts");
       c5.setFont(new Font("Open Sans",Font.BOLD,14));
       c5.setBounds(100,370,225,30);
       c5.setBackground(new Color(244,204,233));
       add(c5);
       c6=new JCheckBox("Debit/ATM Card");
       c6.setFont(new Font("Open Sans",Font.BOLD,14));
       c6.setBounds(350,370,225,30);
       c6.setBackground(new Color(244,204,233));
       add(c6);

       c7=new JCheckBox("<html>I hereby declare that the information provided in this form is true, complete, and accurate to the best of my knowledge. I understand that any false or misleading information may result in legal consequences</html>");
       c7.setFont(new Font("Open Sans",Font.BOLD,12));
       c7.setBounds(100,420,700,70);
       c7.setBackground(new Color(244,204,233));
       add(c7);

       submit=new JButton("Submit");
       submit.setFont(new Font( "Constantia",Font.BOLD,20));
       submit.setBackground(new Color(86,2,21));
       submit.setForeground(Color.WHITE);
       submit.setBounds(500,500,120,30);
       submit.addActionListener(this);
       add(submit);


        getContentPane().setBackground(new Color(244,204,233));
        setLayout(null);
        setSize(850,600);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acType=null;
        if(rb1.isSelected()){
            acType="Savings Account";
        } else if (rb2.isSelected()) {
            acType="Current Account";
        } else if (rb3.isSelected()) {
            acType="Fixed Deposit Account";
        } else if (rb4.isSelected()) {
            acType="Recurring Deposit Account";
        }

        Random ran= new Random();
        long first7 = (Math.abs(ran.nextLong()) % 9000000L) + 1000000L;
        long remaining9 = (Math.abs(ran.nextLong()) % 900000000L) + 100000000L;
        String cardno = first7 + "" + remaining9;

        String pin = String.valueOf(ran.nextInt(9000) + 1000);
        String feature="";
        if(c1.isSelected()){
            feature+= "SMS Alert";
        } else if (c2.isSelected()) {
            feature+="Internet Banking";
        } else if (c3.isSelected()) {
            feature+="E-Statement";
        } else if (c4.isSelected()) {
            feature+="Cheque Book";
        } else if (c5.isSelected()) {
            feature+="Email Alerts";
        } else if (c6.isSelected()) {
            feature+="Debit/ATM Card";
        }
        try{
                if (acType.equals("")){
                    JOptionPane.showMessageDialog(null,"All the fields are required");
                }else {
                    RepoConnection repo= new RepoConnection();
                    String q="INSERT INTO registrationthree VALUES('"+formno+"','"+acType+"','"+cardno+"','"+pin+"','"+feature+"')";
                    String q1="INSERT INTO login VALUES('"+formno+"','"+cardno+"','"+pin+"')";
                    repo.statement.executeUpdate(q);
                    repo.statement.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Your card number: "+cardno+ "\n Your Pin: "+pin);
                    new Deposit(pin);
                    setVisible(false);
                }


        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Registration3("");
    }
}
