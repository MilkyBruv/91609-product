package physics;

import awtgl.math.Vector2i;
import awtgl.math.Vector2f;

public class PhysicsObject {
    
    public Vector2i pos;
    public Vector2f vel;
    public Vector2f acc;

    public PhysicsObject() {

        this.pos = new Vector2i(0);
        this.vel = new Vector2f(0f);
        this.acc = new Vector2f(0f);

    }

}
