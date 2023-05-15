package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import awtgl.math.Vector2f;
import awtgl.window.GameUpdater;
import awtgl.window.InnerDisplay;
import awtgl.window.Window;
import physics.PhysicsSpace;

public class Updater extends GameUpdater {

    int x;
    int y;
    BufferedImage testImage;
    Random random;
    PhysicsSpace space;
    Player player;

    public Updater(Window window, InnerDisplay innerDisplay) {
        
        super(window, innerDisplay);

        this.x = 0;
        this.y = 0;
        
        this.random = new Random();

        try {

            this.testImage = ImageIO.read(new File("src/res/anim.png"));

        } catch (IOException e) {
            
            e.printStackTrace();

        }

        this.space = new PhysicsSpace(new Vector2f(0f, 0.00098f));
        this.player = new Player(this.space);
        this.space.addObject(player);

    }

    @Override
    public void update() {

        this.x = this.cursorMovementHandler.getPos()[0];
        this.y = this.cursorMovementHandler.getPos()[1];

        this.space.update();

    }

    @Override
    public void draw(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(new Color(0x000000));
            g2d.fillRect(0, 0, 128, 72);
            
            g2d.setColor(new Color(0xffe44));
            g2d.drawRect(this.player.pos.x, this.player.pos.y, 16, 16);
            g2d.drawRect(50, 10, 16, 16);

            // g2d.drawImage(this.testImage, this.player.pos.x, this.player.pos.y, 16, 16, null);

            System.out.println("X: " + this.player.pos.x + "\nY: " + this.player.pos.y + "\n\n");

        g2d.dispose();

    }
    
}
