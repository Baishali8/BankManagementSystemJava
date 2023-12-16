package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardField;
    JPasswordField pinField;

    Login(){
        setTitle("B.D. Bank"); // ->Title

        setLayout(null); // ->Layout of the Frame

        // For Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); //-> Takes the image from system
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); //-> Change Size of the Image
        ImageIcon i3 = new ImageIcon(i2); //-> Converts image size to image icon
        JLabel label = new JLabel(i3); //-> Image cannot be placed in the screen without this.
        label.setBounds(70, 10, 100, 100); //-> Change Location
        add(label);

        // For Heading
        JLabel text = new JLabel("Welcome to B.D.Bank");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);


        // For Card No.
        JLabel card = new JLabel("Card No: ");
        card.setFont(new Font("Raleway", Font.BOLD, 28));
        card.setBounds(120, 150, 150, 30);
        add(card);

        // Card Text Field
        cardField = new JTextField();
        cardField.setBounds(300, 150, 230, 30);
        cardField.setFont( new Font("Arial", Font.BOLD, 14));
        add(cardField);

        // For Pin
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        // Pin Text Field
        pinField = new JPasswordField();
        pinField.setBounds(300, 220, 230, 30);
        pinField.setFont( new Font("Arial", Font.BOLD, 14));
        add(pinField);

        // Buttons
        login = new JButton("Sign In");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE); // -> Changes Color of the Frame

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardField.setText("");
            pinField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardNumber = cardField.getText();
            String pinNumber = pinField.getText();
            String query = "SELECT * FROM login WHERE card_number = '"+cardNumber+"' AND pin = '"+pinNumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(cardNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
