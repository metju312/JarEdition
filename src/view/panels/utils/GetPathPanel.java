package view.panels.utils;

import view.panels.primaryPanels.LoadClassPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GetPathPanel extends JPanel {
  LoadClassPanel loadClassPanel;

  private String path;

  private String fileType;

  private JLabel label;
  private JTextField textField;
  private JButton button;

  public GetPathPanel(String labelText, String fileType, LoadClassPanel loadClassPanel) {
    this.loadClassPanel = loadClassPanel;
    this.fileType = fileType;

    label = new JLabel(labelText + ":");
    textField = new JTextField(30);
    button = new JButton("...");
    addActionListenerToButton();

    add(label);
    add(textField);
    add(button);
  }

  private void addActionListenerToButton() {
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(fileType + " files", fileType));

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          path = selectedFile.getAbsolutePath();
          textField.setText(path);

          loadClassPanel.loadJar(path);
          loadClassPanel.setPackageModel();
        }
      }
    });
  }

  public String getPath() {
    return textField.getText();
  }
}
