package controller;

import repository.RepoConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration2 extends JFrame implements ActionListener {
        String formno;

        JTextField religion,panNumber,aadharNumber;
        JComboBox drop,drop1,drop2;
    JButton next;
    public Registration2( String appno){
        super("NEW USER REGISTRATION");
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/logo1.png"));
        Image i2=i1.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,100,75);
        add(image);

        this.formno=appno;


        JLabel label1= new JLabel("REGISTRATION FORM");
        label1.setBounds(210,20,600,40);
        label1.setFont(new Font("Arial Black",Font.BOLD,30));
        add(label1);

        // Page No:
        JLabel label2= new JLabel("Page 2");
        label2.setFont(new Font("Open Sans",Font.BOLD,16));
        label2.setBounds(750,5,100,22);
        add(label2);

        //Application no
        JLabel label3= new JLabel("Application no: "+ formno);
        label3.setBounds(330,63,600,40);;
        label3.setFont(new Font("Arial Black",Font.BOLD,16));
        label3.setForeground(new Color(86,2,21));
        add(label3);

        //Religion
        JLabel Religion= new JLabel("Religion");
        Religion.setFont(new Font( "Constantia",Font.BOLD,20));
        Religion.setBounds(100,140,150,30);
        add(Religion);

        religion=new JTextField();
        religion.setFont(new Font("Open Sans",Font.BOLD,14));
        religion.setBounds(300,140,300,30);
        add(religion);

        //Category
        JLabel Category=new JLabel("Category");
        Category.setFont(new Font( "Constantia",Font.BOLD,20));
        Category.setBounds(100,190,150,30);
        add(Category);

        String[] cat={"General","OBC","SC","ST","Other"};
        drop=new JComboBox<>(cat);
        drop.setFont(new Font("Open Sans",Font.BOLD,14));
        drop.setBounds(300,190,150,30);
        drop.setForeground(new Color(86,2,21));
        add(drop);

        //Education
        JLabel Education=new JLabel("Education");
        Education.setFont(new Font( "Constantia",Font.BOLD,20));
        Education.setBounds(100,240,150,30);
        add(Education);

        String[] edu={"Non-Graduate","Graduate","Other"};
        drop1=new JComboBox<>(edu);
        drop1.setFont(new Font("Open Sans",Font.BOLD,14));
        drop1.setBounds(300,240,150,30);
        drop1.setForeground(new Color(86,2,21));
        add(drop1);

        //Occupation
        JLabel Occupation=new JLabel("Occupation");
        Occupation.setFont(new Font( "Constantia",Font.BOLD,20));
        Occupation.setBounds(100,290,150,30);
        add(Occupation);

        String[] ocu={"Private","Self-employed","Government","Business","Retired","Others"};
        drop2=new JComboBox<>(ocu);
        drop2.setFont(new Font("Open Sans",Font.BOLD,14));
        drop2.setBounds(300,290,150,30);
        drop2.setForeground(new Color(86,2,21));
        add(drop2);

        //PanNumber
        JLabel PanNumber= new JLabel("Pan Number");
        PanNumber.setFont(new Font( "Constantia",Font.BOLD,20));
        PanNumber.setBounds(100,340,150,30);
        add(PanNumber);

        panNumber=new JTextField();
        panNumber.setFont(new Font("Open Sans",Font.BOLD,14));
        panNumber.setBounds(300,340,300,30);
        add(panNumber);

        //AadharNumber
        JLabel AadharNumber= new JLabel("Aadhaar Number");
        AadharNumber.setFont(new Font( "Constantia",Font.BOLD,20));
        AadharNumber.setBounds(100,390,170,30);
        add(AadharNumber);

        aadharNumber=new JTextField();
        aadharNumber.setFont(new Font("Open Sans",Font.BOLD,14));
        aadharNumber.setBounds(300,390,300,30);
        add(aadharNumber);

        //Next Button

        next=new JButton("Next");
        next.setFont(new Font( "Constantia",Font.BOLD,20));
        next.setBackground(new Color(86,2,21));
        next.setForeground(Color.WHITE);
        next.setBounds(620,440,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(244,204,233));
        setLayout(null);
        setSize(850,600);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String rel=religion.getText();
        String cate=(String)drop.getSelectedItem();
        String educ=(String)drop1.getSelectedItem();
        String ocup=(String)drop2.getSelectedItem();
        String panc=panNumber.getText();
        String adr=aadharNumber.getText();

        try{
            if (religion.getText().equals("")||panNumber.getText().equals("")||aadharNumber.getText().equals("")){
                JOptionPane.showMessageDialog(null,"All the fields are required");
            }if(aadharNumber.getText().length()<12||aadharNumber.getText().length()>12){
                JOptionPane.showMessageDialog(null,"Enter 12 digit Aadhaar Number");
            }else {
                RepoConnection repo = new RepoConnection();
                String q = "INSERT INTO registrationtwo VALUES('" + formno + "','" + rel + "','" + cate + "','" + educ + "','" + ocup + "','" + panc + "','" + adr + "')";
                repo.statement.executeUpdate(q);
                new Registration3(formno);
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Registration2("");
    }
}
