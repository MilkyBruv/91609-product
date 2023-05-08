package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import awtgl.window.GameUpdater;
import awtgl.window.InnerDisplay;
import awtgl.window.KeyHandler;
import awtgl.window.Keys;
import awtgl.window.MouseButtonHandler;
import awtgl.window.Window;

public class Updater extends GameUpdater {

    int x;
    int y;
    BufferedImage testImage;
    Random random;

    public Updater(Window window, InnerDisplay innerDisplay) {
        
        super(window, innerDisplay);

        this.x = 0;
        this.y = 0;
        
        this.random = new Random();

        try {

            this.testImage = ImageIO.read(new File("./src/res/anim.png"));

        } catch (IOException e) {
            
            e.printStackTrace();

        }

    }

    @Override
    public void update() {
        
        if (KeyHandler.isKeyPressed(Keys.A)) {

            System.out.println(this.cursorMovementHandler.getPos()[0]);

        }

        if (MouseButtonHandler.isButtonPressed(3)) {

            // System.out.println("bruv");

            this.x = this.cursorMovementHandler.getPos()[0];
            this.y = this.cursorMovementHandler.getPos()[1];

        }

    }

    @Override
    public void draw(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(new Color(0x000000));
            g2d.fillRect(0, 0, 128, 72);

            g2d.setColor(new Color(this.random.nextInt(255) ,this.random.nextInt(255), this.random.nextInt(255)));
            g2d.drawLine(0, 0, this.x, this.y);
            g2d.drawImage(this.testImage, 0, 0, 100, 50, null);

        g2d.dispose();

    }
    
}
