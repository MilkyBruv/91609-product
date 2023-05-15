package physics.convert;

public abstract class PTM {
    
    public static final int PIXELS_METRES = 20;

    public static final float pixelsToMetres(int pixels) {

        return pixels / PIXELS_METRES;

    }



    public static final int metresToPixels(float metres) {

        return Math.round(metres * PIXELS_METRES);

    }

}
