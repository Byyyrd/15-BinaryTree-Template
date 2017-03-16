package View.TreeView;

import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;

/**
 * Created by Jean-Pierre on 16.03.2017.
 */
public class TreeNode implements DrawableObject{

    //Attribute
    private double x;
    private double y;
    private double r;
    private String text;
    private boolean green;

    /**
     * Konstruktor für eine Note.
     * @param x x-Koordinate des Knotens
     * @param y y-Koordinate des Knotens
     * @param r Radius des Knotens
     * @param text Inhalt als Zeichenkette - sollten maximal 2 Zeichen sein
     * @param green Der Knoten wird grün gezeichnet, falls true, sonst rot.
     */
    public TreeNode(double x, double y, double r, String text, boolean green) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.text = text;
        this.green = green;
    }

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));

        if(green){
            g2d.setColor(new Color(0,255,0));
        }else{
            g2d.setColor(new Color(255,0,0));
        }
        g2d.drawOval((int)x, (int)y, (int)r*2, (int)r*2);
        g2d.drawString(text, (int)x + (int)(0.75*r), (int)y + (int)(1.25*r));
    }

    @Override
    public void update(double dt) {

    }
}
