package awtgl.window;

import java.awt.Graphics;

public abstract class GameUpdater {

    private Window window;
    private InnerDisplay innerDisplay;
    
    public KeyHandler keyHandler;
    public MouseButtonHandler mouseButtonHandler;
    public CursorMovementHandler cursorMovementHandler;

    public GameUpdater(Window window, InnerDisplay innerDisplay) {

        this.window = window;
        this.innerDisplay = innerDisplay;

        this.keyHandler = new KeyHandler();
        this.mouseButtonHandler = new MouseButtonHandler();
        this.cursorMovementHandler = new CursorMovementHandler(innerDisplay);

    }

    public abstract void update();

    public abstract void draw(Graphics g);

}
