package org.asgs.apdemo.classes;

import org.asgs.apdemo.annotation.PrivateOnly;

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
