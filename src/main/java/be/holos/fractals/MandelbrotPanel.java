package be.holos.fractals;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Dieter D'haeyere on 27/01/17.
 */
public class MandelbrotPanel extends JPanel implements MouseListener {

    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1000;
    private Timer timer;
    private BufferedImage canvas;
    private JLabel label;
    private double xArea = 2.0;
    private double yArea = 2.0;
    private ComplexNumber center = new ComplexNumber(0, 0);
    private Graphics2D graphics2D;

    private ActionListener actionListener;

    public static void main(final String[] agrs) {
        final MandelbrotPanel panel = new MandelbrotPanel();
        final JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.add(panel);
        frame.setSize(HEIGHT, WIDTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public MandelbrotPanel() {
        init();
        graphics2D = canvas.createGraphics();

        actionListener = new MandelBrotActionListener(graphics2D);
        addMouseListener(this);
        timer = new Timer(200, actionListener);
        timer.start();
    }

    class MandelBrotActionListener implements ActionListener {

        Graphics2D g;

        MandelBrotActionListener(final Graphics2D g) {
            this.g = g;
        }

        int counter = 0;

        public void actionPerformed(final ActionEvent ae) {
            counter++;
            if (counter > 10000) {
                timer.stop();
                System.out.println("====== end of drawing ======");
                return;
            }

            drawThousandPoints(g);
            label.repaint();
        }
    }

    private void init() {
        canvas = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        graphics2D = canvas.createGraphics();
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillOval(0, 0, WIDTH, HEIGHT);
        label = new JLabel(new ImageIcon(canvas));
        add(label);
    }

    private void drawThousandPoints(final Graphics2D g) {
        int nrOfPoints = 0;
        while (nrOfPoints < 1000) {
            nrOfPoints++;

            final ComplexNumber complexNumber = fetchRandomComplexNumber(center, xArea, yArea);
            final double x;
            final double y;
            x = complexNumber.getX();
            y = complexNumber.getY();

            final double mandelBrotNumber = MandelBrotCalculator.calculateMandelBrotNumber(complexNumber);
            if (mandelBrotNumber > 2 || Double.isNaN(mandelBrotNumber)) {
                continue;
            }

            final Dimension size = getSize();
            final int halfWidth = size.width / 2;
            final int halfHeight = size.height / 2;

            final int x_pos = halfWidth + (int) Math.floor(x * halfWidth / 2);
            final int y_pos = halfHeight + (int) Math.floor(y * halfHeight / 2);

            g.setColor(Color.red);
            g.drawLine(x_pos, y_pos, x_pos, y_pos);
        }
    }

    private ComplexNumber fetchRandomComplexNumber(final ComplexNumber base, final double xArea, final double yArea) {
        final Random r = new Random();
        final double x = base.getX() - xArea + r.nextDouble() * 2 * xArea;
        final double y = base.getY() - yArea + r.nextDouble() * 2 * yArea;

        return new ComplexNumber(x, y);
    }

    public void mouseClicked(final MouseEvent e) {
        timer.stop();
        center = new ComplexNumber(((double) (e.getX() - WIDTH) / (double) (2 * WIDTH)) * xArea, ((double) (e.getY() - HEIGHT) / (double) (2 * HEIGHT)) * yArea);
        xArea = 0.1;
        yArea = 0.1;
        init();

        actionListener = new MandelBrotActionListener(graphics2D);
        timer = new Timer(200, actionListener);
        timer.start();
    }

    public void mousePressed(final MouseEvent e) {

    }

    public void mouseReleased(final MouseEvent e) {

    }

    public void mouseEntered(final MouseEvent e) {

    }

    public void mouseExited(final MouseEvent e) {

    }
}
