package org.asgs.annotationprocessor;

/**
 * A Sample class using the @PrivateOnly annotation.
 *
 */

public class SampleClassWithPrivateOnlyAnnotation {
  @PrivateOnly
  String fieldThatShouldBePrivate;

  public SampleClassWithPrivateOnlyAnnotation(String arg) {
    fieldThatShouldBePrivate = arg;
    System.out.println("Instantiated MySampleAnnotatedClass.");
  }

  public SampleClassWithPrivateOnlyAnnotation() {
    System.out.println("Instantiated MySampleAnnotatedClass with no-arg constructor.");
  }
}
