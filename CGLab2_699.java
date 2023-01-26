//64050699สรวิศ วงศ์ษา
import java.awt.*;
import javax.swing.*;

class CGLab2_699 extends JPanel
{
    public static void main(String[] args)
    {
        CGLab2_699 m = new CGLab2_699();

        JFrame f=new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void paintComponent(Graphics g)
    {
        /* 
        naiveLine(g, 100, 100, 400, 200);
        naiveLine(g, 400, 300, 100, 200);
        naiveLine(g, 100, 100, 200, 400);*/

        DDALine(g, 100, 100, 400, 200);
        DDALine(g, 400, 300, 100, 200);
        DDALine(g, 100, 100, 200, 400);
    }
    public static void naiveLine(Graphics g, int x1, int y1, int x2, int y2)
    {
        float dx, dy, b, m;
        int x, y;
        dx = x2 - x1;
        dy = y2 - y1;
        b = y1 - (dy / dx)* x1;
        m = dy/dx;

        if (x1 > x2)
        {
            for (x = x1; x > x2; x--){
                y = (int) ((m * x) + b);
                g.fillRect(x,y,5,5);
            }
        }
        for (x = x1; x < x2; x++){
            y = (int) ((m * x) + b);
            g.fillRect(x,y,5,5);
        }
    }

    public static void DDALine(Graphics g, int x1, int y1, int x2, int y2)
    {
        if (x1 > x2 || y1 > y2){
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        float dx, dy, m, temp;
        int x, y;
        dx = x2 - x1;
        dy = y2 - y1;
        m = dy/dx;

        if (m <= 1 && m >= 0) {
            temp = y1;
            for (x = x1; x < x2; x++)
            {
                temp += m;
                y = (int)(temp);
                g.fillRect(x,y,5,5);
            }
        }
        else if (m <= -1) {
            temp = y2;
            for (x = x2; x > x1; x--)
            {
                temp += m;
                y = (int)(temp);
                g.fillRect(x,y,5,5);
            }
        }
        else if (m > 1) {
            temp = x1;
            for (y = y1; y < y2; y++)
            {
                temp += 1/m;
                x = (int)(temp);
                g.fillRect(x,y,5,5);
            }
        } else {
            temp = x2;
            for (y = y2; y > y1; y--)
            {
                temp += 1/m;
                x = (int)(temp);
                g.fillRect(x,y,5,5);
            }
        }

        
    }
}