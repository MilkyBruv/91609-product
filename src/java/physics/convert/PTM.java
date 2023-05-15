package physics.convert;

public abstract class PTM {
    
    public static final int PIXELS_METRES = 16;

    public static final float pixels_to_metres(int pixels) {

        return pixels / PIXELS_METRES;

    }



    public static final int metres_to_pixels(float metres) {

        return Math.round(metres * PIXELS_METRES);

    }

}
