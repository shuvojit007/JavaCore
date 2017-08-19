package Computer_Graphics;

/**
 * Created by SHOBOJIT on 7/23/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Scanner;


public class ScalingEx extends JFrame {

    public ScalingEx() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Scaling");
        setSize(330, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static Scanner in = new Scanner(System.in);
    private static   int a, b, c, d,e,f;
    public static void main(String[] args) {

        for (; ; ){
            System.out.println("-----------------");
            System.out.print("Enter First Coordinate: ");
            a = in.nextInt();
            b = in.nextInt();
            System.out.print("Enter Second Coordinate: ");
            c = in.nextInt();
            d = in.nextInt();
            System.out.print("Enter Scaling Size: ");
            e = in.nextInt();
            f = in.nextInt();
            ScalingEx ex = new ScalingEx();
            ex.setVisible(true);
        }


    }


    class Surface extends JPanel {

        private void doDrawing(Graphics g) {

            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setColor(new Color(150, 150, 150));
            g2d.fillRect(a, b, 80, 50);

            AffineTransform tx1 = new AffineTransform();
            tx1.translate(110, 22);
            tx1.scale(0.5, 0.5);

            g2d.setTransform(tx1);
            //g2d.fillRect(0, 0, 80, 50);

            AffineTransform tx2 = new AffineTransform();
            tx2.translate(170, 20);
            tx2.scale(e, f);

            g2d.setTransform(tx2);
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
