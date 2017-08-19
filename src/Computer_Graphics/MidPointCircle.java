package Computer_Graphics;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

public class MidPointCircle extends Applet
{   int r;
    public MidPointCircle(int r) {
        this.r = r; }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int d=(5/4)*r;
        int x=0;
        int y=r;
        do
        {
            g.setColor(Color.black);
            g.drawLine(y+200,x+200,y+200,x+200 );
            g.drawLine(x+200,y+200,x+200,y+200);
            g.drawLine(x+200,-y+200,x+200,-y+200);
            g.drawLine(y+200,-x+200,y+200,-x+200 );
            g.drawLine(-y+200,-x+200,-y+200,-x+200 );
            g.drawLine(-x+200,-y+200,-x+200,-y+200 );
            g.drawLine(-x+200,y+200,-x+200,y+200 );
            g.drawLine(-y+200,x+200,-y+200,x+200 );
            if(d<0){
                d=d+2*x+3;
            }
            else{
                d=d+2*(x-y)+5;
                y=y-1;
            }
            x += 1;
        } while (x<y);
    }
    private static  Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        for (; ;){
            System.out.println("-----------------");
            System.out.print("Enter Circle Radius: ");
            JFrame jf = new JFrame();
            jf.getContentPane().add(new MidPointCircle(in.nextInt()), BorderLayout.CENTER);
            jf.setSize(new Dimension(500,500));
            jf.setVisible(true);
            System.out.println("-----------------");
        }
    }
}
