package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import awtgl.math.Vector2f;
import awtgl.math.Vector2i;
import awtgl.window.GameUpdater;
import awtgl.window.InnerDisplay;
import awtgl.window.KeyHandler;
import awtgl.window.Keys;
import awtgl.window.Renderer;
import awtgl.window.Window;

public class Updater extends GameUpdater {

    int x;
    int y;
    BufferedImage testImage;
    Random random;
    int rot = 0;

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

    }

    @Override
    public void update() {

        this.x = this.cursorMovementHandler.getPos()[0];
        this.y = this.cursorMovementHandler.getPos()[1];

        if (KeyHandler.isKeyPressed(Keys.RIGHT)) {

            this.rot += 1;

        } if (KeyHandler.isKeyPressed(Keys.LEFT)) {

            this.rot -= 1;

        }

    }

    @Override
    public void draw(Graphics g) {

        Renderer.clear(g);
        
        Renderer.drawImage(testImage, new Vector2i(20, 20), this.rot, g);

    }
    
}
