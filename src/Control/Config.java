package control;

/**
 * In dieser Klasse werden globale, statische Einstellungen verwaltet.
 * Die Werte können nach eigenen Wünschen angepasst werden.
 */
public class Config {

    // Titel des Programms (steht oben in der Fenstertitelzeile)
    public final static String WINDOW_TITLE = "Vorlage des grafischen Frameworks mit Einstiegsklasse";

    // Breite des Programmfensters (Width) und Höhe des Programmfensters (Height)
    public final static int WINDOW_WIDTH = 1600;
    public final static int WINDOW_HEIGHT = 1024;   // Effektive Höhe ist etwa 29 Pixel geringer (Titelleiste wird mitgezählt)

    // Schaltet die Infomeldungen des Frameworks an oder aus
    public final static boolean INFO_MESSAGES = true;
    public final static boolean DEBUG = true;

    // Frameworkversion
    public final static String VERSION = "AOS-KNB-Graphical-Java-Framework - 2.1 - 04.11.2019";

}
