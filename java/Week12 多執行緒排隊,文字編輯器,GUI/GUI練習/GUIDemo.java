import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class GUIDemo extends JFrame implements ActionListener{
    JLabel label;
    int count = 0;

    // ActionListener 監聽到事件反應時觸發執行
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
        // 設定標題
        this.setTitle("Lee_Ray's GUIDemo");
        this.setSize(500, 500);

        // BorderLayout 中定位有 North, South, Center , West, East

        // new 一個 label ,並設定 label 初始文字、文字對齊方式
        // label 為一個顯示面板,可以放文字、圖片...等等
        label = new JLabel("0", JLabel.CENTER);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 200));
        this.add(label, BorderLayout.CENTER);

        // 設定 + 號按鈕
        JButton plus = new JButton("+");
        plus.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        // 背景顏色
        plus.setBackground(Color.BLUE);
        // 文字顏色
        plus.setForeground(Color.WHITE);
        // 綁定監聽
        plus.addActionListener(this);
        this.add(plus, BorderLayout.WEST);

        // 設定 - 號按鈕
        JButton minus = new JButton("-");
        minus.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        minus.setBackground(Color.YELLOW);
        minus.setForeground(Color.WHITE);
        minus.addActionListener(this);
        this.add(minus, BorderLayout.EAST);

        // 設定 MenuBar、Menu、MenuItem，再把各自 add 到其屬於的位置
        JMenuBar mb = new JMenuBar();
        // MenuBar 為上方選單的一整列
        this.setJMenuBar(mb);
        // Meun 為選單列中的一個選項
        JMenu file = new JMenu("file(F)");
        mb.add(file);
        // MenuItem 為選項中的子選項
        JMenuItem end = new JMenuItem("exit");
        file.add(end);
        end.addActionListener(this);

        // 讓視窗可視化
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] argc){
        new GUIDemo();
    }
}