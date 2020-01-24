package BotLimbs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadImg {

    static BufferedImage readImg(String name) {
        int width = 1;    //width of the image
        int height = 1;   //height of the image
        BufferedImage image = null;

        try {
            File input_file = new File(name); //image file path
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            System.out.println(image.getHeight());
            image = ImageIO.read(input_file);
            System.out.println("Reading complete.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return image;
    }
}
