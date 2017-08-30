package org.asgs.annotationprocessor;

import java.io.File;

import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;


/**
 * Entry point to the demo.
 *
 */
public class Main {
  public static void main(String[] args) {
    SampleClassWithPrivateOnlyAnnotation klass = new SampleClassWithPrivateOnlyAnnotation("sdsd");
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
    Iterable<? extends JavaFileObject> files = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(new File("/home/gowrysankar/Projects/annotation-process-demo/src/main/java/org/asgs/annotationprocessor").listFiles(f -> f.getName().endsWith(".java"))));
    JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, files);
    task.setProcessors(Arrays.asList(new PrivateOnlyAnnotationProcessor()));
    System.out.println(task.call());
  }
}
