package be.holos.fractals;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * @author Dieter D'haeyere on 24/01/17.
 */
public class DrawingCanvas extends JPanel {

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i <= 100000; i++) {
            final Dimension size = getSize();
            final int w = size.width / 2;
            final int h = size.height / 2;

            final Random r = new Random();
            final double x = -2 + r.nextDouble() * 4;
            final double y = -2 + r.nextDouble() * 4;

            final ComplexNumber complexNumber = new ComplexNumber(x, y);

            final double mandelBrotNumber = MandelBrotCalculator.calculateMandelBrotNumber(complexNumber);
            if (mandelBrotNumber > 2 || Double.isNaN(mandelBrotNumber)) {
                continue;
            }
            final int x_pos = w + (int) Math.floor(x * w * 2 / 3);
            final int y_pos = h + (int) Math.floor(y * h * 2 / 3);

            if (2 - mandelBrotNumber < 1) {
                g2d.setColor(Color.blue);
            } else {
                g2d.setColor(Color.red);
            }
            g2d.drawLine(x_pos, y_pos, x_pos, y_pos);
            try {
                Thread.sleep(200);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(final String[] args) {
        final DrawingCanvas drawingCanvas = new DrawingCanvas();
        final JFrame frame = new JFrame("Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drawingCanvas);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
