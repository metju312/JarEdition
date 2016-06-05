package view.panels.comboBoxPanels;

import controller.JarInstance;
import javassist.CtMethod;
import view.panels.primaryPanels.LoadClassPanel;

import javax.swing.*;

public class MethodComboBoxPanel extends CustomComboBoxPanel{
  private LoadClassPanel loadClassPanel;
  private JarInstance jarInstance;
  public MethodComboBoxPanel(LoadClassPanel loadClassPanel) {
    super("Method", loadClassPanel.getJarInstance());
    this.loadClassPanel = loadClassPanel;
    this.jarInstance = loadClassPanel.getJarInstance();
  }

  @Override
  protected void onComboBoxSelectItemWithText(String text) {

  }

  @Override
  protected void generateAndSetComboBoxModel() {

    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

    for (CtMethod method : jarInstance.getActualCtClass().getMethods()) {
      model.addElement(method.getName());
    }
    super.setComboBoxModel(model);







  }
}
