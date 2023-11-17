#!/bin/bash

if [ "$LAB_CONTAINER" == "1" ]; then
  # DO NOT TOUCH THIS
  javaRuntime=java
  javaCompiler=javac
else
  # Insert Java runtime and compiler path here
  javaRuntime=/usr/lib/jvm/java-17/bin/java
  javaCompiler=/usr/lib/jvm/java-17/bin/javac
fi