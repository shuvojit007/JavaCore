package Computer_Graphics;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

class TranslationEx extends JFrame {
    public TranslationEx() {
        initUI();
    }

    private  void initUI() {
        add(new Surface());
        setTitle("Translation");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static Scanner in = new Scanner(System.in);
    private static   int a, b, c, d;
    public static void main(String[] args) {
                for (; ; ){
                    System.out.println("-----------------");
                    System.out.print("Enter First Coordinate: ");
                    a = in.nextInt();
                    b = in.nextInt();
                    System.out.print("Enter Second Coordinate: ");
                    c = in.nextInt();
                    d = in.nextInt();
                    TranslationEx ex = new TranslationEx();
                   ex.setVisible(true);
                }
            }

    class Surface extends JPanel {
        private void doDrawing(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setPaint(new Color(68, 150, 6));
            g2d.fillRect(a, b, 80, 50);
            g2d.translate(50, 150);
            g2d.fillRect(c, d, 80, 50);
            g2d.dispose();
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            doDrawing(g);
        }
    }
}