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

/**
 * A Sample Annotation Processor for @PrivateOnly
 *
 */
@SupportedSourceVersion(value=SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"*"})
public class PrivateOnlyAnnotationProcessor extends AbstractProcessor {
  public void init(ProcessingEnvironment processingEnvironment) {
    System.out.println("Inited MyAnnotationProcessor with " + processingEnvironment);
    this.processingEnv = processingEnvironment;
  }

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
    System.out.println("Received a process request for the annotations " + annotations + "; RoundEnvironment is " + roundEnvironment);
    Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(PrivateOnly.class);
    System.out.println("Types annotated with MyAnnotation are " + elements);
    List<? extends Element> fields = elements.stream().filter(e -> (e.getKind() == ElementKind.FIELD || e.getKind() == ElementKind.METHOD)).collect(Collectors.toList());
    for (Element e : fields) {
      if (!e.getModifiers().contains(Modifier.PRIVATE)) {
        System.err.println("Encountered a field with name " + e.getSimpleName() + " not having a private modifier.");
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Encountered a field with name without a private access modifier", e);
      }
    }
    return true;
  }
}
