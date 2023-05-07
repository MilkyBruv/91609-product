package awtgl.window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {

    private InnerDisplay innerDisplay;

    public Window(int width, int height, String title) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(width, height));
        this.setTitle(title);

    }



    public void setInnerDisplay(InnerDisplay innerDisplay) {

        this.innerDisplay = innerDisplay;

        this.add(innerDisplay);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }



    public void start() {

        this.innerDisplay.startThread();

    }

}
