import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.Thread.sleep;

public class GUI extends JFrame implements ActionListener {
    public static JFrame frame;
    DrawingPane canvas;
    JButton simulateButton;
    JLabel numOfPointsLabel;
    JLabel delayLabel;
    JTextField numOfPointsField;
    JTextField delayField;



    public GUI(){
        frame = new JFrame("Chaos Game | Chase Morgan");
        frame.setBounds(525,110,1000,650);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());

        canvas = new DrawingPane();
        canvas.setPreferredSize(new Dimension(500,500));

        simulateButton = new JButton("Simulate Chaos!!");
        simulateButton.setPreferredSize(new Dimension(150,25));

        //numOfPointsField = new JTextField("1500");
        //numOfPointsField.setPreferredSize(new Dimension(150,25));

        frame.getContentPane().add(canvas);
        frame.getContentPane().add(simulateButton);
        //frame.getContentPane().add(numOfPointsField);


        simulateButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == simulateButton){
            System.out.println("Simulating Chaos has begun");
            canvas.runningSim = true;
            canvas.t1.start();

        }
    }
    public static void main(String[] args){
        new GUI();
    }
}

