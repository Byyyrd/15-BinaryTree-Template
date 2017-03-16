package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DrawingPanel extends JPanel implements ActionListener, KeyListener, MouseListener {

    //Attribute
    private int dt;
    private long lastLoop, elapsedTime;
    private boolean requested = false;

    // Referenzen
    private ArrayList<DrawableObject> drawableObjects;
    private ArrayList<Integer> currentlyPressedKeys;

    /**
     * Konstruktor
     */
    public DrawingPanel(){
        super();
        addMouseListener(this);
        setDoubleBuffered(true);
        drawableObjects = new ArrayList<>();
        currentlyPressedKeys = new ArrayList<Integer>();
        dt = 35; //Vernünftiger Startwert
        lastLoop = System.nanoTime();
        javax.swing.Timer timer = new javax.swing.Timer(dt, this);
        timer.start();
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
            requested = !requested;
        }

        super.paintComponent(g);
        elapsedTime = System.nanoTime() - lastLoop;
        lastLoop = System.nanoTime();
        dt = (int) ((elapsedTime / 1000000L)+0.5);
        if ( dt == 0 ) dt = 1;
        Graphics2D g2d = (Graphics2D) g;
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            tempDO.draw(this,g2d);
            tempDO.update((double)dt/1000);
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
     * Löscht alle Objekte vom DrawingPanel. Im Anschluss ist das DrawingPanel leer.
     */
    public void removeAllObjects(){
        SwingUtilities.invokeLater(() -> drawableObjects.clear());
    }

    /**
     * Timer-Repaint
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /**
     * Unbenutzt bis auf Weiteres
     */
    public void keyTyped(KeyEvent e){

    }

    /**
     * Weitergabe an Zeichnungsobjekte. Aufnahme des Keycodes in die gerade gedrückten Tasten.
     */
    public void keyPressed(KeyEvent e){
        if (!currentlyPressedKeys.contains(e.getKeyCode())) currentlyPressedKeys.add(e.getKeyCode());
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            if (tempDO instanceof InteractableObject){
                ((InteractableObject)tempDO).keyPressed(e.getKeyCode());
            }
        }
    }

    /**
     * Weitergabe an Zeichnungsobjekte. Löschen des Keycodes aus den gerade gedrückten Tasten.
     */
    public void keyReleased(KeyEvent e){
        if (currentlyPressedKeys.contains(e.getKeyCode()))currentlyPressedKeys.remove(new Integer(e.getKeyCode()));
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            if (tempDO instanceof InteractableObject){
                ((InteractableObject)tempDO).keyReleased(e.getKeyCode());
            }
        }

    }

    /**
     * Komfort-Methode, die prueft, ob eine Taste gedrückt ist
     */
    public boolean isKeyDown(int key){
        if (currentlyPressedKeys.contains(key)) return true;
        return false;
    }

    /**
     * Unbenutzt bis auf Weiteres
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Weiterleitung an InteractableObjects
     */
    public void mouseReleased(MouseEvent e) {
        Iterator<DrawableObject> iterator = drawableObjects.iterator();
        while (iterator.hasNext()){
            DrawableObject tempDO = iterator.next();
            if (tempDO instanceof InteractableObject){
                ((InteractableObject)tempDO).mouseReleased(e);
            }
        }
    }

    /**
     * Unbenutzt bis auf Weiteres
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Unbenutzt bis auf Weiteres
     */
    public void mouseExited(MouseEvent e) {
    }

    /**
     * Unbenutzt bis auf Weiteres
     */
    public void mouseClicked(MouseEvent e) {
    }

}