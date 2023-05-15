package main;

import awtgl.math.Vector2f;
import awtgl.math.Vector2i;
import awtgl.window.KeyHandler;
import awtgl.window.Keys;
import physics.PhysicsObject;
import physics.PhysicsSpace;

public class Player extends PhysicsObject {

    public Vector2f speed;

    public boolean hasJumped = false;

    public Player(PhysicsSpace space) {
        
        super(space);

        this.pos = new Vector2i(0);

        this.mass = 60; // 60kg
        this.forces = new Vector2f(0f);
        this.acc = new Vector2f(0f);
        this.friction = new Vector2f(-2f, 0f);
        this.vel = new Vector2f(0f);

        this.speed = new Vector2f(0f, 0f);
        
    }
    
    

    public void update() {

        this.vel.y += (this.space.gravity.y * this.mass);
        float preAdd = this.vel.y + (this.space.gravity.y * 0.5f);
        this.vel.y = preAdd;
        this.pos.y += this.vel.y;

        this.acc.x += this.vel.x * this.friction.x;
        this.vel.x += this.acc.x;
        this.pos.x += this.vel.x;

        if (KeyHandler.isKeyPressed(Keys.LEFT)) {

            this.speed.x = -20f;

        } else if (KeyHandler.isKeyPressed(Keys.RIGHT)) {

            this.speed.x = 20f;

        }

        if (KeyHandler.isKeyPressed(Keys.UP) && !this.hasJumped) {

            this.speed.x = -20f;
            this.hasJumped = true;

        } if (!KeyHandler.isKeyPressed(Keys.UP) && this.hasJumped) {

            this.hasJumped = false;

        }

        if (this.pos.y + 16 >= 128) {

            this.pos.y = 128 - 16;

        }

    }

}
