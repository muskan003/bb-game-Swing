/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 *
 * @author HP Laptop
 */
public class Task2 extends JFrame implements ActionListener {

    ImageIcon img;
    TextField t;
    JLabel l1, l2, l3, l4, l5, l6, lbl, l7, l8, l9, l10;
    String s1;
    JPanel p1, p2, p3,p4;
    int com, hum, left = 21;
    JButton b;

    public void initComponenets() {
        p1 = new JPanel();
        p2 = new JPanel();

        p3 = new JPanel();
        GridLayout gl = new GridLayout(8,0);

        p1.setLayout(gl);

        l7 = new JLabel("There are 21 beer bottles...");

        p1.add(l7);
        l8 = new JLabel("Computer and yourself, there are 2 players");
        p1.add(l8);
        l9 = new JLabel("At a time, each one can pick up any number of bottles between 1 and 4 (inclusive)");
        p1.add(l9);
        l10 = new JLabel("The one last picking the bottle will be loser and will pay bill");
        p1.add(l10);
        //creating instance of JFrame
add("North",p1);
FlowLayout fl = new FlowLayout();
p2.setLayout(fl);
        JButton b = new JButton("click");//creating instance of JButton

        l1 = new JLabel("How many do you choose");
        t = new TextField(10);

        b.setBounds(200, 200, 100, 40);
        b.addActionListener(this);
        p2.add(l1);
        p2.add(t);
        p3.setLayout(gl);
        l2 = new JLabel();

        p2.add(b);//adding button in JFrame
        p3.add(l2);
        l3 = new JLabel();

        p3.add(l3);
        l4 = new JLabel();

        p3.add(l4);

        l5 = new JLabel();
        p3.add(l5);
        l6 = new JLabel();
        p3.add(l6);
        p4=new JPanel();
        p4.setLayout(fl);
             for (int i = 0; i < left; i++) {
                img = new ImageIcon(getClass().getResource("img.png"));
                lbl = new JLabel(img);
                p4.add(lbl);
                }
        add("West",p2);
        add("South",p3);
        add("Center",p4);
        setSize(900, 900);//400 width and 500 height
        setVisible(true);//making the frame visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s1 = t.getText();
        p4.removeAll();
        revalidate();
        repaint();
        if (s1.equals("1") || s1.equals("2") || s1.equals("3") || s1.equals("4")) {
            l2.setText("");
            hum = Integer.parseInt(s1);
            com = 5 - hum;
            l3.setText("Computer chose " + com);
            left = left - com - hum;
            l4.setText("Remaining bottles " + left);
                      for (int i = 0; i < left; i++) {
                img = new ImageIcon(getClass().getResource("img.png"));
                lbl = new JLabel(img);
                p4.add(lbl);
                }
            if (left == 1) {
                l5.setText("You are a loser");
                left = 21;
                hum = 0;
                com = 0;
            }
        } else {
            l3.setText("");
            l4.setText("");
            l5.setText("");
            l2.setText("enter a correct value");
        }

    }

    Task2() {
        initComponenets();
    }

    public static void main(String[] args) {
        new Task2();
    }

}
