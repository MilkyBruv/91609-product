package awtgl.entity;

import awtgl.math.Vector2i;
import main.Updater;

public abstract class Entity {
    
    public Vector2i pos;
    public Vector2i size;

    public Updater updater;

    public Entity(Updater updater) {

        this.updater = updater;

    }



    public abstract void update();

}
