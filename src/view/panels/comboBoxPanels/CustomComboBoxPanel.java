package view.panels.comboBoxPanels;

import controller.JarInstance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CustomComboBoxPanel extends JPanel{
  private JarInstance jarInstance;
  private JComboBox comboBox;
  public CustomComboBoxPanel(String labelTitle, JarInstance jarInstance) {
    this.jarInstance = jarInstance;
    setLayout(new BorderLayout());
    add(new Label(labelTitle + ":"),BorderLayout.WEST);
    addComboBox();
  }

  private void addComboBox() {
    comboBox = new JComboBox();
    comboBox.setPreferredSize(new Dimension(200,20));
    comboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        onComboBoxSelectItemWithText((String)cb.getSelectedItem());
      }
    });

    add(comboBox,BorderLayout.CENTER);
  }

  protected abstract void onComboBoxSelectItemWithText(String text);


  public void setComboBoxModel(DefaultComboBoxModel comboBoxModel){
    comboBox.setModel(comboBoxModel);
  }

  protected abstract void generateAndSetComboBoxModel();

}
