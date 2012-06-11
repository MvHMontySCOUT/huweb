(ns huweb.views.welcome
  (:require [huweb.views.common :as common]
            [huweb.models.issuetracker :as issuetracker])
  (:use [noir.core]
        [hiccup.page]
        [hiccup.middleware]
        [hiccup.util]
        [hiccup.def]
        [hiccup.core]
        [hiccup.compiler]
        [hiccup.element]
        [hiccup.form]))

(defpage "/home" []
         (common/layout
           [:h1 "HUSACCT project"]
           (image {:class "right"} "image/husacct.png" "HUSACCT")
           [:p "What does HUSACCT Stand for?"]
           [:p "It stands for: Software Architecture Comformance Checking Tool<br>HU stands for: Hogeschool Utrecht (HU University of Applied Sciences Utrecht, The Netherlands. The school at which this project is taken place.)"]
           [:h2 "What is a Software Architecture Conformance Checking Tool?"]
           [:p "When building new software, software architects design an architecture for the application. The programmers are tasked with realizing the application based on the designed architecture.
To see if the realized architecture is really the designed architecture we can use a SACC-Tool. The following steps are taken to confirm this."]
           [:h3 "Analyse an architecture"]
           [:p "By analyzing the built application we can breakdown the structure of the application. That way we can use the physical entities that are detected to define an architecture.  
It also allows architects and programmers to view a graphical representation of the realized software architecture, but that is not good enough. We want to be able to check the analyzed software architecture against an architectural model."]
           [:h3 "Define an architecture"]
           [:p "Within this tool we define the architecture designed by the architects and the rules that apply to it. We create logical modules such as Layers and define rules that should be followed. Think of the communication rules present in the MVC pattern.<br><br>
Examples:<br>
1. Logical Layer 'Presentation' is allowed to use Logical Layer 'Task',
   but not with Logical Layer 'Infrastructure'.<br>
2. Package 'database' is not allowed to use package 'gui'.<br>  
3. Class 'MySQLDatbaseImpl' is not allowed to use class 'UserRegistrationController'."]
           [:h3 "Mapping the defined architecture"]
           [:p "We then map the physical entities we found, by analyzing, to the defined logical modules. That way the tool knows which physical entities (such as namespaces, packages, classes, interfaces, etc.) are present in which logical module.<br><br>
Examples:<br>
1. Package 'gui' should be present in Logical Layer 'Presentation'.<br>
2. Package 'database.mysql' should be present in Logical Layer 'Infrastructure'.<br>
3. Class 'UserRegistrationController' should be present in Logical Layer 'Presentation'."]
           [:h3 "Executing a conformance check"]
           [:p "By executing a conformance check we can see if any of the specified rules are broken. A SACC-Tool automates the process of checking whether or not these rules are broken. The reports from this conformance check will list/graphically display the violations that occur between entities.
Using the results from this conformance check programmers and architects can evaluate their realized software architecture. If there are serious issues they can improve it by changing the program so that it follows the specified rules. That way they are making it the software it was meant to be."]
           [:h2 "Why build a Software Architecture Conformance Checking Tool?"]
           [:p "After conducting research into other SACC-tools we found out that the tools not always are as user friendly and accurate as we had expected. We were then assigned to create our own SACC-tool and improve on some concept we found lacking in others. 
The application we were instructed to build is meant to be a contribution to the field of Software Architecture analysis and evaluation."]
           [:h2 "Support"]
           [:p "The tool itself is written in Java.  
Currently there is (only) support for the following <b>languages</b>:"]
           [:ul [:li "Java <i>Using Antlr</i>"]
            [:li ".NET C# <i>Using Antlr</i>"]]
           [:p "We are trying to build support for the following <b>rule types</b>:<br>"]
           [:ul [:li "Unique responsibility"]
            [:li "Visibility convention"]
            [:li "Naming convention"]
            [:li "Subclass convention"]
            [:li "Interface convention"]
            [:li "Is allowed to use"]
            [:li "Is only allowed to use"]
            [:li "Is the only module allowed to use"]
            [:li "Must use"]
            [:li "Is not allowed to"]
            [:li "use modules in a higher layer"]
            [:li "use modules in a not directly lower layer"]
            [:li "Exceptions to all those rules"]]
           [:p "Also we will try to support the following <b>violation types</b>:"]
           [:ul [:li "Invocation of a Method"]
            [:li "Invocation of a Constructor"]
            [:li "Access to a property or field"]
            [:li "Extending a concrete class"]
            [:li "Extending a abstract class"]
            [:li "Implementing a interface"]
            [:li "Declaration"]
            [:li "Annotation"]
            [:li "Import"]
            [:li "Exception"]]
           [:p "The architecture should allow for expansions to support more languages and rule types."]
           [:h2 "Plugins"]
           [:h3 "Eclipse IDE"]
           [:p "We have also made this an Eclipse plugin."]
           [:h3 "Maven"]
           [:p "We have also made this a Maven plugin."]
           [:h2 "Testing"]
           [:p "There are JUnit tests available in this repository, but we also manually test this application.  
For testing we use the <a href=\"https://github.com/HUSACCT/HUSACCT-BenchmarkApplication\">Java benchmark</a> application, the <a href=\"https://github.com/HUSACCT/HUSACCT-CsharpBenchmarkApplication\">C# benchmark</a> application, the Recognition test repository and this project itself."]
           [:h2 "Build team"]
           [:p "This project involves six teams from one class (Bachelor Computer Science Informatics 2011-2012); around 4 to 5 people a team. Each team is responsible for a different service (control, analyze (Java and .NET), define, validate and architecture graphics)."]
           [:h2 "Conclusion"]
           [:p "The project is ongoing and is meant to be completed around July 2012."]))

(defpage "/about" []
         (common/layout
           [:h1 "This is the about page"]))

(defpage "/feedback" []
         (common/layout
           [:span "To give feedback please click on this link "] (mail-to "jorikkraaikamp@gmail.com" "here") [:span ". If you have a bug to report please go to the "] (link-to "/issues" "issues page")))

(defpartial formtracker [{:keys [name mail message]}]
  (label "namee" "Naeme: ")
  (text-field "name" name)[:br]
  (label "mail" "E-mail: ")
  (text-field "mail" mail)[:br]
  (label "message" "Bericht: ")
  (text-area "message" message)[:br]
)

(defpage "/issues" {:as user}
	(common/layout
	  [:p "This is our issue tracker. You can inform us about any bug, improvement or other issue by sending us this form."]
	  (form-to [:post "/issuetracker"]
      (formtracker user)
      (submit-button "send")
   )
  )
)




(defpage "/download" []
         (common/layout
           [:p "This is the download page. Here you can download the husacct runable jar. we have a stable release and an unstable release."]
           (link-to {:class "download"} "https://github.com/downloads/HUSACCT/HUSACCT/HUSACCT.jar" "HUSSACT stable")[:br][:br]
           (link-to {:class "download"} "https://github.com/downloads/HUSACCT/HUSACCT/HUSACCT-unstable.jar" "HUSSACT unstable")
           [:p "We also have a stable release with an increased heapsize. This jar is ment for scanning big projects."]
           (link-to {:class "download"} "https://github.com/downloads/HUSACCT/HUSACCT/HUSACCT-launcher.jar" "HUSSACT stable increased heapsize")))
