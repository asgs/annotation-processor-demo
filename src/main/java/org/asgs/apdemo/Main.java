package org.asgs.apdemo;

import org.asgs.apdemo.PrivateOnlyAnnotationProcessor;

import java.io.File;

import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * Entry point to the demo.
 *
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("Sourcepath is " + args[0]);
    // We're interested in scanning all .java files under the sourcepath passed as an argument here.
    List<File> sourceFiles = Arrays.asList(new File(new File(args[0]).getAbsolutePath()).listFiles(f -> f.getName().endsWith(".java")));
    sourceFiles.stream().forEach(System.out::println); // Printing the detected class file paths.
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
    Iterable<? extends JavaFileObject> javaFileObjects = fileManager.getJavaFileObjectsFromFiles(sourceFiles);
    JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, javaFileObjects);
    task.setProcessors(Arrays.asList(new PrivateOnlyAnnotationProcessor(), new JavaBeanAnnotationProcessor()));
    System.out.println(task.call());
  }
}
