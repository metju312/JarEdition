package controller;

import controller.jarElements.JarClass;
import controller.jarElements.JarMethod;
import controller.jarElements.JarPackage;
import controller.utils.Finder;
import javassist.ClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.util.List;

public class JarInstance {
  public Finder finder;

  private ClassPool pool;
  private CtClass actualCtClass;

  private String jarPath;
  private ClassPath jarClassPath;

  private JarPackage actualPackage;
  private JarClass actualClass;
  private JarMethod actualMethod;

  private List<JarPackage> allPackages;
  private List<JarClass> allClasses;
  private List<JarMethod> allMethods;

  private List<JarClass> actualPackageClasses;
  private List<JarMethod> actualClassMethods;

  public JarInstance() {
    finder = new Finder(this);
  }

  public String getJarPath() {
    return jarPath;
  }

  public void setJarPath(String jarPath) {
    this.jarPath = jarPath;
  }

  public JarPackage getActualPackage() {
    return actualPackage;
  }

  public void setActualPackage(JarPackage actualPackage) {
    this.actualPackage = actualPackage;
  }

  public JarClass getActualClass() {
    return actualClass;
  }

  public void setActualClass(JarClass actualClass) {
    this.actualClass = actualClass;
  }

  public JarMethod getActualMethod() {
    return actualMethod;
  }

  public void setActualMethod(JarMethod actualMethod) {
    this.actualMethod = actualMethod;
  }

  public List<JarPackage> getAllPackages() {
    return allPackages;
  }

  public void setAllPackages(List<JarPackage> allPackages) {
    this.allPackages = allPackages;
  }

  public List<JarClass> getActualPackageClasses() {
    return actualPackageClasses;
  }

  public void setActualPackageClasses(List<JarClass> actualPackageClasses) {
    this.actualPackageClasses = actualPackageClasses;
  }

  public List<JarMethod> getActualClassMethods() {
    return actualClassMethods;
  }

  public void setActualClassMethods(List<JarMethod> actualClassMethods) {
    this.actualClassMethods = actualClassMethods;
  }

  public List<JarClass> getAllClasses() {
    return allClasses;
  }

  public void setAllClasses(List<JarClass> allClasses) {
    this.allClasses = allClasses;
  }

  public List<JarMethod> getAllMethods() {
    return allMethods;
  }

  public void setAllMethods(List<JarMethod> allMethods) {
    this.allMethods = allMethods;
  }

  public ClassPool getPool() {
    return pool;
  }

  public void setPool(ClassPool pool) {
    this.pool = pool;
  }

  public void createPool() throws NotFoundException {
    pool = new ClassPool(ClassPool.getDefault());
    this.jarClassPath = pool.appendClassPath(jarPath);
  }

  public CtClass getActualCtClass() {
    return actualCtClass;
  }

  public void setActualCtClass(CtClass actualCtClass) {
    this.actualCtClass = actualCtClass;
  }
}
