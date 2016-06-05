package view.panels.primaryPanels;

import controller.JarInstance;
import controller.utils.JarLoader;
import net.miginfocom.swing.MigLayout;
import view.panels.comboBoxPanels.ClassComboBoxPanel;
import view.panels.comboBoxPanels.MethodComboBoxPanel;
import view.panels.comboBoxPanels.PackageComboBoxPanel;
import view.panels.utils.GetPathPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LoadClassPanel extends JPanel {
  private GetPathPanel getPathPanel;
  private PackageComboBoxPanel packageComboBoxPanel;
  private ClassComboBoxPanel classComboBoxPanel;
  private MethodComboBoxPanel methodComboBoxPanel;

  private JarInstance jarInstance = new JarInstance();
  private JarLoader jarLoader;

  public LoadClassPanel(String title) {
    setBorder(title);
    setLayout(new MigLayout());
    jarLoader = new JarLoader(jarInstance);

    getPathPanel = new GetPathPanel("JAR Path","JAR", this);
    add(getPathPanel, "wrap");

    packageComboBoxPanel = new PackageComboBoxPanel(this);
    add(packageComboBoxPanel, "wrap");

    classComboBoxPanel = new ClassComboBoxPanel(this);
    add(classComboBoxPanel, "wrap");

    methodComboBoxPanel = new MethodComboBoxPanel(this);
    add(methodComboBoxPanel, "wrap");
  }

  private void setBorder(String title) {
    TitledBorder titledBorder;
    titledBorder = BorderFactory.createTitledBorder(title);
    this.setBorder(titledBorder);
  }

  public void loadJar(String path) {
    jarInstance.setJarPath(path);
    jarLoader.loadJar(path);
  }

  public void setClassModel() {
    classComboBoxPanel.generateAndSetComboBoxModel();
  }

  public void setPackageModel() {
    packageComboBoxPanel.generateAndSetComboBoxModel();

  }

  public JarInstance getJarInstance() {
    return jarInstance;
  }

  public ClassComboBoxPanel getClassComboBoxPanel() {
    return classComboBoxPanel;
  }

  public MethodComboBoxPanel getMethodComboBoxPanel() {
    return methodComboBoxPanel;
  }
}
