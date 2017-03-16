package View;

import Control.MainController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jean-Pierre on 15.11.2016.
 */
public class MainFrame extends JFrame {

    // Attribute

    //Referenzen
    private JPanel interactionPanel;
    private DrawingPanel treeDisplayPanel;

    /**
     * Konstruktor
     * @param name Der Titel des Fensters
     * @param x Die obere linke x-Koordinate des Fensters bzgl. des Bildschirms
     * @param y Die obere linke y-Koordinaite des Fensters bzgl. des Bildschirms
     * @param width Die Breite des Fensters
     * @param height Die Höhe des Fensters
     */
    public MainFrame(MainController mainController, String name, int x, int y, int width, int height) {
        this.treeDisplayPanel = new DrawingPanel();
        this.treeDisplayPanel.setOpaque(true);
        this.treeDisplayPanel.setBackground(new Color(10, 16, 65));

        this.interactionPanel = new InteractionPanelHandler(mainController, treeDisplayPanel).getPanel();

        Box box = Box.createVerticalBox();
        box.add(treeDisplayPanel);
        box.add(Box.createVerticalStrut(25));
        box.add(interactionPanel);
        this.add(box, BorderLayout.CENTER);

        addKeyListener(treeDisplayPanel);

        this.setLocation(x,y);
        this.setSize(width,height);
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    /**
     * Liefert das DrawingPanel zur Darstellung des Baumes zurück.
     * @return Das DrawingPanel-Objekt
     */
    public DrawingPanel getTopDrawingPanel(){
        return treeDisplayPanel;
    }
}
