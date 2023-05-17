package awtgl.math;

public class Vector2i extends Vector {
    
    public int x;
    public int y;

    public Vector2i(int x, int y) {

        this.x = x;
        this.y = y;

    }



    public Vector2i(int i) {

        this.x = i;
        this.y = i;

    }



    public void zero() {

        this.x = 0;
        this.y = 0;

    }



    public void set(int x, int y) {

        this.x = x;
        this.y = y;

    }

    

    public void set(int i) {

        this.x = i;
        this.y = i;

    }



    public void set(Vector vec) {

        this.x = vec.x.intValue();
        this.y = vec.y.intValue();

    }



    public void add(int x, int y) {

        this.x += x;
        this.y += y;

    }

    

    public void add(int i) {

        this.x += i;
        this.y += i;

    }



    public void add(Vector vec) {

        this.x += vec.x.intValue();
        this.y += vec.y.intValue();

    }



    public void sub(int x, int y) {

        this.x -= x;
        this.y -= y;

    }

    

    public void sub(int i) {

        this.x -= i;
        this.y -= i;

    }



    public void sub(Vector vec) {

        this.x -= vec.x.intValue();
        this.y -= vec.y.intValue();

    }



    public void mul(int x, int y) {

        this.x *= x;
        this.y *= y;

    }

    

    public void mul(int i) {

        this.x *= i;
        this.y *= i;

    }



    public void mul(Vector vec) {

        this.x *= vec.x.intValue();
        this.y *= vec.y.intValue();

    }



    public void div(int x, int y) {

        this.x /= x;
        this.y /= y;

    }

    

    public void div(int i) {

        this.x /= i;
        this.y /= i;

    }



    public void div(Vector vec) {

        this.x /= vec.x.intValue();
        this.y /= vec.y.intValue();

    }
    
}
