//package toy.tetris;
//
//import javax.swing.*;
//import java.awt.*; // 경로를 생략하고 쓰게 해줄게
//import java.awt.event.*;
//
//public class Tetris extends JFrame {
//
//    public Tetris() {
//        setTitle("Tetris");
//        setSize(300, 600);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        add(new GamePanel());
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new Tetris();
//    }
//}
//
//class GamePanel extends JPanel {
//
//    int x = 100;
//    int y = 100;
//
//    public GamePanel() {
//        setFocusable(true);
//        requestFocusInWindow();
//
//        addKeyListener(new KeyAdapter());
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.setColor(Color.ORANGE);
//        g.fillRect(x, y, 30, 60);
//    }
//}
