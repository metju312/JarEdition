package controller.utils;

import controller.JarInstance;
import controller.jarElements.JarClass;
import controller.jarElements.JarPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Finder {
  private JarInstance jarInstance;
  public Finder(JarInstance jarInstance) {
    this.jarInstance = jarInstance;
  }

  public List<JarClass> findClassesWithPackageName(String packageName){
    List<JarClass> classList = new ArrayList<JarClass>();
    for (JarClass jarClass : jarInstance.getAllClasses()) {
      if(Objects.equals(jarClass.getJarPackage().getName(), packageName)){
        classList.add(jarClass);
      }
    }
    return classList;
  }

  public JarPackage findPackageWithName(String packageName) {
    for (JarPackage jarPackage : jarInstance.getAllPackages()) {
      if(Objects.equals(jarPackage.getName(), packageName)) {
        return jarPackage;
      }
    }
    return null;
  }
}
