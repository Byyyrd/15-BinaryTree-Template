package Control;

import Model.BinaryTree;
import View.DrawingPanel;
import View.TreeView.TreeNode;
import View.TreeView.TreePath;

/**
 * Created by Jean-Pierre on 12.01.2017. Minimal angepasst von RKR für den LK 2023-2025 :)
 */
public class MainController {

    private BinaryTree<String> binaryTree;

    public MainController(){
        binaryTree = new BinaryTree<>(""); // Ein Baum ohne Wurzel-Inhalt ist auf dauer ein leerer Baum - es lassen sich laut Dokumentation nichtmal Bäume anhängen. Also wird die Wurzel gefüllt.
        createMorseTree();
    }

    /**
     * Zur Präsentation des Programms wird der Morsecode im Baum dargestellt.
     */
    private void createMorseTree(){
        //TODO 02: Vervollständige den Morsebaum. Such bei google Morsebaum zur Unterstützung
        BinaryTree<String> left = new BinaryTree<>("E");
        BinaryTree<String> right = new BinaryTree<>("T");

        binaryTree.setLeftTree(left);
        binaryTree.setRightTree(right);

        left.setLeftTree(new BinaryTree<>("I",
                new BinaryTree<>("S",
                        new BinaryTree<>("H"),
                        new BinaryTree<>("V")),
                new BinaryTree<>("U",
                        new BinaryTree<>("F"),
                        new BinaryTree<>("Ü"))));
        left.setRightTree(new BinaryTree<>("A",
                new BinaryTree<>("R",
                        new BinaryTree<>("L"),
                        new BinaryTree<>("Ä")),
                new BinaryTree<>("W",
                        new BinaryTree<>("P"),
                        new BinaryTree<>("J"))));

        right.setLeftTree(new BinaryTree<>("N",
                new BinaryTree<>("D",
                        new BinaryTree<>("B"),
                        new BinaryTree<>("X")),
                new BinaryTree<>("K",
                        new BinaryTree<>("C"),
                        new BinaryTree<>("Y"))));
        right.setRightTree(new BinaryTree<>("M",
                new BinaryTree<>("G",
                        new BinaryTree<>("Z"),
                        new BinaryTree<>("Q")),
                new BinaryTree<>("O",
                        new BinaryTree<>("Ö"),
                        new BinaryTree<>("CH"))));
    }

    /**
     * Der Baum wird im übergebenem Panel dargestellt.
     * Dazu wird zunächst die alte Zeichnung entfernt.
     * Im Anschluss wird eine eine internete Hilfsmethode aufgerufen.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     */
    public void showTree(DrawingPanel panel){
        panel.removeAllObjects();
        //Der Baum wird in der Mitte des Panels beginnend gezeichnet: x = panel.getWidth()/2
        //Der linke und rechte Knoten in Tiefe 1 sind jeweils ein Viertel der Breite des Panels entfernt: spaceToTheSide = panel.getWidth()/4
        showTree(binaryTree, panel, panel.getWidth()/2, 50, panel.getWidth()/4);
		
	    //Aufruf fordert das Panel zur Aktualisierung auf.
	    panel.repaint();
    }

    /**
     * Hilfsmethode zum Zeichnen des Baums.
     * Für jeden Knoten wird ein neues TreeNode-Objekt dem panel hinzugefügt.
     * Für jede Kante wird ein neues TreePath-Pbjekt dem panel hinzugefügt.
     * @param tree Der zu zeichnende (Teil)Binärbaum.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     * @param startX x-Koordinate seiner Wurzel
     * @param startY y-Koordinate seiner Wurzel
     * @param spaceToTheSide Gibt an, wie weit horizontal entfernt die folgenden Bäume gezeichnet werden soll.
     */
    private void showTree(BinaryTree tree, DrawingPanel panel, double startX, double startY, double spaceToTheSide) {
        if (!tree.isEmpty()) {
            TreeNode node = new TreeNode(startX, startY, 10, tree.getContent().toString(), false);
            panel.addObject(node);
        }
        //bearbeite linken Teilbaum, falls dieser nicht leer ist
        if(!tree.getLeftTree().isEmpty()){
            TreePath path = new TreePath(startX,startY+10*2, startX-(spaceToTheSide/1.5),startY+60-10*2,0,false);
            panel.addObject(path);
            showTree(tree.getLeftTree(), panel, startX - (spaceToTheSide / 1.5), startY + 60, spaceToTheSide / 2);
        }
        //bearbeite rechten Teilbaum, falls dieser nicht leer ist
        //TODO 03: Lasse auch den rechten Teilbaum zeichnen
        if(!tree.getRightTree().isEmpty()){
            TreePath path = new TreePath(startX,startY+10*2, startX+(spaceToTheSide/1.5),startY+60-10*2,0,false);
            panel.addObject(path);
            showTree(tree.getRightTree(), panel, startX + (spaceToTheSide / 1.5), startY + 60, spaceToTheSide / 2);
        }
    }
}
