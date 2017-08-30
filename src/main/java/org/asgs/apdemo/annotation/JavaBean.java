package org.asgs.apdemo.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * A TYPE-level Annotation indicating that the setter, getter methods for all
 * the fields are to be auto-generated.
 *
 */
@Target(value={TYPE})
@Retention(value=SOURCE)
public @interface JavaBean {

}
