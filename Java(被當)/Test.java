import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Test extends JFrame{
    JLabel label,score_label;
    JLabel middle;
    int score=0;
    JTextField textField;
    static int ans=0;
    Test(){
        super("�ϧαо�");
        setLayout(new BorderLayout());
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title=new JLabel("�ϧαо�");
        title.setForeground(Color.RED);
        title.setFont(new Font(Font.MONOSPACED,Font.BOLD,100));
        this.add(title,BorderLayout.NORTH);
        middle=new JLabel("",SwingConstants.CENTER);
        middle.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        this.add(middle,BorderLayout.CENTER);
        JPanel d=new JPanel();
        d.setLayout(new GridLayout(1,3));
        JButton b1=new JButton("RESET");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                score=0;
                score_label.setText(score+"��");
                question();
            }
        });
        d.add(b1);
        textField=new JTextField("",15);
        Action action=new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent action){
                try{
                    if(Integer.parseInt(textField.getText())<=0){
                        JOptionPane.showMessageDialog(null,"�o�̭n�񪺬O���n��~");
                        question();
                        return;
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,"�o�̭n�񪺬O���n��~");
                    question();
                    return;
                }
                if(Integer.parseInt(textField.getText())==ans){
                    String message="����F~GOOD!�p�B�ͧA����F";
                    rep(message);
                    score+=10;
                    score_label.setText(score+"��");
                }
                else if(Integer.parseInt(textField.getText())!=ans){
                    String message="�����F!�S���Y�ڭ̦A�դ@��";
                    rep(message);
                }
                textField.setText("");
                question();
            }
        };
        textField.addActionListener(action);
        d.add(textField);
        score_label=new JLabel(score+"��");
        d.add(score_label);
        add(d,BorderLayout.SOUTH);
        setVisible(true);
        question();
    }
    void rep(String message){
        JOptionPane.showMessageDialog(this,message);
    }
    void question(){
        Random rnd=new Random();
        int x=(int)rnd.nextInt(20)+1;
        int y=(int)rnd.nextInt(20)+1;
        int type=(int)rnd.nextInt(3);
        int pi=3;
        System.out.println(type+","+x+","+y);
        if(type==0){
            middle.setText("����� ��"+String.valueOf(x)+"cm "+"�e"+String.valueOf(y)+"cm");
            ans=x*y;
        }
        else if(type==1){
            middle.setText("�T���� ��"+String.valueOf(x)+"cm "+"��"+String.valueOf(y)+"cm");
            ans=(x*y)/2;
        }
        else if(type==2){
            middle.setText("��� �b�|"+String.valueOf(x)+"cm "+"pi=3");
            ans=x*x*pi;
        }
    }
    public static void main(String[] args){
        Test data=new Test(); 
    }
}