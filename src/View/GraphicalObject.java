package View;

//import Config;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Zur Vererbung. Methoden können nach Bedarf überschrieben werden.
 * Vorgegebene Klasse des Frameworks. Modifikation auf eigene Gefahr.
 */
public abstract class GraphicalObject implements DrawableObject {

    // Attribute: um Konstruktoraufrufzwang zu vermeiden wurden hier AUSNAHMSWEISE Startwerte gesetzt
    protected double x = 0, y = 0; // Die Koordinaten des Objekts
    protected double width = 1, height = 1; // Die rechteckige Ausdehnung des Objekts, wobei x/y die obere, linke Ecke angeben

    // Referenzen
    private BufferedImage myImage;

    /**
     * Lädt ein Bild, das zur Repräsentation des Objekts benutzt werden kann.
     * Passt automatisch die Attribute für Breite und Höhe der des Bildes an.
     * @param pathToImage Der Pfad zu dem zu ladenden Bild
     */
    public BufferedImage createNewImage(String pathToImage){
        BufferedImage tmpImage = null;
        try {
            tmpImage = ImageIO.read(new File(pathToImage));
        } catch (IOException e) {
            if ( Config.INFO_MESSAGES) System.out.println("Laden eines Bildes fehlgeschlagen: "+pathToImage+"\n Hast du den Pfad und Dateinamen richtig geschrieben?");
        }
        return tmpImage;
    }

    /**
     * Lädt ein neues Bild und setzt es als aktuelles Bild
     * @param pathToImage Der Pfad zu dem zu ladenden Bild
     */
    public void createAndSetNewImage(String pathToImage){
        try {
            myImage = ImageIO.read(new File(pathToImage));
            width = myImage.getWidth();
            height = myImage.getHeight();
        } catch (IOException e) {
            if (Config.INFO_MESSAGES) System.out.println("Laden eines Bildes fehlgeschlagen: " + pathToImage);
        }
    }


    @Override
    /**
     * Wird vom Hintergrundprozess für jeden Frame aufgerufen. Nur hier kann die grafische Repräsentation des Objekts realisiert
     * werden. Es ist möglich über das Grafikobjekt "drawTool" ein Bild zeichnen zu lassen, aber auch geometrische Formen sind machbar.
     */
    public void draw(DrawTool drawTool) {

    }

    @Override
    /**
     * Wird vom Hintergrundprozess für jeden Frame aufgerufen. Hier kann das verhalten des Objekts festgelegt werden, zum Beispiel
     * seine Bewegung.
     */
    public void update(double dt) {

    }

    @Override
    /**
     * Wird einmalig aufgerufen, wenn eine Taste heruntergedrückt wird. Nach der Anschlagverzögerung löst Windows den Tastendruck dann
     * in schneller Folge erneut aus. Eignet sich NICHT, um Bewegungen zu realisieren.
     * @param key Enthält den Zahlencode für die Taste. Kann direkt aus der Klasse KeyEvent geladen werden, z.B. KeyEvent_VK_3
     */
    public void keyPressed(int key) {

    }

    @Override
    /**
     * Wird einmalig aufgerufen, wenn eine Taste losgelassen wird.
     * @param key Enthält den Zahlencode für die Taste. Kann direkt aus der Klasse KeyEvent geladen werden, z.B. KeyEvent_VK_3
     */
    public void keyReleased(int key) {

    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    /**
     * Wird einmalig aufgerufen, wenn eine Maustaste losgelassen wurde.
     * @param e Das übergebene Objekt der Klasse MouseEvent enthält alle Information über das Ereignis.
     */
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

    @Override
    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void mouseDragged(MouseEvent e){

    }

    @Override
    public void mouseMoved(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    /**
     * Überprüft, ob das übergebene Objekt mit diesem GraphicalObject kollidiert (Rechteckkollision). Dabei werden die Koordinaten und
     * die Breite und Höhe des Objekts berücksichtigt.
     * @param gO Das Objekt, das auf Kollision überprüft wird
     * @return True, falls eine Kollision besteht, sonst false.
     */
    public boolean collidesWith(GraphicalObject gO){
        if ( x < gO.getX()+gO.getWidth() && x + width > gO.getX() && y < gO.getY() + gO.getHeight() && y + height > gO.getY() ) return true;
        return false;
    }

    /**
     * Berechnet die Distanz zwischen dem Mittelpunkt dieses Objekts und dem Mittelpunkt des übergebenen Objekts.
     * @param gO Das Objekt zu dem die Entfernung gemessen wird.
     * @return Die exakte Entfernung zwischen den Mittelpunkten
     */
    public double getDistanceTo(GraphicalObject gO){
        // Berechne die Mittelpunkte der Objekte
        double midX = x + width/2;
        double midY = y + height/2;
        double midX2 = gO.getX() + gO.getWidth()/2;
        double midY2 = gO.getY() + gO.getHeight()/2;
        // Berechne die Distanz zwischen den Punkten mit dem Satz des Pythagoras
        return Math.sqrt( Math.pow(midX-midX2, 2) + Math.pow(midY-midY2,2));
    }


    // Sondierende Methoden: "getter"

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public BufferedImage getMyImage() {
        return myImage;
    }

    // Manipulierende Methoden: "setter"

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setMyImage(BufferedImage myImage) {
        this.myImage = myImage;
        width = this.myImage.getWidth();
        height = this.myImage.getHeight();
    }
}
