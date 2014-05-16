package example.word;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chaiwat
 */
public final class WordFrame extends JFrame {

    private JTextArea ta;
    
    public WordFrame(String title) throws HeadlessException {
        init();
        this.pack();
        this.setTitle(title);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void init() {
        this.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        
        JButton b1 = new JButton("Lower");
        JButton b2 = new JButton("Upper");
        p2.add(b1);
        p2.add(b2);
        
        ta = new JTextArea(20, 30);
        ta.setText("Try it!!");
        p1.add(ta);
        this.add(p1, BorderLayout.CENTER);
        this.add(p2, BorderLayout.SOUTH);
        
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String tx = ta.getText();
                ta.setText(tx.toLowerCase());
            }
        });
        
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String tx = ta.getText();
                ta.setText(tx.toUpperCase());
            }
        });
    }
    
    public static void main(String[] args) {
        new WordFrame("Word from Simple JFrame");
    }
    
}
