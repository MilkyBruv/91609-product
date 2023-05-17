package awtgl.math;

public class Vector2f extends Vector {
    
    public float x;
    public float y;

    public Vector2f(float x, float y) {

        this.x = x;
        this.y = y;

    }



    public Vector2f(float i) {

        this.x = i;
        this.y = i;

    }



    public void zero() {

        this.x = 0;
        this.y = 0;

    }



    public void set(float x, float y) {

        this.x = x;
        this.y = y;

    }

    

    public void set(float i) {

        this.x = i;
        this.y = i;

    }



    public void set(Vector vec) {

        this.x = vec.x.floatValue();
        this.y = vec.y.floatValue();

    }



    public void add(float x, float y) {

        this.x += x;
        this.y += y;

    }

    

    public void add(float i) {

        this.x += i;
        this.y += i;

    }



    public void add(Vector vec) {

        this.x += vec.x.floatValue();
        this.y += vec.y.floatValue();

    }



    public void sub(float x, float y) {

        this.x -= x;
        this.y -= y;

    }

    

    public void sub(float i) {

        this.x -= i;
        this.y -= i;

    }



    public void sub(Vector vec) {

        this.x -= vec.x.floatValue();
        this.y -= vec.y.floatValue();

    }



    public void mul(float x, float y) {

        this.x *= x;
        this.y *= y;

    }

    

    public void mul(float i) {

        this.x *= i;
        this.y *= i;

    }



    public void mul(Vector vec) {

        this.x *= vec.x.floatValue();
        this.y *= vec.y.floatValue();

    }



    public void div(float x, float y) {

        this.x /= x;
        this.y /= y;

    }

    

    public void div(float i) {

        this.x /= i;
        this.y /= i;

    }



    public void div(Vector vec) {

        this.x /= vec.x.floatValue();
        this.y /= vec.y.floatValue();

    }
    
}
