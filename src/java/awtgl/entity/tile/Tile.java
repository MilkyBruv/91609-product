package awtgl.entity.tile;

import awtgl.entity.DisplayEntity;
import main.Updater;

public class Tile extends DisplayEntity {

    public int id;

    public Tile(Updater updater, int id) {
        
        super(updater);
        this.id = id;
        
    }
    
    
    
    @Override
    public void update() {

        //

    }

}
