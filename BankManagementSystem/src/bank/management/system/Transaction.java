package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastcash, miniStatement, pinChange, balanceEnquiry, exit;
    String accNumber;

    Transaction(String accNumber){
        this.accNumber = accNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0, 0, 900, 900);
        add(Image);

        JLabel text = new JLabel("Please select Your Transaction: ");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        Image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        Image.add(deposit);

        withdrawl = new JButton("Cash Withdrawal");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        Image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        Image.add(fastcash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        Image.add(miniStatement);

        pinChange = new JButton("Change Pin");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        Image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355, 485, 150, 30);
        balanceEnquiry.addActionListener(this);
        Image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        Image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        } else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(accNumber).setVisible(true);
        } else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(accNumber).setVisible(true);
        } else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(accNumber).setVisible(true);
        }else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(accNumber).setVisible(true);
        }else if(ae.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(accNumber).setVisible(true);
        }else if(ae.getSource()==miniStatement){
            new MiniStatement(accNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
