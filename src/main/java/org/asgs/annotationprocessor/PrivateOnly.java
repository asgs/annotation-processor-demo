package org.asgs.annotationprocessor;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * An Annotation that indicates it can be applied on members that are intended
 * to be private.
 *
 */
@Target(value={TYPE,FIELD,METHOD})
@Retention(value=SOURCE)
public @interface PrivateOnly {

}
