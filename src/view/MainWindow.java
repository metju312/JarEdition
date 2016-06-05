package view;

import view.panels.primaryPanels.InfoPanel;
import view.panels.primaryPanels.LoadClassPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

  private static MainWindow instance = null;
  private static final int WIDTH = 1000;
  private static final int HEIGHT = 700;

  public static MainWindow getInstance() {
    if (instance == null) {
      instance = new MainWindow();
    }
    return instance;
  }

  public MainWindow(){
    setLayout(new BorderLayout());
    setMainWindowValues();

    LoadClassPanel loadClassPanel = new LoadClassPanel("Load JAR file");
    InfoPanel infoPanel = new InfoPanel("Method info");

    getContentPane().add(loadClassPanel, BorderLayout.NORTH);
    getContentPane().add(infoPanel, BorderLayout.SOUTH);
  }

  private void setMainWindowValues() {
    setTitle("JFK 3 - Aplication");
    setSize(new Dimension(WIDTH,HEIGHT));
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }


}
