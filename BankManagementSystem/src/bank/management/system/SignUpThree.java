package bank.management.system;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton saving, current, reccuring, fd;
    JCheckBox check1, check2, check3, check4, check5, check6, declaration;
    JButton submit, cancel;
    String formno;

    SignUpThree( String formno){
        this.formno = formno;
        setTitle("B.D. Bank Application Form Page. 3");
        setLayout(null);

        JLabel details = new JLabel("Page 3: Account Details");
        details.setFont(new Font("Raleway", Font.BOLD, 22));
        details.setBounds(280, 40, 400, 40);
        add(details);

        JLabel type = new JLabel("Account Type: ");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        saving = new JRadioButton("Savings Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 14));
        saving.setBounds(100, 180, 250, 20);
        saving.setBackground(Color.WHITE);
        add(saving);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 14));
        current.setBounds(350, 180, 250, 20);
        current.setBackground(Color.WHITE);
        add(current);

        reccuring = new JRadioButton("Reccuring Deposit Account");
        reccuring.setFont(new Font("Raleway", Font.BOLD, 14));
        reccuring.setBounds(100, 220, 250, 20);
        reccuring.setBackground(Color.WHITE);
        add(reccuring);

        fd = new JRadioButton("Fixed Deposit Account");
        fd.setFont(new Font("Raleway", Font.BOLD, 14));
        fd.setBounds(350, 220, 250, 20);
        fd.setBackground(Color.WHITE);
        add(fd);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(saving);
        accountGroup.add(current);
        accountGroup.add(reccuring);
        accountGroup.add(fd);

        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel cardnumber = new JLabel("XXXX-XXXX-XXXX-4879");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        cardnumber.setBounds(330, 300, 300, 30);
        add(cardnumber);

        JLabel cardinfo = new JLabel("Your 16 digit card number");
        cardinfo.setFont(new Font("Raleway", Font.BOLD, 12));
        cardinfo.setBounds(100, 330, 300, 15);
        add(cardinfo);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pinnumber.setBounds(330, 370, 300, 30);
        add(pinnumber);

        JLabel pininfo = new JLabel("Your 4 digit Password");
        pininfo.setFont(new Font("Raleway", Font.BOLD, 12));
        pininfo.setBounds(100, 400, 300, 15);
        add(pininfo);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 30);
        add(services);

        check1 = new JCheckBox("Debit Card");
        check1.setBackground(Color.WHITE);
        check1.setFont(new Font("Raleway", Font.BOLD, 14));
        check1.setBounds(100, 500, 200, 30);
        add(check1);

        check2 = new JCheckBox("Internet Banking");
        check2.setBackground(Color.WHITE);
        check2.setFont(new Font("Raleway", Font.BOLD, 14));
        check2.setBounds(350, 500, 200, 30);
        add(check2);

        check3 = new JCheckBox("Mobile Banking");
        check3.setBackground(Color.WHITE);
        check3.setFont(new Font("Raleway", Font.BOLD, 14));
        check3.setBounds(100, 550, 200, 30);
        add(check3);

        check4 = new JCheckBox("Email/SMS Alerts");
        check4.setBackground(Color.WHITE);
        check4.setFont(new Font("Raleway", Font.BOLD, 14));
        check4.setBounds(350, 550, 200, 30);
        add(check4);

        check5 = new JCheckBox("Check Book");
        check5.setBackground(Color.WHITE);
        check5.setFont(new Font("Raleway", Font.BOLD, 14));
        check5.setBounds(100, 600, 200, 30);
        add(check5);

        check6 = new JCheckBox("E-Statements");
        check6.setBackground(Color.WHITE);
        check6.setFont(new Font("Raleway", Font.BOLD, 14));
        check6.setBounds(350, 600, 200, 30);
        add(check6);

        declaration = new JCheckBox("I here by declare above details are correct to the best of my knowledge.");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway", Font.BOLD, 12));
        declaration.setBounds(100, 680, 600, 30);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBounds(250, 720, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 720, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);

        setSize(850, 820);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(saving.isSelected()){
                accountType = "Savings Account";
            } else if (current.isSelected()) {
                accountType = "Current Account";
            } else if (reccuring.isSelected()) {
                accountType = "Recurring Deposit Account";
            } else if (fd.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            Random rand = new Random();
            String cardNum = "" + Math.abs((rand.nextLong() % 90000000L) + 1010000000000000L);
            String pinNum = "" + Math.abs((rand.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(check1.isSelected()){
                facility = facility+ " Debit Card";
            }
            if (check2.isSelected()) {
                facility = facility + " Internet Banking";
            }
            if (check3.isSelected()) {
                facility = facility + " Mobile Banking";
            }
            if (check4.isSelected()) {
                facility = facility + " Email/SMS Alerts";
            }
            if (check5.isSelected()) {
                facility = facility + " Check Book";
            }
            if (check6.isSelected()) {
                facility = facility + " E-Statement";
            }

            try{
                Conn c = new Conn();
                String query = "INSERT INTO signupthree VALUES ('" + formno + "', '" + accountType + "', '" + cardNum + "', '" + pinNum + "', '" + facility + "')";
                String query2 = "INSERT INTO login VALUES ('" + formno + "', '" + cardNum + "', '" + pinNum + "')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardNum +"\nPin: " + pinNum);

                setVisible(false);
                new Deposit(cardNum).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
