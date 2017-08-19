package Computer_Graphics;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

public class BresenhamCircle extends Applet
{
    int radius;
    public BresenhamCircle(int radius){
        this.radius = radius;
    }
    public void paint(Graphics g){
        int xc,yc, x = 0;
        xc = 250; yc = 225;
        int y = radius, p = 3-2*radius;
        do {
            if(p<0)  p = p + 4 * x + 6;
            else {
                p = p + 4 * (x-y) + 10; y = y-1;
            }
            x = x+1;
            g.drawLine(xc+x,yc+y,xc+x,yc+y);
            g.drawLine(x+xc,yc-y,xc+x,yc-y);
            g.drawLine(xc-x,yc+y,xc-x,yc+y);
            g.drawLine(xc-x,yc-y,xc-x,yc-y);
            g.drawLine(xc+y,yc+x,xc+y,yc+x);
            g.drawLine(xc+y,yc-x,xc+y,yc-x);
            g.drawLine(xc-y,yc+x,xc-y,yc+x);
            g.drawLine(xc-y,yc-x,xc-y,yc-x);
        } while(x<y);
    }
    private static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        for (; ; ){
            System.out.println("-----------------");
            System.out.print("Enter Circle Radius: ");
            JFrame jf = new JFrame();
            jf.getContentPane().add(new BresenhamCircle(in.nextInt()), BorderLayout.CENTER);
            jf.setSize(new Dimension(500,500));
            jf.setVisible(true);
            System.out.println("-----------------");
        }

    }
}
