package controller.utils;

import controller.JarInstance;
import controller.jarElements.JarClass;
import controller.jarElements.JarPackage;
import javassist.NotFoundException;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class JarLoader {
  private JarInstance jarInstance;

  public JarLoader(JarInstance jarInstance) {
    this.jarInstance = jarInstance;
  }

  public void loadJar(String path){
    setJarInstancePackagesAndClasses(path);
    try {
      jarInstance.createPool();
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
  }

  private void setJarInstancePackagesAndClasses(String path) {
    List<JarClass> classList = new ArrayList<>();
    List<JarPackage> packageList = new ArrayList<>();
    try {
      JarInputStream jarInputStream = new JarInputStream(new FileInputStream(path));
      JarEntry jarEntry;
      while(true){
        jarEntry = jarInputStream.getNextJarEntry();
        if(jarEntry == null){
          break;
        }else if(jarEntry.getName().endsWith(".class")) {
          String classNameWithPackage = jarEntry.getName().replaceAll("/", "\\.");
          classNameWithPackage = classNameWithPackage.substring(0, classNameWithPackage.lastIndexOf("."));
          String packageName = classNameWithPackage.substring(0, classNameWithPackage.lastIndexOf("."));

          String className = classNameWithPackage.substring(packageName.length()+1);

          JarPackage jarPackage = new JarPackage(packageName);
          JarClass jarClass = new JarClass(className);

          jarClass.setJarPackage(jarPackage);
          jarClass.setNameWithPackage(classNameWithPackage);

          packageList.add(jarPackage);
          classList.add(jarClass);

        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    jarInstance.setAllClasses(classList);
    jarInstance.setAllPackages(packageList);
  }




}
