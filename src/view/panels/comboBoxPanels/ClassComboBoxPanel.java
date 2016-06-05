package view.panels.comboBoxPanels;

import controller.JarInstance;
import controller.jarElements.JarClass;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import view.panels.primaryPanels.LoadClassPanel;

import javax.swing.*;

public class ClassComboBoxPanel extends CustomComboBoxPanel {
  private LoadClassPanel loadClassPanel;
  private JarInstance jarInstance;
  public ClassComboBoxPanel(LoadClassPanel loadClassPanel) {
    super("Class", loadClassPanel.getJarInstance());
    this.loadClassPanel = loadClassPanel;
    this.jarInstance = loadClassPanel.getJarInstance();



  }

  @Override
  protected void onComboBoxSelectItemWithText(String selectedClassName) {
    try {
      System.out.println(jarInstance.getActualPackage().getName()+"."+selectedClassName);
      jarInstance.setActualCtClass(jarInstance.getPool().getCtClass(jarInstance.getActualPackage().getName()+"."+selectedClassName));
    } catch (NotFoundException e) {
      e.printStackTrace();
    }

    loadClassPanel.getMethodComboBoxPanel().generateAndSetComboBoxModel();

  }

  @Override
  public void generateAndSetComboBoxModel() {
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
    for (JarClass jarClass : jarInstance.getAllClasses()) {
      model.addElement(jarClass.getName());
    }
    super.setComboBoxModel(model);
  }

  public void generateAndSetComboBoxModelWithPackageName(String packageName) {
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
    for (JarClass jarClass : jarInstance.finder.findClassesWithPackageName(packageName)) {
      model.addElement(jarClass.getName());
    }
    super.setComboBoxModel(model);
  }
}
