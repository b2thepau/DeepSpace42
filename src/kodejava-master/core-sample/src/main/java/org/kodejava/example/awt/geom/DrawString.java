package org.kodejava.example.awt.geom;

import javax.swing.*;
import java.awt.*;

public class DrawString extends JPanel {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //
        // Define rendering hint, font name, font style and font size
        //
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font(Font.SERIF, Font.ITALIC, 40));
        g2.setPaint(Color.BLUE);

        //
        // Draw Hello World String
        //
        g2.drawString("Hello World!", 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Draw String Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new DrawString());
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
