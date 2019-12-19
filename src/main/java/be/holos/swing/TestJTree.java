package be.holos.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TestJTree {

    private static ImageIcon iconWhite = new ImageIcon("/Users/memius/PearlChain_workspace/Soudal_V1/PearlChain/prl-ui/src/main/resources/images/views/planning.png");

    private static ImageIcon iconBlack = new ImageIcon("/Users/memius/PearlChain_workspace/Soudal_V1/PearlChain/prl-ui/src/main/resources/images/views/process.png");

    public static void main(String[] args) {
        TestJTree me = new TestJTree();
        me.process();
    }

    private void process() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                initGui();

            }

        });

    }

    protected void initGui() {
        JFrame frame = new JFrame("Test JTree");
        frame.setContentPane(new JPanel(new BorderLayout()));

        final JTree tree = new JTree();
        frame.getContentPane().add(tree);

        final CustomTreeCellRenderer renderer = new CustomTreeCellRenderer();
        renderer.setRendererIcon(iconWhite);
        tree.setCellRenderer(renderer);

        JPanel panelButtons = new JPanel();

        JButton buttonWhite = new JButton("");
        buttonWhite.setIcon(iconWhite);
        JButton buttonBlack = new JButton("");
        buttonBlack.setIcon(iconBlack);

        buttonBlack.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                renderer.setRendererIcon(iconBlack);
                tree.repaint();
            }

        });

        panelButtons.add(buttonBlack);
        panelButtons.add(buttonWhite);
        frame.getContentPane().add(panelButtons,BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);


    }

    @SuppressWarnings("serial")
    private static class CustomTreeCellRenderer extends DefaultTreeCellRenderer{


        ImageIcon rendererIcon;


        public void setRendererIcon(ImageIcon myIcon){
            this.rendererIcon = myIcon;
        };


        public Component getTreeCellRendererComponent(JTree tree,
                                                      Object value, boolean selected, boolean expanded,
                                                      boolean leaf, int row, boolean hasFocus){

            Component ret = super.getTreeCellRendererComponent(tree, value,
                    selected, expanded, leaf, row, hasFocus);

            JLabel label = (JLabel) ret ;

            label.setIcon( rendererIcon ) ;

            return ret;
        }
    }
}
