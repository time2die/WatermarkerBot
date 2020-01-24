package BotLimbs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WriteImg {

    static void writeImg(BufferedImage image, String pathname, String formatname) {
        try {
            File output_file = new File(pathname);
            ImageIO.write(image, formatname, output_file);
            System.out.println("Writing complete.");
        } catch (
                IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
