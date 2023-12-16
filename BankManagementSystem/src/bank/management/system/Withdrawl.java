package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount1;
    JButton withdrawl, back;
    String accNumber;

    Withdrawl(String accNumber){
        this.accNumber = accNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0, 0, 900, 900);
        add(Image);

        JLabel text = new JLabel("Enter the amount you want to withdraw: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        text.setBounds(170, 320, 370, 20);
        Image.add(text);

        amount1 = new JTextField();
        amount1.setFont(new Font("Raleway", Font.BOLD, 22));
        amount1.setBounds(170, 350, 320, 25);
        Image.add(amount1);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355, 485, 150, 30);
        withdrawl.addActionListener(this);
        Image.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        Image.add(back);


        setSize(900, 900);
        setLocation(300, 9);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawl){
            String amount = amount1.getText();
            Date date = new Date();
            if(amount1.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw.");
            } else{
                try{
                    Conn conn = new Conn();

                    ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE accountNo = '"+ accNumber +"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                        return;
                    }

                    String query = "INSERT INTO bank VALUES ('" + accNumber + "', '" + date + "', 'Withdrawal', '" + amount + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" has been withdraw successfully.");
                    setVisible(false);
                    new Transaction(accNumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }

            }
        } else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(accNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
