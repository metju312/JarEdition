package view.panels.comboBoxPanels;

import controller.JarInstance;
import controller.jarElements.JarClass;
import controller.jarElements.JarPackage;
import view.panels.primaryPanels.LoadClassPanel;

import javax.swing.*;
import java.awt.*;

public class PackageComboBoxPanel extends CustomComboBoxPanel {
  private LoadClassPanel loadClassPanel;
  private JarInstance jarInstance;
  public PackageComboBoxPanel(LoadClassPanel loadClassPanel) {
    super("Package", loadClassPanel.getJarInstance());
    this.loadClassPanel = loadClassPanel;
    this.jarInstance =loadClassPanel.getJarInstance();
  }

  @Override
  protected void onComboBoxSelectItemWithText(String packageName) {
    jarInstance.setActualPackage(jarInstance.finder.findPackageWithName(packageName));
    loadClassPanel.getClassComboBoxPanel().generateAndSetComboBoxModelWithPackageName(packageName);
  }

  @Override
  public void generateAndSetComboBoxModel() {
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
    for (JarPackage jarPackage : jarInstance.getAllPackages()) {
      model.addElement(jarPackage.getName());
    }
    super.setComboBoxModel(model);
  }
}
