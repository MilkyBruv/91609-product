package main;

import java.awt.Color;

import awtgl.window.InnerDisplay;
import awtgl.window.Window;

public class Main {

    public static void main(String[] args) {
        
        Window window = new Window(1280, 720, "Goofy ahh", Window.WINDOWED);
        window.setBackground(new Color(0x000000));

        InnerDisplay innerDisplay = new InnerDisplay(128, 72, window);
        innerDisplay.setBackground(new Color(0x000000));
        
        window.setInnerDisplay(innerDisplay);

        window.start();

    }

}