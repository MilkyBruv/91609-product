package awtgl.window;

public class CursorMovementHandler {

    private InnerDisplay innerDisplay;
    private int[] prevPos;

    public CursorMovementHandler(InnerDisplay innerDisplay) {

        this.innerDisplay = innerDisplay;
        this.prevPos = new int[] {0, 0};

    }



    public int[] getPos() {

        int[] pos = new int[] {0, 0};

        try {

            
            pos[0] = Math.round(Math.round(this.innerDisplay.getWindow().getContentPane().getMousePosition().x / (this.innerDisplay.getWindow().getContentPane().getWidth() / this.innerDisplay.innerWidth) / this.innerDisplay.scale) - ((this.innerDisplay.innerX / this.innerDisplay.scale)));
            pos[1] = Math.round(Math.round(this.innerDisplay.getWindow().getContentPane().getMousePosition().y / (this.innerDisplay.getWindow().getContentPane().getHeight() / this.innerDisplay.innerHeight) / this.innerDisplay.scale) - ((this.innerDisplay.innerY / this.innerDisplay.scale)));

            this.prevPos = new int[] {pos[0], pos[1]};

        } catch (NullPointerException e) {

            pos = this.prevPos;

        }

        return pos;

    }

}
