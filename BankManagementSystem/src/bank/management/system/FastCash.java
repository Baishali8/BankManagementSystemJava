package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton amount1, amount2, amount3, amount4, amount5, amount6, back;
    String accNumber;

    FastCash(String accNumber){
        this.accNumber = accNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0, 0, 900, 900);
        add(Image);

        JLabel text = new JLabel("Select Withdrawl Amount: ");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        Image.add(text);

        amount1 = new JButton("Rs. 100");
        amount1.setBounds(170, 415, 150, 30);
        amount1.addActionListener(this);
        Image.add(amount1);

        amount2 = new JButton("Rs. 200");
        amount2.setBounds(355, 415, 150, 30);
        amount2.addActionListener(this);
        Image.add(amount2);

        amount3 = new JButton("Rs. 1000");
        amount3.setBounds(170, 450, 150, 30);
        amount3.addActionListener(this);
        Image.add(amount3);

        amount4 = new JButton("Rs. 2000");
        amount4.setBounds(355, 450, 150, 30);
        amount4.addActionListener(this);
        Image.add(amount4);

        amount5 = new JButton("Rs. 5000");
        amount5.setBounds(170, 485, 150, 30);
        amount5.addActionListener(this);
        Image.add(amount5);

        amount6 = new JButton("Rs. 10000");
        amount6.setBounds(355, 485, 150, 30);
        amount6.addActionListener(this);
        Image.add(amount6);

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
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(accNumber).setVisible(true);
        } else{
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE accountNo = '"+ accNumber +"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                } else {
                    Date date = new Date();
                    String query = "INSERT INTO bank VALUES('" + accNumber + "', '" + date + "', 'Withdrawal', '" + amount + "')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " withdraw successfully!");
                    setVisible(false);
                    new Transaction(accNumber).setVisible(true);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
