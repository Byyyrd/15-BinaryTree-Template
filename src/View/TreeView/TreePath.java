package View.TreeView;

import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;

/**
 * Created by Jean-Pierre on 16.03.2017.
 */
public class TreePath implements DrawableObject {

    //Attribute
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double radius;
    private boolean green;

    /**
     * Konstruktor zum Zeichnen einer Kante. Sie wird von einem Knoten zu einem anderen Knoten führen.
     * @param startX x-Koordinate, bei der die Kante starten soll
     * @param startY y-Koordinate, bei der die Kante starten soll
     * @param endX x-Koordinate, bei der die Kante enden soll
     * @param endY y-Koordinate, bei der die Kante end soll
     * @param radius Radius der Knoten. Wird benötigt, damit die Kante sich nicht in den Knoten hineinzeichnet
     * @param green Der Knoten wird grün gezeichnet, falls true, sonst rot
     */
    public TreePath(double startX, double startY, double endX, double endY, double radius, boolean green) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.radius = radius;
        this.green = green;
    }

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        if(green){
            g2d.setColor(new Color(0,255,0));
        }else{
            g2d.setColor(new Color(255,0,0));
        }
        g2d.drawLine((int)(startX+radius) ,(int)(startY+2*radius) ,(int)(endX+radius) ,(int)(endY));
    }

    @Override
    public void update(double dt) {

    }
}
