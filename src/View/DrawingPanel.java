package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Stellt eine Zeichenfläche in einem DrawFrame-Fenster dar. Beim DrawingPanel über die Methode "add" registrierte
 * Objekte werden vom Panel gezeichnet. Außerdem kümmert sich das DrawingPanel um das Aufrufen der im framework
 * realisierten Callbacks wie etwa update und draw.
 * Diese Modellierung ist nicht sauber, da das DrawingPanel damit Funktionen eines Controllers übernimmt.
 * Vorgegebene Klasse des Frameworks. Modifikation auf eigene Gefahr.
 */
public class DrawingPanel extends JPanel implements KeyListener, MouseListener, MouseMotionListener {

    //Attribute
    private int currentDT;
    private boolean requested = false;

    // Referenzen
    private ArrayList<DrawableObject> drawableObjects;
    private ArrayList<Integer> currentlyPressedKeys;
    private DrawTool drawTool;

    /**
     * Konstruktor
     */
    public DrawingPanel(){
        super();
        setDoubleBuffered(true);
        drawableObjects = new ArrayList<>();
        currentlyPressedKeys = new ArrayList<Integer>();
        drawTool = new DrawTool();
    }

    /**
     * Sorgt dafür, dass alle Objekte gezeichnet und
     * anschließend gesteuert werden.
     */
    public void updateDrawingPanel(int dt){
        currentDT = dt;
        repaint();
    }

    /**
     * Zeichnen aller registrierten Objekte
     */
    @Override
    public void paintComponent(Graphics g) {
        if(!requested){
            addMouseListener(this);
            addKeyListener(this);
            setFocusable(true);
            requestFocusInWindow();
            requested = ! requested;
        }
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawTool.setGraphics2D(g2d);
        //Zeichne und update alle Objekte, die bei diesem DrawingPanel registriert sind
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.draw(drawTool);
            tempDO.update((double)currentDT/1000);
        }
    }

    /**
     * Diese Methode fügt ein neues Objekt zum Zeichnen hinzu. Die
     * Klasse des Objekts muss mindestens das Interface DrawableObject implementieren.
     * @param d Das ab sofort zu zeichnende Objekt
     */
    public void addObject(DrawableObject d){
        SwingUtilities.invokeLater(() -> drawableObjects.add(d));
    }

    /**
     * Diese Methode entfernt ein Objekt aus der Menge der zu zeichnenden Objekte. Die
     * Klasse des Objekts muss mindestens das Interface DrawableObject implementieren.
     * @param d Das ab sofort nicht mehr zu zeichnende Objekt
     */
    public void removeObject(DrawableObject d){
        SwingUtilities.invokeLater(() -> drawableObjects.remove(d));
    }

    /**
     * Diese Methode entfernt alle zu zeichnenden Objekte.
     */
    public void removeAllObjects(){
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            this.removeObject(iterator.next());
        }
    }

    @Override
    public void keyTyped(KeyEvent e){
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.keyTyped(e);
        }
    }

    /**
     * Weitergabe an Zeichnungsobjekte. Aufnahme des Keycodes in die gerade gedrückten Tasten.
     */
    public void keyPressed(KeyEvent e){
        if (!currentlyPressedKeys.contains(e.getKeyCode())) currentlyPressedKeys.add(e.getKeyCode());
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.keyPressed(e.getKeyCode());
        }
    }

    /**
     * Weitergabe an Zeichnungsobjekte. Löschen des Keycodes aus den gerade gedrückten Tasten.
     */
    public void keyReleased(KeyEvent e){
        if (currentlyPressedKeys.contains(e.getKeyCode())) currentlyPressedKeys.remove(e.getKeyCode());
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.keyReleased(e.getKeyCode());
        }

    }

    /**
     * Komfort-Methode, die prueft, ob eine Taste gedrückt ist
     */
    public boolean isKeyDown(int key){
        if (currentlyPressedKeys.contains(key)) return true;
        return false;
    }

    public void mousePressed(MouseEvent e) {
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.mousePressed(e);
        }
    }

    /**
     * Weiterleitung an InteractableObjects
     */
    public void mouseReleased(MouseEvent e) {
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.mouseEntered(e);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.mouseExited(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.mouseClicked(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()) {
            DrawableObject tempDO = iterator.next();
            tempDO.mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.mouseMoved(e);
        }
    }

}

