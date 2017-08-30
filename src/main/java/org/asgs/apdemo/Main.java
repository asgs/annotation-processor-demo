package org.asgs.apdemo;

import org.asgs.apdemo.PrivateOnlyAnnotationProcessor;

import java.io.File;
import java.util.Arrays;
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
    File[] files1 = new File(new File(args[0]).getAbsolutePath()).listFiles(f -> f.getName().endsWith(".java"));
    Arrays.asList(files1).stream().forEach(System.out::println);
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
    Iterable<? extends JavaFileObject> files = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files1));
    JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, files);
    task.setProcessors(Arrays.asList(new PrivateOnlyAnnotationProcessor()));
    System.out.println(task.call());
  }
}
