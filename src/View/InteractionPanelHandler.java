package View;

import Control.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jean-Pierre on 12.01.2017.
 */
public class InteractionPanelHandler {
    private JPanel panel;
    private JButton displayTreeButton;
    private JTextArea output;
    private JButton traverseButton;

    private MainController mainController;
    private DrawingPanel treeDisplayPanel;

    public InteractionPanelHandler(MainController mainController, DrawingPanel treeDisplayPanel) {
        this.mainController = mainController;
        this.treeDisplayPanel = treeDisplayPanel;
        createButtons();
    }

    private void createButtons(){
        displayTreeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.showTree(treeDisplayPanel);
                showText("Der Baum wird nun dargestellt. Eventuell fand eine Aktualisierung statt.");
            }
        });

        traverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showText(mainController.traverse());
            }
        });
    }

    public JPanel getPanel(){
        return panel;
    }

    private void showText(String text){
        output.setText(output.getText() + "\n" + text);
    }
}
