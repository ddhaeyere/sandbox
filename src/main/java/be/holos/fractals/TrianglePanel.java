package be.holos.fractals;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TrianglePanel extends JPanel {

    int level = 2;
    int width;
    int height;
    Timer timer;
    BufferedImage canvas;
    JLabel label;

    public static void main(final String[] agrs) {
        final TrianglePanel panel = new TrianglePanel();
        final JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.add(panel);
        frame.pack();

        frame.setVisible(true);
    }

    public TrianglePanel() {
        final int width = 400;
        final int height = 400;
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        label = new JLabel(new ImageIcon(canvas));
        add(label);
        final Graphics2D g = canvas.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(255, 127, 0));

        final ArrayList<Line> queue = new ArrayList<Line>();

        queue.add(new Line(new Point(width / 2, 0), new Point(0, height)));
        queue.add(new Line(new Point(0, height), new Point(width, height)));
        queue.add(new Line(new Point(width, height), new Point(width / 2, 0)));

        drawLine(queue.get(0), g);
        drawLine(queue.get(1), g);
        drawLine(queue.get(2), g);

        final ActionListener al = new ActionListener() {
            int counter = 0;

            public void actionPerformed(final ActionEvent ae) {
                if (level > 6) {
                    timer.stop();
                    return;
                }

                final Line[] toDraw = queue.get(0).getTriangleToDraw(level, width, height);

                final Point[] toDrawPoints = toDraw[0].getPoints();

                if (Math.sqrt(((Math.pow(toDrawPoints[1].x - toDrawPoints[0].x, 2)) + (Math.pow(toDrawPoints[1].y - toDrawPoints[0].y, 2)))) <= 4) {
                    System.out.println("breakyo");
                    return;
                }

                drawLine(toDraw[0], g);
                drawLine(toDraw[1], g);
                drawLine(toDraw[2], g);

                queue.remove(0);

                queue.add(toDraw[0]);
                queue.add(toDraw[1]);
                queue.add(toDraw[2]);

                counter++;

                System.out.println(counter + " and " + level);

                if (counter - Math.pow(3, level - 1) == 0) {
                    counter = 0;
                    level++;
                }
                label.repaint();
            }
        };
        timer = new Timer(20, al);
        timer.start();
    }

    private void drawLine(final Line line, final Graphics g) {
        g.drawLine(line.getPoints()[0].x, line.getPoints()[0].y, line.getPoints()[1].x, line.getPoints()[1].y);
    }
}

class Line {

    private final Point endpoint1;
    private final Point endpoint2;
    private final Point midpoint;
    private final double slope;

    public Line(final Point endpoint1, final Point endpoint2) {
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;

        midpoint = new Point((endpoint1.x + endpoint2.x) / 2, (endpoint1.y + endpoint2.y) / 2);
        slope = (double) (endpoint2.y - endpoint1.y) / (double) (endpoint2.x - endpoint1.x);
    }

    public Point[] getPoints() {
        return new Point[]{endpoint1, endpoint2};
    }

    public Line[] getTriangleToDraw(final int level, final int width, final int height) {

        final Line[] lines = new Line[3];

        if (slope > 0) { //negative slope
            final Point left = new Point(midpoint.x - (width / (int) (Math.pow(2, level - 1))), midpoint.y);
            final Point middle = new Point(midpoint.x - (width / (int) (Math.pow(2, level))), midpoint.y + (height / (int) (Math.pow(2, level - 1))));

            lines[0] = new Line(midpoint, left);
            lines[1] = new Line(midpoint, middle);
            lines[2] = new Line(middle, left);
        } else if (slope < 0) { // positive slope
            final Point right = new Point(midpoint.x + (width / (int) (Math.pow(2, level - 1))), midpoint.y);
            final Point middle = new Point(midpoint.x + (width / (int) (Math.pow(2, level))), midpoint.y + (height / (int) (Math.pow(2, level - 1))));

            lines[0] = new Line(midpoint, right);
            lines[1] = new Line(midpoint, middle);
            lines[2] = new Line(middle, right);
        } else { //zero slope
            final Point left = new Point(midpoint.x - (width / (int) (Math.pow(2, level))), midpoint.y - (height / (int) (Math.pow(2, level - 1))));
            final Point right = new Point(midpoint.x + (width / (int) (Math.pow(2, level))), midpoint.y - (height / (int) (Math.pow(2, level - 1))));

            lines[0] = new Line(midpoint, left);
            lines[1] = new Line(midpoint, right);
            lines[2] = new Line(left, right);
        }

        return lines;
    }
}
