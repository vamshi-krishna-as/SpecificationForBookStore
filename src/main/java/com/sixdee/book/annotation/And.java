package com.sixdee.book.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;


/**
 * @author Tomasz Kaczmarzyk
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER, ElementType.TYPE })
public @interface And {

    Spec[] value();
}
