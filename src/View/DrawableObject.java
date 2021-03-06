package View;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Interface für Objekte, die man zeichnen und steuern kann.
 * Vorgegebene Klasse des Frameworks. Modifikation auf eigene Gefahr.
 */
public interface DrawableObject{

    void draw(DrawTool drawTool);

    void update(double dt);

    void keyPressed(int key);

    void keyReleased(int key);

    void mouseReleased(MouseEvent e);

    void mouseEntered(MouseEvent e);

    void mouseExited(MouseEvent e);

    void mouseClicked(MouseEvent e);

    void mouseDragged(MouseEvent e);

    void mouseMoved(MouseEvent e);

    void mousePressed(MouseEvent e);

    void keyTyped(KeyEvent e);

}
