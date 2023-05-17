package awtgl.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import awtgl.math.Vector2i;

public abstract class Renderer {

    public static void clear(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(g2d.getBackground());
        g2d.fillRect(0, 0, 128, 72);

    }



    public static void drawImage(BufferedImage BufferedImage, Vector2i position, int rotation, Graphics g) {
    
        AffineTransform backup = new AffineTransform();
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(rotation), position.x + (BufferedImage.getWidth() / 2), position.y + (BufferedImage.getHeight() / 2));

        g2d.setTransform(a);
        g2d.drawImage(BufferedImage, position.x, position.y, BufferedImage.getWidth(), BufferedImage.getHeight(), null);
        g2d.setTransform(backup);
        g2d.dispose();

    }



    public static void drawImage(BufferedImage BufferedImage, Vector2i position, Vector2i size, int rotation, Graphics g) {
    
        AffineTransform backup = new AffineTransform();
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(rotation), position.x + (size.x / 2), position.y + (size.y / 2));

        g2d.setTransform(a);
        g2d.drawImage(BufferedImage, position.x, position.y, size.x, size.y, null);
        g2d.setTransform(backup);
        g2d.dispose();

    }



    public static void drawLine(Vector2i position1, Vector2i position2, int colour, Graphics g) {
    
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(colour));
        g2d.drawLine(position1.x, position1.y, position2.x, position2.y);
        g2d.dispose();

    }



    public static void drawRect(Vector2i position, Vector2i size, int rotation, int colour, Graphics g) {
    
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(rotation), position.x + (size.x / 2), position.y + (size.y / 2));

        g2d.setTransform(a);
        g2d.setColor(new Color(colour));
        g2d.drawRect(position.x, position.y, size.x, size.y);
        g2d.dispose();

    }



    public static void drawCircle(Vector2i position, int radius, int rotation, int colour, Graphics g) {
    
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(rotation), position.x + (radius), position.y + (radius));

        g2d.setTransform(a);
        g2d.setColor(new Color(colour));
        g2d.drawRoundRect(position.x, position.y, radius * 2, radius * 2, radius * 2, radius * 2);
        g2d.dispose();

    }



    public static void drawPoint(Vector2i position, int colour, Graphics g) {
    
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(new Color(colour));
        g2d.drawLine(position.x, position.y, position.x, position.y);
        g2d.dispose();

    }

}