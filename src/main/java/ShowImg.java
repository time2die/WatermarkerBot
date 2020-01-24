import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ShowImg {
    static void showImg(BufferedImage image){
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
