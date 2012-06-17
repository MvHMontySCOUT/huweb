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
           [:h1 "This is the about page"]))

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
