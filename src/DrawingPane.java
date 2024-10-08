import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class DrawingPane extends JPanel {

    public ArrayList<Point> points;
    Point previousPoint;
    public boolean runningSim = false;

    public static final Point Corners[] = {new Point(4,476), new Point(476,476),new Point(239,5)};
    public static final Point bottomLeftCorner = new Point(4,476);
    public static final Point bottomRightCorner = new Point(476,476);
    public static final Point topCorner = new Point(239,5);

    Random random;
    public DrawingPane(){
        points = new ArrayList<Point>();
        random = new Random();
    }
    public Thread t1 = new Thread(new Runnable() {
        public void run()
        {
            Point firstPoint = new Point(random.nextInt(50), 75+random.nextInt(50));
            points.add(firstPoint);
            previousPoint = firstPoint;
            while(points.size() <= 2500){
                Point selectedCorner = new Point(0,0);
                selectedCorner = Corners[random.nextInt(3)];
                Point nextPoint = new Point((selectedCorner.x + previousPoint.x)/2, (selectedCorner.y + previousPoint.y)/2);
                previousPoint = nextPoint;
                points.add(nextPoint);
                repaint();
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }});
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        setBackground(Color.black);
        g2.setColor(Color.GREEN);
        g.drawLine(10,480,240,10);
        g.drawLine(10,480,480,480);
        g.drawLine(240,10,480,480);
        for(Point p : points){
            g2.fillRect(p.x, p.y, 2,2);
        }
    }

}
