package com.aor.DK.Viewer.Ranking;

import com.aor.DK.model.ranking.Scores;
import com.aor.DK.model.ranking.ScoresDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
public class PlayerNameGUI extends JFrame {

    JFrame frame;
    JTextField textField;

    public PlayerNameGUI(){
        frame = new JFrame("Name Player");
        JButton button = new JButton("OK");
        button.setBounds(200,180,60,50);
        button.setBackground(Color.white);
        JLabel label = new JLabel("If you want to register your points, write your name");
        label.setBounds(20,0,500,200);
        label.setFont(new Font("Jumpman",Font.BOLD,18));
        label.setForeground(Color.white);
        textField = new JTextField(40);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        frame.add(label);
        frame.add(textField);
        frame.pack();
        frame.setSize(500,300);

        textField.setLocation(30,150);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setVisible(true);

        button.addActionListener(this::actionButtonOk);

    }

    public void actionButtonOk(ActionEvent e){
        String name= textField.getText();
        if (name.equals("")) name="Player";
        ScoresDatabase scoresDatabase = new ScoresDatabase();
        Scores scores = new Scores(name, scoresDatabase);
        System.exit(0);

    }
}
