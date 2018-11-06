package org.happbean.candy.apidoc.code.parser;

import java.lang.annotation.Annotation;

@FunctionalInterface
public interface Parser {

    Annotation getAnnotation();

}
