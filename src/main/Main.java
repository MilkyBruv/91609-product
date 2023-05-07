package main;

import java.awt.Color;

import awtgl.window.InnerDisplay;
import awtgl.window.Window;

public class Main {

    public static void main(String[] args) {
        
        Window window = new Window(250, 250, "Goofy ahh");
        window.getContentPane().setBackground(new Color(0x000000));
        InnerDisplay innerDisplay = new InnerDisplay(100, 100, window);
        window.setInnerDisplay(innerDisplay);
        innerDisplay.setBackground(new Color(0xfefefe));

        window.start();

    }

}