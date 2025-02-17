package controller;

import com.toedter.calendar.JDateChooser;
import repository.RepoConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class Register extends JFrame implements ActionListener {
    Random ran= new Random();
    long ran4=(ran.nextLong() % 9000L)+1000L;
    String appno=" "+Math.abs(ran4);
    JTextField textName,lastName,fatherName,email,address,city,pin,state;
    JDateChooser dob;
    JComboBox drop;
    JRadioButton rb1,rb2,rb3;
    JButton next,back;



    public Register(){
        super("NEW USER REGISTRATION");
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/logo1.png"));
        Image i2=i1.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,100,75);
        add(image);

        JLabel label1= new JLabel("REGISTRATION FORM");
        label1.setBounds(210,20,600,40);
        label1.setFont(new Font("Arial Black",Font.BOLD,30));
        add(label1);

        JLabel label2= new JLabel("Application no: "+ appno);
        label2.setBounds(330,63,600,40);;
        label2.setFont(new Font("Arial Black",Font.BOLD,16));
        label2.setForeground(new Color(86,2,21));
        add(label2);

        JLabel label3= new JLabel("Page 1");
        label3.setFont(new Font("Open Sans",Font.BOLD,16));
        label3.setBounds(750,5,100,22);
        add(label3);
        //----------------------------------
        // First name
        JLabel labelName= new JLabel("First Name");
        labelName.setFont(new Font( "Constantia",Font.BOLD,20));
        labelName.setBounds(100,140,150,30);
        add(labelName);

        textName=new JTextField();
        textName.setFont(new Font("Open Sans",Font.BOLD,14));
        textName.setBounds(300,140,300,30);
        add(textName);
        // Last Name
        JLabel name2= new JLabel("Last Name");
        name2.setFont(new Font( "Constantia",Font.BOLD,20));
        name2.setBounds(100,190,150,30);
        add(name2);

        lastName=new JTextField();
        lastName.setFont(new Font("Open Sans",Font.BOLD,14));
        lastName.setBounds(300,190,300,30);
        add(lastName);

        //Fathers Name
        JLabel fName= new JLabel("Father's Name");
        fName.setFont(new Font( "Constantia",Font.BOLD,20));
        fName.setBounds(100,240,150,30);
        add(fName);

        fatherName=new JTextField();
        fatherName.setFont(new Font("Open Sans",Font.BOLD,14));
        fatherName.setBounds(300,240,300,30);
        add(fatherName);
        //DOB
        JLabel birth= new JLabel("D.O.B");
        birth.setFont(new Font( "Constantia",Font.BOLD,20));
        birth.setBounds(100,290,150,30);
        add(birth);

        dob=new JDateChooser();
        dob.setForeground(new Color(209,125,152));
        dob.setFont(new Font("Open Sans",Font.BOLD,14));
        dob.setBounds(300,290,150,30);
        add(dob);



        //Gender
        JLabel Glabel=new JLabel("Sex");
        Glabel.setFont(new Font( "Constantia",Font.BOLD,20));
        Glabel.setBounds(100,340,150,30);
        add(Glabel);

        String[] gender={"Male","Female","Others"};
        drop=new JComboBox<>(gender);
        drop.setFont(new Font("Open Sans",Font.BOLD,14));
        drop.setBounds(300,340,150,30);
        drop.setForeground(new Color(209,125,152));
        add(drop);

        //Email
        JLabel LableEmail=new JLabel("E-Mail");
        LableEmail.setFont(new Font( "Constantia",Font.BOLD,20));
        LableEmail.setBounds(100,390,150,30);
        add(LableEmail);

        email=new JTextField();
        email.setFont(new Font("Open Sans",Font.BOLD,14));
        email.setBounds(300,390,300,30);
        add(email);

        // Marriage
        JLabel LableMarriage=new JLabel("Marital status");
        LableMarriage.setFont(new Font( "Constantia",Font.BOLD,20));
        LableMarriage.setBounds(100,440,150,30);
        add(LableMarriage);

        rb1=new JRadioButton("Married");
        rb1.setFont(new Font("Open Sans",Font.BOLD,14));
        rb1.setBounds(300,440,100,30);
        rb1.setBackground(new Color(244,204,233));
        add(rb1);
        rb2=new JRadioButton("Unmarried");
        rb2.setFont(new Font("Open Sans",Font.BOLD,14));
        rb2.setBounds(400,440,105,30);
        rb2.setBackground(new Color(244,204,233));
        add(rb2);
        rb3=new JRadioButton("Other");
        rb3.setFont(new Font("Open Sans",Font.BOLD,14));
        rb3.setBounds(520,440,105,30);
        rb3.setBackground(new Color(244,204,233));
        add(rb3);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(rb1);
        buttonGroup.add(rb2);
        buttonGroup.add(rb3);
        //Address
        JLabel LableAdd=new JLabel("Address");
        LableAdd.setFont(new Font( "Constantia",Font.BOLD,20));
        LableAdd.setBounds(100,490,150,30);
        add(LableAdd);

        address=new JTextField();
        address.setFont(new Font("Open Sans",Font.BOLD,14));
        address.setBounds(300,490,300,30);
        add(address);
        //City
        JLabel Lablecity=new JLabel("City");
        Lablecity.setFont(new Font( "Constantia",Font.BOLD,20));
        Lablecity.setBounds(100,540,150,30);
        add(Lablecity);

        city=new JTextField();
        city.setFont(new Font("Open Sans",Font.BOLD,14));
        city.setBounds(300,540,300,30);
        add(city);
        //Pincode
        JLabel LablePin=new JLabel("PIN Code");
        LablePin.setFont(new Font( "Constantia",Font.BOLD,20));
        LablePin.setBounds(100,590,150,30);
        add(LablePin);

        pin=new JTextField();
        pin.setFont(new Font("Open Sans",Font.BOLD,14));
        pin.setBounds(300,590,300,30);
        add(pin);
        //State
        JLabel LableState=new JLabel("State");
        LableState.setFont(new Font( "Constantia",Font.BOLD,20));
        LableState.setBounds(100,640,150,30);
        add(LableState);

        state=new JTextField();
        state.setFont(new Font("Open Sans",Font.BOLD,14));
        state.setBounds(300,640,300,30);
        add(state);
        //Next Button

        next=new JButton("Next");
        next.setFont(new Font( "Constantia",Font.BOLD,20));
        next.setBackground(new Color(86,2,21));
        next.setForeground(Color.WHITE);
        next.setBounds(620,690,80,30);
        next.addActionListener(this);
        add(next);
        back=new JButton("Back");
        back.setFont(new Font( "Constantia",Font.BOLD,20));
        back.setBackground(new Color(86,2,21));
        back.setForeground(Color.WHITE);
        back.setBounds(500,690,80,30);
        back.addActionListener(this);
        add(back);


        getContentPane().setBackground(new Color(244,204,233));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno= appno;
        String fname= textName.getText();
        String laname=lastName.getText();
        String fathname=fatherName.getText();
        String birth= ((JTextField) dob.getDateEditor().getUiComponent()).getText();

        String gen=drop.getSelectedItem().toString();
        String mail=email.getText();
        String raddress=address.getText();
        String marriage=null;
        if(rb1.isSelected()){
            marriage="Married";
        } else if (rb2.isSelected()) {
            marriage="UnMarried";
        } else if (rb3.isSelected()) {
            marriage="Others";
        }
        String district=city.getText();
        String cstate=state.getText();
        String pincode=pin.getText();

        try{
            if(e.getSource()==next){
            if(textName.getText().equals("")||lastName.getText().equals("")||fatherName.getText().equals("")||fatherName.getText().equals("")||email.getText().equals("")||address.getText().equals("")||city.getText().equals("")||state.getText().equals("")||pin.getText().equals("")){
                JOptionPane.showMessageDialog(null,"All the fields are required");
            }else {
                RepoConnection repo=new RepoConnection();
                String q="INSERT INTO registration VALUES('"+formno+"','"+fname+"','"+laname+"','"+fathname+"','"+birth+"','"+gen+"','"+mail+"','"+raddress+"','"+marriage+"','"+district+"','"+cstate+"','"+pincode+"')";
                repo.statement.executeUpdate(q);
                new Registration2(appno);
                setVisible(false);
            }
            } else if (e.getSource()==back) {
                setVisible(false);
                new LogIn();

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}
