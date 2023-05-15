package physics;

import awtgl.math.Vector2i;
import awtgl.math.Vector2f;

public class PhysicsObject {
    
    public Vector2i pos;
    public Vector2f vel;
    public Vector2f acc;
    public Vector2f forces;
    public Vector2f friction;

    public float mass;

    public PhysicsSpace space;

    public PhysicsObject(PhysicsSpace space) {

        this.space = space;

    }



    public void update() {

        //
        
    }

}
