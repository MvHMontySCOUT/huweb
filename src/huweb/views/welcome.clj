(ns huweb.views.welcome
  (:require [huweb.views.common :as common])
  (:use [noir.core]
        [hiccup.page]
        [hiccup.middleware]
        [hiccup.util]
        [hiccup.def]
        [hiccup.core]
        [hiccup.compiler]
        [hiccup.element]))

(defpage "/home" []
         (common/layout
           [:h1 "HUSACCT project"]
           [:p "What does HUSACCT Stand for?"]
           [:p "It stands for: Software Architecture Comformance Checking Tool<br>HU stands for: [Hogeschool Utrecht](http://international.hu.nl/) (HU University of Applied Sciences Utrecht, The Netherlands. The school at which this project is taken place.)"]
           [:h2 "What is a Software Architecture Conformance Checking Tool?"]
           [:p "When building new software, software architects design an architecture for the application. The programmers are tasked with realizing the application based on the designed architecture.

To see if the realized architecture is really the designed architecture we can use a SACC-Tool. The following steps are taken to confirm this.

### Analyse an architecture

By analyzing the built application we can breakdown the structure of the application. That way we can use the physical entities that are detected to define an architecture.  
It also allows architects and programmers to view a graphical representation of the realized software architecture, but that is not good enough. We want to be able to check the analyzed software architecture against an architectural model.

### Define an architecture

Within this tool we define the architecture designed by the architects and the rules that apply to it. We create logical modules such as [Layers](http://en.wikipedia.org/wiki/Common_layers_in_an_information_system_logical_architecture) and define rules that should be followed. Think of the communication rules present in the [MVC pattern](http://en.wikipedia.org/wiki/Model-view-controller).

Examples:

1. `Logical Layer 'Presentation' is allowed to use Logical Layer 'Task',`  
   `but not with Logical Layer 'Infrastructure'.`  
2. `Package 'database' is not allowed to use package 'gui'`.  
2. `Class 'MySQLDatbaseImpl' is not allowed to use class 'UserRegistrationController'`.  

_(not actual syntax/code used in the tool)_  

### Mapping the defined architecture

We then map the physical entities we found, by analyzing, to the defined logical modules. That way the tool knows which physical entities (such as namespaces, packages, classes, interfaces, etc.) are present in which logical module.

Examples:

1. `Package 'gui' should be present in Logical Layer 'Presentation'.`
2. `Package 'database.mysql' should be present in Logical Layer 'Infrastructure'.`
2. `Class 'UserRegistrationController' should be present in Logical Layer 'Presentation'.`

_(not actual syntax/code used in the tool)_  

### Executing a conformance check

By executing a conformance check we can see if any of the specified rules are broken. A SACC-Tool automates the process of checking whether or not these rules are broken. The reports from this conformance check will list/graphically display the violations that occur between entities.

Using the results from this conformance check programmers and architects can evaluate their realized software architecture. If there are serious issues they can improve it by changing the program so that it follows the specified rules. That way they are making it the software it was meant to be.

## Why build a Software Architecture Conformance Checking Tool?

After conducting research into other SACC-tools we found out that the tools not always are as user friendly and accurate as we had expected. We were then assigned to create our own SACC-tool and improve on some concept we found lacking in others. 

The application we were instructed to build is meant to be a contribution to the field of Software Architecture analysis and evaluation.

## Support

The tool itself is written in Java.  
Currently there is (only) support for the following **languages**:

- Java _(Using Antlr)_
- .NET C# _(Using Antlr)_

We are trying to build support for the following **rule types**:

- Unique responsibility
- Visibility convention
- Naming convention
- Subclass convention
- Interface convention
- Is allowed to use
	- Is only allowed to use
	- Is the only module allowed to use
	- Must use
- Is not allowed to
	- use modules in a higher layer
	- use modules in a not directly lower layer
- Exceptions to all those rules

Also we will try to support the following **violation types**:

- Invocation of a Method
- Invocation of a Constructor
- Access to a property or field
- Extending a concrete class
- Extending a abstract class
- Implementing a interface
- Declaration
- Annotation
- Import
- Exception


The architecture should allow for expansions to support more languages and rule types.

## Plugins

### Eclipse IDE

We have also made this an [Eclipse](http://www.eclipse.org/) plugin. ([Eclipse plugin repository](https://github.com/HUSACCT/HUSACCT-Plugin))

### Maven

We have also made this a [Maven](http://maven.apache.org/) plugin. ([Maven plugin repository](https://github.com/HUSACCT/HUSACCT-Maven))

## Testing

There are JUnit tests available in this repository, but we also manually test this application.  
For testing we use the [Java benchmark](https://github.com/HUSACCT/HUSACCT-BenchmarkApplication) application, the [C# benchmark](https://github.com/HUSACCT/HUSACCT-CsharpBenchmarkApplication) application, the [Recognition test repository](https://github.com/HUSACCT/HUSACCT-RecognitionTest) and this project itself.

## Build team

This project involves six teams from one class (Bachelor Computer Science Informatics 2011-2012); around 4 to 5 people a team. Each team is responsible for a different service (control, analyze (Java and .NET), define, validate and architecture graphics).

## Conclusion

The project is ongoing and is meant to be completed around July 2012."]))

(defpage "/about" []
         (common/layout
           [:p "Welcome to huweb"]))

(defpage "/feedback" []
         (common/layout
           [:p "Welcome to huweb"]))

(defpage "/issues" []
         (common/layout
           [:p "Welcome to huweb"]))

(defpage "/download" []
         (common/layout
           [:p "This is the download page. Here you can download the husacct runable jar. we have a stable release and an unstable release."]
           (link-to {:class "download"} "https://github.com/downloads/HUSACCT/HUSACCT/HUSACCT.jar" "HUSSACT stable")[:br][:br]
           (link-to {:class "download"} "https://github.com/downloads/HUSACCT/HUSACCT/HUSACCT-unstable.jar" "HUSSACT unstable")
           [:p "We also have a stable release with an increased heapsize. This jar is ment for scanning big projects."]
           (link-to {:class "download"} "https://github.com/downloads/HUSACCT/HUSACCT/HUSACCT-launcher.jar" "HUSSACT stable increased heapsize")))