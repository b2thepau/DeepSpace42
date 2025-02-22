
package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class MissionPanel {
    
    private String name;
    private int height, width;
    
    public MissionPanel(String n, int sW, int tH) {
       
        name = n;
        width = sW;
        height = tH/2;
    }
    
    public void draw(Graphics2D g){
        
        drawString(g);
        
    }
    
    public void update(){
        
    }
    
    public void drawString(Graphics2D g) {
        int fontSize = width/20;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g.setColor(Color.GREEN);
        int sizeName = name.length()*fontSize;
        g.drawString(name, width/2-sizeName/4, height/10);
        g.drawLine(width/2-sizeName/2, height/9, width/2+sizeName/2, height/9);
    }
}
