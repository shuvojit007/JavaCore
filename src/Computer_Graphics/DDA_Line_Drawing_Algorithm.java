package Computer_Graphics;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

public class DDA_Line_Drawing_Algorithm extends Applet
{   double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    void init(double x, double y, double xx, double yy){
        x1 = x; y1 = y; x2 = xx; y2 = yy; }
    public void paint(Graphics g)
    {   double dx,dy,steps,x,y,k;
        double xc,yc;
        dx=x2-x1; dy=y2-y1;
        if(Math.abs(dx)>Math.abs(dy)) steps=Math.abs(dx);
        else steps=Math.abs(dy);
        xc=(dx/steps); yc=(dy/steps);
        x=x1; y=y1;
        g.fillOval(200,500,5,5);
        for(k=1;k<=steps;k++)
        {   x=x+xc; y=y+yc;
            g.fillOval((int)x,(int)y,5,5);
        } }
    private static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
       for(; ; ){
           System.out.println("-----------------");
           DDA_Line_Drawing_Algorithm  ob = new DDA_Line_Drawing_Algorithm ();
           double a, b, c, d;
           System.out.print("Enter values for First Coordinate: ");
           a = in.nextDouble(); b = in.nextDouble();
           System.out.print("Enter values for Second Coordinate: ");
           c = in.nextDouble(); d = in.nextDouble();
           ob.init(a, b, c, d);
           JFrame jf = new JFrame();
           jf.getContentPane().add(ob, BorderLayout.CENTER);
           jf.setSize(new Dimension(500,500));
           jf.setVisible(true);
           System.out.println("-----------------");
           System.out.println();
       } } }
