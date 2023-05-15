package physics;

import java.util.ArrayList;
import java.util.List;

import awtgl.math.Vector2f;
import awtgl.math.Vector2i;

public class PhysicsSpace {
    
    public Vector2f gravity;

    public List<PhysicsObject> objects = new ArrayList<PhysicsObject>() {};

    public PhysicsSpace(Vector2f gravity) {

        this.gravity = gravity;

    }



    public void addObject(PhysicsObject object) {

        this.objects.add(object);

    }



    public void update() {

        for (PhysicsObject object : objects) {
            
            object.update();

        }

    }

}
