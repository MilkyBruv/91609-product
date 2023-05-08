package awtgl.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageUtils {
 
    public static BufferedImage loadBufferedImage(String path) throws IOException {

        return ImageIO.read(new File(path));

    }

}
