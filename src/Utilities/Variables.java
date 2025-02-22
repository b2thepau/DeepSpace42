package Utilities;

import java.awt.Color;
import java.awt.geom.Area;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Variables {

    private final String lexic = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    private final Random rand = new java.util.Random();

    final Set<String> identifiers = new HashSet<String>();

    public static final Color RED = new Color(195, 20, 20);
    public static final Color GREEN = new Color(50, 190, 70);

    private Color mainColor = GREEN;

    public Variables() {

    }

    public String randomName() {
        StringBuilder b = new StringBuilder();
        while (b.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                b.append(lexic.charAt(rand.nextInt(lexic.length())));
            }
            if (identifiers.contains(b.toString())) 
             {
                b = new StringBuilder();
            }
        }
        return b.toString();
    }
    
    public int randNum(int min, int max) {
       Random rand = new Random();
        return (rand.nextInt((max - min) + 1) + min);
    }
    
    public float randFloat(float min, float max) {
       Random rand = new Random();
        return (rand.nextFloat()*(max - min) + min);
    }
    
    public double calculateDistanceFromPoint(float cx, float cy, float x, float y){
        return Math.sqrt((cx-x)*(cx-x) + (cy-y)*(cy-y));
    }
    
    public boolean Collision(Area area1, Area area2) {
        boolean collide = false;

        Area collide1 = new Area(area1);
        collide1.subtract(area2);

        if (!collide1.equals(area1)) {
            collide = true;
        }

        Area collide2 = new Area(area2);
        collide2.subtract(area1);

        if (!collide2.equals(area2)) {
            collide = true;
        }
        return collide;
    }
    
    public Color getMainColor() {
        return mainColor;
    }

    public void setMainColor(Color c) {
        mainColor = c;
    }
}
