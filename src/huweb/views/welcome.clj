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
           (image {:class "right"} "image/husacct.png" "HUSACCT")
           (issuetracker/readissue! "homePageText.txt")))

(defpage "/about" []
         (common/layout
           [:h1 "project"]
           [:p "This project involves six teams from one class Bachelor Computer Science Informatics 2011-2012 around 4 to 5 people a team. Each team is responsible for a different service (control, analyze (Java and .NET), define, validate and architecture graphics)."]
           [:h1 "Future"]
           [:p "Our development will be continued after the official project stops, so keep an eye on our GitHub repository. Enthusiast students and teachers will happily participate the development community."]
           )
)

(defpage "/feedback" []
         (common/layout
           [:span "To give feedback please click on this link "] (mail-to "jorikkraaikamp@gmail.com" "here") [:span ". If you have a bug to report please go to the "] (link-to "/issues" "issues page")))

(defpartial formtracker [{:keys [name mail message]}]
  [:fieldset (label "name" "Name: ")
  (text-field "name" name)]
  [:fieldset (label "mail" "E-mail: ")
  (text-field "mail" mail)]
  [:fieldset (label "message" "Bericht: ")
  (text-area "message" message)]
)

(defpage "/issues" {:as issue}
	(common/layout
	  [:p "This is our issue tracker. You can inform us about any bug, improvement or other issue by sending us this form."]
   [:div [:p (issuetracker/readissue! "issue.txt")] 
    ]
	  (form-to [:post "/thanks"]
      (formtracker issue)
      (submit-button {:class "download"} "send")
      [:div {:class "clear"} ""]
   )
  )
)

(defpage [:post "/thanks"] [:as issue]
  (issuetracker/writeissue! issue)
         (common/layout
           [:p "thanks for letting us know about your issue!"]
           (link-to {:class "download"} "/issues" "Go back to the issues")))



(defpage "/download" []
         (common/layout
           [:p "This is the download page. Here you can download the husacct runable jar. we have a stable release and an unstable release."]
           (link-to {:class "download"} "https://github.com/downloads/HUSACCT/HUSACCT/HUSACCT.jar" "HUSSACT stable")[:br][:br]
           (link-to {:class "download"} "https://github.com/downloads/HUSACCT/HUSACCT/HUSACCT-unstable.jar" "HUSSACT unstable")
           [:p "We also have a stable release with an increased heapsize. This jar is ment for scanning big projects."]
           (link-to {:class "download"} "https://github.com/downloads/HUSACCT/HUSACCT/HUSACCT-launcher.jar" "HUSSACT stable increased heapsize")
           [:p "Or checkout the code on Github. Feel free to fork the project and work on it yourself."]
           (link-to {:class "download"} "https://github.com/HUSACCT/HUSACCT" "HUSSACT Code")))
