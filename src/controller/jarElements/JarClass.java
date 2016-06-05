package controller.jarElements;

public class JarClass {
  private JarPackage jarPackage;
  private String name;
  private String nameWithPackage;

  public JarClass(String name) {
    this.name = name;
  }


  public JarPackage getJarPackage() {
    return jarPackage;
  }

  public void setJarPackage(JarPackage jarPackage) {
    this.jarPackage = jarPackage;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNameWithPackage() {
    return nameWithPackage;
  }

  public void setNameWithPackage(String nameWithPackage) {
    this.nameWithPackage = nameWithPackage;
  }
}
