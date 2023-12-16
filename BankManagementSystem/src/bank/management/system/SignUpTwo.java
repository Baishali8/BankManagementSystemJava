package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    JComboBox religionField, categoryField, incomeField, eduField, occupationField;
    JTextField panField, aadharField;
    JRadioButton seniorY, seniorN, existY, existN;
    JButton next;
    String formno;

    SignUpTwo(String formno){
        this.formno = formno;
        setTitle("B.D. Bank Application Form Page. 2");
        setLayout(null);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(250, 80, 400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String[] valReligion = {"Hindu", "Muslim", "Christian", "Sikh", "Other"};
        religionField = new JComboBox(valReligion);
        religionField.setFont(new Font("Raleway", Font.BOLD, 14));
        religionField.setBounds(300, 140, 300, 30);
        religionField.setBackground(Color.WHITE);
        add(religionField);

        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String[] valCategory = {"General", "OBC", "SC", "ST", "Other"};
        categoryField = new JComboBox(valCategory);
        categoryField.setFont(new Font("Raleway", Font.BOLD, 14));
        categoryField.setBounds(300, 190, 300, 30);
        categoryField.setBackground(Color.WHITE);
        add(categoryField);

        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String[] valIncome = {"Null", "< 1,00,000", "< 2,50,000", "< 5,00,000", "< 10,00,000", "> 10,00,000"};
        incomeField = new JComboBox(valIncome);
        incomeField.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeField.setBounds(300, 240, 300, 30);
        incomeField.setBackground(Color.WHITE);
        add(incomeField);

        JLabel education = new JLabel("Educational ");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);

        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String[] valEdu = {"High School", "Graduation", "Post Graduation", "Doctorate", "Others"};
        eduField = new JComboBox(valEdu);
        eduField.setFont(new Font("Raleway", Font.BOLD, 14));
        eduField.setBounds(300, 315, 300, 30);
        eduField.setBackground(Color.WHITE);
        add(eduField);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 365, 200, 30);
        add(occupation);

        String[] valOccu = {"Student", "Unemployed", "Self Employed", "Employed", "Others"};
        occupationField = new JComboBox(valOccu);
        occupationField.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationField.setBounds(300, 365, 300, 30);
        occupationField.setBackground(Color.WHITE);
        add(occupationField);

        JLabel pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 415, 200, 30);
        add(pan);

        panField = new JTextField();
        panField.setFont(new Font("Raleway", Font.BOLD, 14));
        panField.setBounds(300, 415, 300, 30);
        add(panField);

        JLabel aadhar = new JLabel("Aadhaar Number: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 465, 200, 30);
        add(aadhar);

        aadharField = new JTextField();
        aadharField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharField.setBounds(300, 465, 300, 30);
        add(aadharField);

        JLabel senior = new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 515, 200, 30);
        add(senior);

        seniorY = new JRadioButton("Yes");
        seniorY.setBounds(300, 515, 60, 30);
        seniorY.setBackground(Color.WHITE);
        seniorY.setFont(new Font("Raleway", Font.BOLD, 14));
        add(seniorY);

        seniorN = new JRadioButton("No");
        seniorN.setBounds(400, 515, 60, 30);
        seniorN.setBackground(Color.WHITE);
        seniorN.setFont(new Font("Raleway", Font.BOLD, 14));
        add(seniorN);

        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(seniorY);
        citizenGroup.add(seniorN);

        JLabel exist = new JLabel("Existing Account: ");
        exist.setFont(new Font("Raleway", Font.BOLD, 20));
        exist.setBounds(100, 565, 200, 30);
        add(exist);

        existY = new JRadioButton("Yes");
        existY.setBounds(300, 565, 60, 30);
        existY.setBackground(Color.WHITE);
        existY.setFont(new Font("Raleway", Font.BOLD, 14));
        add(existY);

        existN = new JRadioButton("No");
        existN.setBounds(400, 565, 60, 30);
        existN.setBackground(Color.WHITE);
        existN.setFont(new Font("Raleway", Font.BOLD, 14));
        add(existN);

        ButtonGroup existGroup = new ButtonGroup();
        existGroup.add(existY);
        existGroup.add(existN);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String religion = (String) religionField.getSelectedItem();
        String category = (String) categoryField.getSelectedItem();
        String income = (String) incomeField.getSelectedItem();
        String education = (String) eduField.getSelectedItem();
        String occupation = (String) occupationField.getSelectedItem();
        String pan = panField.getText();
        String aadhar = aadharField.getText();
        String citizen = null;
        if(seniorY.isSelected()){
            citizen = "Yes";
        } else if(seniorN.isSelected()){
            citizen = "No";
        }
        String existingAcc = null;
        if(existY.isSelected()){
            existingAcc = "Yes";
        } else if(existN.isSelected()){
            existingAcc = "No";
        }

        try{
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo VALUES ('" + formno + "', '" + religion + "', '" + category + "', '" + income + "', '" + education + "', '" + occupation + "', '" + pan + "', '" + aadhar + "', '" + citizen + "', '" + existingAcc + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpThree(formno).setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
