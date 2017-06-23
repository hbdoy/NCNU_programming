import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.Random;

public class Exam extends JFrame implements ActionListener {
    JLabel level, level_num, balls, score, point;
    JButton one, two, three, four, five, six, seven, eight, nine, start;
    int myScore = 0;
    int myBalls = 8;
    int levelNum;
    int strike;

    public void showNum(){
        one.setText("1");
        two.setText("2");
        three.setText("3");
        four.setText("4");
        five.setText("5");
        six.setText("6");
        seven.setText("7");
        eight.setText("8");
        nine.setText("9");
    }

    public void createStrike(int levelNum){
        if(levelNum == 1){
            strike = 2;
        }
        if(levelNum == 2){
            strike = 3;
        }
        if(levelNum == 3){
            strike = 4;
        }
        if(levelNum == 4){
            strike = 5;
        }
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("start")) {
                levelNum = (int) (Math.random() * 4 + 1);
                createStrike(levelNum);
                level_num.setText(Integer.toString(levelNum));
                showNum();
                if(myBalls == 0){
                    myBalls = 8;
                    myScore = 0;
                }
        }
        if(myBalls > 0){
             if (command.equals("1")) {
                int tmp = (int) (Math.random() * strike + 1);
                if (tmp == 1) {
                    one.setText("X");
                    myScore++;
                    JOptionPane.showMessageDialog(null, "Strike");
                } else {
                    JOptionPane.showMessageDialog(null, "Miss");
                }
                myBalls--;
            } else if (command.equals("2")) {
                int tmp = (int) (Math.random() * strike + 1);
                if (tmp == 1) {
                    two.setText("X");
                    myScore++;
                    JOptionPane.showMessageDialog(null, "Strike");
                } else {
                    JOptionPane.showMessageDialog(null, "Miss");
                }
                myBalls--;
            } else if (command.equals("3")) {
                int tmp = (int) (Math.random() * strike + 1);
                if (tmp == 1) {
                    three.setText("X");
                    myScore++;
                    JOptionPane.showMessageDialog(null, "Strike");
                } else {
                    JOptionPane.showMessageDialog(null, "Miss");
                }
                myBalls--;
            } else if (command.equals("4")) {
                int tmp = (int) (Math.random() * strike + 1);
                if (tmp == 1) {
                    four.setText("X");
                    myScore++;
                    JOptionPane.showMessageDialog(null, "Strike");
                } else {
                    JOptionPane.showMessageDialog(null, "Miss");
                }
                myBalls--;
            } else if (command.equals("5")) {
                int tmp = (int) (Math.random() * strike + 1);
                if (tmp == 1) {
                    five.setText("X");
                    myScore++;
                    JOptionPane.showMessageDialog(null, "Strike");
                } else {
                    JOptionPane.showMessageDialog(null, "Miss");
                }
                myBalls--;
            } else if (command.equals("6")) {
                int tmp = (int) (Math.random() * strike + 1);
                if (tmp == 1) {
                    six.setText("X");
                    myScore++;
                    JOptionPane.showMessageDialog(null, "Strike");
                } else {
                    JOptionPane.showMessageDialog(null, "Miss");
                }
                myBalls--;
            } else if (command.equals("7")) {
                int tmp = (int) (Math.random() * strike + 1);
                if (tmp == 1) {
                    seven.setText("X");
                    myScore++;
                    JOptionPane.showMessageDialog(null, "Strike");
                } else {
                    JOptionPane.showMessageDialog(null, "Miss");
                }
                myBalls--;
            } else if (command.equals("8")) {
                int tmp = (int) (Math.random() * strike + 1);
                if (tmp == 1) {
                    eight.setText("X");
                    myScore++;
                    JOptionPane.showMessageDialog(null, "Strike");
                } else {
                    JOptionPane.showMessageDialog(null, "Miss");
                }
                myBalls--;
            } else if (command.equals("9")) {
                int tmp = (int) (Math.random() * strike + 1);
                if (tmp == 1) {
                    nine.setText("X");
                    myScore++;
                    JOptionPane.showMessageDialog(null, "Strike");
                } else {
                    JOptionPane.showMessageDialog(null, "Miss");
                }
                myBalls--;
            } else if (command.equals(" ")) {
                JOptionPane.showMessageDialog(null, "Please Click Start!");
            } else if (command.equals("X")) {
                JOptionPane.showMessageDialog(null, "You have already struck it!");
                myBalls--;
            }
        }else{
            JOptionPane.showMessageDialog(null, "You don't have any ball! Please Click Start");
            JOptionPane.showMessageDialog(null, "You get " + myScore + " points");
        }
        balls.setText(Integer.toString(myBalls) + " / 8");
        point.setText(Integer.toString(myScore));
    }

    public Exam() {
        this.setTitle("Lee_Ray's Ball Game");
        this.setSize(800, 800);

        this.setLayout(new GridLayout(5, 3));

        level = new JLabel("Level", JLabel.CENTER);
        level.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        level_num = new JLabel("-", JLabel.CENTER);
        level_num.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        balls = new JLabel("8 / 8", JLabel.CENTER);
        balls.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        score = new JLabel("Score", JLabel.CENTER);
        score.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        point = new JLabel("0", JLabel.CENTER);
        point.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));

        one = new JButton(" ");
        one.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        one.addActionListener(this);
        two = new JButton(" ");
        two.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        two.addActionListener(this);
        three = new JButton(" ");
        three.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        three.addActionListener(this);
        four = new JButton(" ");
        four.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        four.addActionListener(this);
        five = new JButton(" ");
        five.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        five.addActionListener(this);
        six = new JButton(" ");
        six.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        six.addActionListener(this);
        seven = new JButton(" ");
        seven.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        seven.addActionListener(this);
        eight = new JButton(" ");
        eight.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        eight.addActionListener(this);
        nine = new JButton(" ");
        nine.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        nine.addActionListener(this);
        // start button
        start = new JButton("start");
        start.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        start.addActionListener(this);


        // add to JFrame 注意順序
        this.add(level);
        this.add(level_num);
        this.add(start);
        this.add(one);
        this.add(two);
        this.add(three);
        this.add(four);
        this.add(five);
        this.add(six);
        this.add(seven);
        this.add(eight);
        this.add(nine);
        this.add(balls);
        this.add(score);
        this.add(point);

        // 讓視窗可視化
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] argc) {
        new Exam();
    }
}