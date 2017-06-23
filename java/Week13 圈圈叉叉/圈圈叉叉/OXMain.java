/**
 * Program Name: OXMain.java
 * Purpose: Showing how to AWT to write ���r�C��
 * Modify Date: 2004/05/10
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OXMain extends JFrame implements ActionListener {
    private OX oxBoard;

    private OXMain() {
        // this.setTitle("���r�C��");
        super("���r�C��");
        Menu m;
        MenuBar mb;
        oxBoard = new OX(this);
        this.add(oxBoard);
        this.setMenuBar(mb = new MenuBar());
        mb.add(m = new Menu("�C��")).add(new MenuItem("�s�C��")).addActionListener(this);
        mb.add(new Menu("����")).add(new MenuItem("���󥻹C��")).addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.show();
    }

    public static void main(String argv[]) {
        new OXMain();
    }

    // implements the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("���󥻹C��")) {
            JOptionPane.showMessageDialog(this, "�\���@�g�n����", "�C������", JOptionPane.INFORMATION_MESSAGE);
        } else if (command.equals("�s�C��")) {
            oxBoard.newGame();
        }
    }
}

class OX extends Component implements MouseListener {
    public static final byte EMPTY = 0;
    public static final byte CIRCLE = 1;
    public static final byte CROSS = 2;
    private byte[] board = new byte[9];
    private byte playing = CIRCLE;
    private Dimension mySize = new Dimension(300, 300);
    private Frame parent;
    private byte[][] directions = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
            { 0, 4, 8 }, { 2, 4, 6 } };

    public OX(Frame p) {
        this.addMouseListener(this);
        parent = p;
    }

    // The following 5 functions implement the MouseListener interface
    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        int row = e.getY() / 100;
        int col = e.getX() / 100;
        if (row >= 3 || col >= 3)
            return; // �W�L���
        if (board[row * 3 + col] == EMPTY) { // ����m�i�H�U
            board[row * 3 + col] = playing;
            repaint(); // notify Window Manager
            // Anyone Win?
            for (int i = 0; i < directions.length; i++) {
                int j;
                for (j = 0; j < 3 && board[directions[i][j]] == playing; j++)
                    ;
                if (j == 3) {
                    if (playing == CIRCLE) {
                        JOptionPane.showMessageDialog(this, "���Ĺ�F", "���Ĺ�F", JOptionPane.INFORMATION_MESSAGE);
                    } else if (playing == CROSS) {
                        JOptionPane.showMessageDialog(this, "�e�eĹ�F", "�e�eĹ�F", JOptionPane.INFORMATION_MESSAGE);
                    }
                    this.newGame();
                    return;
                }
            }
            // playing ^= 0x03;
            if(playing == CIRCLE){
                playing = CROSS;
            }else{
                playing = CIRCLE;
            }
        }
    }

    // override paint() defined in Component
    public void paint(Graphics g) {
        g.drawLine(0, 100, 300, 100);
        g.drawLine(0, 200, 300, 200);
        g.drawLine(100, 0, 100, 300);
        g.drawLine(200, 0, 200, 300);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i * 3 + j] == CIRCLE) {
                    g.drawOval(50 + j * 100 - 25, 50 + i * 100 - 25, 50, 50);
                } else if (board[i * 3 + j] == CROSS) {
                    g.drawLine(25 + j * 100, 25 + i * 100, 75 + j * 100, 75 + i * 100);
                    g.drawLine(75 + j * 100, 25 + i * 100, 25 + j * 100, 75 + i * 100);
                }
            }
        }
    }

    public void newGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i * 3 + j] = EMPTY;
            }
        }
        playing = CIRCLE;
        repaint();
    }

    // override getPreferredSize defined in Component,
    // so that the Component has proper size on screen
    public Dimension getPreferredSize() {
        return mySize;
    }
}

/*class AddConstraint {
    public static void addConstraint(Container container, Component component, int grid_x, int grid_y, int grid_width,
            int grid_height, int fill, int anchor, double weight_x, double weight_y, int top, int left, int bottom,
            int right) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = grid_x;
        c.gridy = grid_y;
        c.gridwidth = grid_width;
        c.gridheight = grid_height;
        c.fill = fill;
        c.anchor = anchor;
        c.weightx = weight_x;
        c.weighty = weight_y;
        c.insets = new Insets(top, left, bottom, right);
        ((GridBagLayout) container.getLayout()).setConstraints(component, c);
        container.add(component);
    }
}*/