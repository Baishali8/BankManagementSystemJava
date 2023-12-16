package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    String accNumber;
    JPasswordField pin, repin;
    JButton change, back;
    PinChange(String accNumber){
        this.accNumber = accNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0, 0, 900, 900);
        add(Image);

        JLabel text = new JLabel("Change Your PIN:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(260, 300, 500, 20);
        Image.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 340, 180, 25);
        Image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 340, 180, 25);
        Image.add(pin);

        JLabel repintext = new JLabel("Re-enter New PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 380, 180, 25);
        Image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 380, 180, 25);
        Image.add(repin);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        Image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        Image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();

                if(npin.equals("rpin")){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not matched!");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter a PIN");
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter PIN");
                }

                Conn con = new Conn();
//                String query1 = "UPDATE bank SET pin = '"+rpin+"' WHERE accountNo = '"+ accNumber +"'";
                String query2 = "UPDATE login SET pin = '"+rpin+"' WHERE card_number = '"+ accNumber +"'";
                String query3 = "UPDATE signupthree SET pin = '"+rpin+"' WHERE card_number = '"+ accNumber +"'";

//                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Succesfully!");
                setVisible(false);
                new Transaction(accNumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transaction("").setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
