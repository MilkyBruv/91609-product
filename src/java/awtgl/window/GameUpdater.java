package awtgl.window;

import java.awt.Graphics;

public abstract class GameUpdater {

    private Window window;
    private InnerDisplay innerDisplay;
    
    public CursorMovementHandler cursorMovementHandler;

    public GameUpdater(Window window, InnerDisplay innerDisplay) {

        this.window = window;
        this.innerDisplay = innerDisplay;
        this.cursorMovementHandler = new CursorMovementHandler(innerDisplay);

    }

    public abstract void update();

    public abstract void draw(Graphics g);

}
