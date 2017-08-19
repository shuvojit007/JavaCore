package Computer_Graphics;

/**
 * Created by SHOBOJIT on 7/23/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class RotationEx extends JFrame {

    public RotationEx() {
        initUI();
    }

    private void initUI() {
        setTitle("Rotation");
        add(new Surface());
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static Scanner in = new Scanner(System.in);
    private static   int a, b, c, d,e;
    public static void main(String[] args) {
        for (; ; ){
            System.out.println("-----------------");
            System.out.print("Enter First Coordinate: ");
            a = in.nextInt();
            b = in.nextInt();
            System.out.print("Enter Second Coordinate: ");
            c = in.nextInt();
            d = in.nextInt();
            System.out.print("Enter Rotation Angle: ");
            e = in.nextInt();
                RotationEx ex = new RotationEx();
                ex.setVisible(true);
            }
        }

    class Surface extends JPanel {
        private void doDrawing(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setPaint(new Color(150, 150, 150));
            g2d.fillRect(a, b, 80, 50);
            g2d.translate(150, 150);
            g2d.rotate(Math.PI/e);
           // System.out.println(Math.PI/20);
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