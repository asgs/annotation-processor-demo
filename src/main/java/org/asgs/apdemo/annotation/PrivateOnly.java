package org.asgs.apdemo.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * An Annotation that indicates it can be applied on members that are intended
 * to be private.
 *
 */
@Target(value={FIELD,METHOD})
@Retention(value=SOURCE)
public @interface PrivateOnly {

}
