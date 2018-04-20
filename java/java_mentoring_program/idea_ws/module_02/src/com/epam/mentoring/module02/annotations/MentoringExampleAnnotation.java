package com.epam.mentoring.module02.annotations;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MentoringExampleAnnotation {

    String name();
    boolean lazyLoad() default false;
}
