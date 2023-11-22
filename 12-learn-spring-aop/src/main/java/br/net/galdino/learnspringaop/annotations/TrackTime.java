package br.net.galdino.learnspringaop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Use in Methods:
@Target(ElementType.METHOD)
//Available in Runtime:
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {}
