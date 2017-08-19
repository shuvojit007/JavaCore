package Computer_Graphics;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

public class BresenhamLine extends Applet
{   int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    void init(int x, int y, int xx, int yy){
        x1 = x; y1 = y; x2 = xx; y2 = yy; }
    @Override
    public void paint(Graphics g){
        int x,y,k;
        double dx,dy,p;
        dx=Math.abs(x2-x1);
        dy=Math.abs(y2-y1);
        x=x1; y=y1;
        p=2*dy-dx;
        g.drawOval(200,300,5,5);
        for(k=0;k<dx;k++){
            if(p<0) {
                g.drawOval(x++,y,5,5);
                p=p+(2*dy); }
            else  {
                g.drawOval(x++,y++,5,5);
                p=p+(2*(dy-dx));
            }}


    }


    private static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        for (; ; ) {
            System.out.println("-----------------");
            int a, b, c, d;
            System.out.print("Enter First Coordinate: ");
            a = in.nextInt();
            b = in.nextInt();
            System.out.print("Enter Second Coordinate: ");
            c = in.nextInt();
            d = in.nextInt();
            BresenhamLine bresenhamLine = new BresenhamLine();
            bresenhamLine.init(a, b, c, d);
            JFrame jf = new JFrame();
            jf.getContentPane().add(bresenhamLine, BorderLayout.CENTER);
            jf.setSize(new Dimension(5000, 5000));
            jf.setVisible(true);
            System.out.println("-----------------");
        }}}
