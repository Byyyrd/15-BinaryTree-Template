package View.TreeView;

import View.DrawTool;
import View.GraphicalObject;

import java.awt.*;

/**
 * Created by Jean-Pierre on 16.03.2017.
 */
public class TreeNode extends GraphicalObject {

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
    public void draw(DrawTool drawTool) {
        drawTool.formatText("Arial", Font.PLAIN, 10);

        if(green){
            drawTool.setCurrentColor(0,255,0, 255);
        }else{
            drawTool.setCurrentColor(255,0,0,255);
        }
        drawTool.drawCircle((int)x, (int)y, (int)r*2);
        drawTool.drawText((int)x, (int)y, text);
    }

    @Override
    public void update(double dt) {

    }
}
