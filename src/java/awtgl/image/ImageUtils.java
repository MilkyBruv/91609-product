package awtgl.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public abstract class ImageUtils {
    
    static Map<String, BufferedImage> images = new HashMap<String, BufferedImage>();

    public static BufferedImage loadBufferedImage(String path) throws IOException {

        BufferedImage image = ImageIO.read(new File(path));

        images.put(path, image);

        return image;

    }

    public static void reloadImages() {

        

    }

}
