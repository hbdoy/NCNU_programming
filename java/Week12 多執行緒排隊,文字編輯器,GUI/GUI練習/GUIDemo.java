import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class GUIDemo extends JFrame implements ActionListener{
    JLabel label;
    int count = 0;

    // ActionListener ��ť��ƥ������Ĳ�o����
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("+")){
            count++;
        }else if(command.equals("-")){
            count--;
        }else if(command.equals("exit")){
            System.exit(0);
        }
        label.setText(Integer.toString(count));
    }
    public GUIDemo(){
        // �]�w���D
        this.setTitle("Lee_Ray's GUIDemo");
        this.setSize(500, 500);

        // BorderLayout ���w�즳 North, South, Center , West, East

        // new �@�� label ,�ó]�w label ��l��r�B��r����覡
        // label ���@����ܭ��O,�i�H���r�B�Ϥ�...����
        label = new JLabel("0", JLabel.CENTER);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 200));
        this.add(label, BorderLayout.CENTER);

        // �]�w + �����s
        JButton plus = new JButton("+");
        plus.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        // �I���C��
        plus.setBackground(Color.BLUE);
        // ��r�C��
        plus.setForeground(Color.WHITE);
        // �j�w��ť
        plus.addActionListener(this);
        this.add(plus, BorderLayout.WEST);

        // �]�w - �����s
        JButton minus = new JButton("-");
        minus.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        minus.setBackground(Color.YELLOW);
        minus.setForeground(Color.WHITE);
        minus.addActionListener(this);
        this.add(minus, BorderLayout.EAST);

        // �]�w MenuBar�BMenu�BMenuItem�A�A��U�� add ����ݩ󪺦�m
        JMenuBar mb = new JMenuBar();
        // MenuBar ���W���檺�@��C
        this.setJMenuBar(mb);
        // Meun �����C�����@�ӿﶵ
        JMenu file = new JMenu("file(F)");
        mb.add(file);
        // MenuItem ���ﶵ�����l�ﶵ
        JMenuItem end = new JMenuItem("exit");
        file.add(end);
        end.addActionListener(this);

        // �������i����
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] argc){
        new GUIDemo();
    }
}