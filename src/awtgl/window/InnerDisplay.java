package awtgl.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class InnerDisplay extends JPanel implements Runnable {
    
    private Thread thread;
    private Window window;

    public int innerX;
    public int innerY;
    public int innerHeight;
    public int innerWidth;
    public int baseInnerHeight;
    public int baseInnerWidth;
    public BufferedImage innerDisplayImage;

    public InnerDisplay(int width, int height, Window window) {

        this.window = window;

        this.innerX = 0;
        this.innerY = 0;
        this.innerWidth = width;
        this.innerHeight = height;
        this.baseInnerWidth = width;
        this.baseInnerHeight = height;
        this.innerDisplayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        this.setPreferredSize(new Dimension(window.getContentPane().getWidth(), window.getContentPane().getHeight()));
        this.setBackground(new Color(0xf4f4ee));
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }



    public void update() {

        //

    }



    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D idg2d = (Graphics2D) this.innerDisplayImage.getGraphics();
        
            idg2d.setColor(new Color(0xefef77));
            idg2d.drawLine(0, 0, 32, 58);
        
        idg2d.dispose();

        Graphics2D g2d = (Graphics2D) g;

            float scale = Math.min(this.window.getContentPane().getWidth() / this.baseInnerWidth, this.window.getContentPane().getHeight() / this.baseInnerHeight);
            this.innerWidth = Math.round(this.baseInnerWidth * scale);
            this.innerHeight = Math.round(this.baseInnerHeight * scale);
            this.innerX = (this.window.getContentPane().getWidth() / 2) - (this.innerWidth / 2);
            this.innerY = (this.window.getContentPane().getHeight() / 2) - (this.innerHeight / 2);

            g2d.drawImage(this.innerDisplayImage, this.innerX, this.innerY, this.innerWidth, this.innerHeight, null);

        g2d.dispose();

    }



    public void startThread() {

        this.thread = new Thread(this);
        this.thread.start();

    }



    @Override
    public void run() {

        double drawInterval = 1000000000 / 60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (this.thread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                this.update();
                this.repaint();

                delta--;

            }

        }

    }
    
}
