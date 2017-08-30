# Annotation Processor Demo

<b>Introduction</b>

Annotations are a great way to express intent in Java. e.g. the built-in annotations `@Override`, `@Deprecated` are so popular that you can find these almost in every code repository out there. Sometimes, annotations can be helpful in enforcing certain compile-time or even runtime requirements. Like you can mark a Java `class` `@Immutable` meaning its state can NOT be modified after construction. The Annotation Processor capable of supporting this annotation can then modify those classes adding necessary constructs to enforce the immutability of its state.

<b>About this repository</b>

This is intended to be a tutorial kind of artifact for beginners. I've recently started playing with Annotation processing and it's not a topic that's exactly easily teachable. So not only is this repo going to serve me as an exercise for my learning, it can be helpful to others who stumble upon something similar. 

What it does right now, is declare a new annotation `@PrivateOnly` which is intended to be applied to class members (i.e. fields and methods) which are meant to `private`. The Annotation processor "claiming" to handle such annotations will scan the source code (the path of which is currently configured in maven's pom.xml as part of [exec-maven-plugin](http://www.mojohaus.org/exec-maven-plugin/usage.html#POM_Configuration) to check if the members annotated so are indeed private. If not, it will report an error and stop the current round of execution.

As you could see, it is just a silly use case I'm came up with; but there are a lot of scenarios where Annotations could be [handy](https://stackoverflow.com/questions/1372876/how-and-where-are-annotations-used-in-java#answer-1918154). It's become a trend for Java libraries, frameworks to be annotation-driven these days (including JavaEE).

<b>Build and Run</b>
The project is built using Maven, so `mvn -e clean package exec:exec` is what you need to build the project and see the demo.
