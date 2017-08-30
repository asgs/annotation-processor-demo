package org.asgs.apdemo;

import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.SourceVersion;

import javax.tools.Diagnostic;

import org.asgs.apdemo.annotation.JavaBean;
import org.asgs.apdemo.annotation.PrivateOnly;

/**
 * The Annotation Processor for @JavaBean
 *
 */
@SupportedSourceVersion(value=SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"org.asgs.apdemo.annotation.JavaBean"})
public class JavaBeanAnnotationProcessor extends AbstractProcessor {
  public void init(ProcessingEnvironment processingEnvironment) {
    System.out.println("Inited JavaBeanAnnotationProcessor with " + processingEnvironment);
    this.processingEnv = processingEnvironment;
  }

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
    System.out.println("-----------------------------------");
    System.out.println("DEBUG - Received a process request for the annotations " + annotations + "; RoundEnvironment is " + roundEnvironment);
    Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(JavaBean.class);
    if (elements.isEmpty()) {
      return true;
    }
    System.out.println("INFO - Types annotated with @JavaBean are " + elements);
    List<? extends Element> types = elements.stream().filter(e -> (e.getKind() == ElementKind.CLASS)).collect(Collectors.toList());
    for (Element e : types) {
      // TODO - Generate a new Java file adding the setter/getter methods;
    }
    System.out.println("-----------------------------------");
    return true;
  }
}
