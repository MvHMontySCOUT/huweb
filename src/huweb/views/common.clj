(ns huweb.views.common
  (:use [noir.core]
        [hiccup.page]
        [hiccup.middleware]
        [hiccup.util]
        [hiccup.def]
        [hiccup.core]
        [hiccup.compiler]
        [hiccup.element]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "husacct information"]
               (include-css "/css/static.css")]
              [:body
               [:div#wrapper
                [:div#menu
                (link-to {:class "menu"} "/home" "Home")
                (link-to {:class "menu"} "/download" "Download")
                (link-to {:class "menu"} "/feedback" "Feedback")
                (link-to {:class "menu"} "/issues" "Issues")
                (link-to {:class "menu"} "/about" "About")
                ]
                [:div#content content]
                [:div#footer
                [:div#left
                 [:p "Made possible by"]
                 [:ul [:li "Leo Pruijt"]
                  [:li "Christian Köppe"]
                  [:li "Michiel Borkent"]]]
                [:div#right
                 [:p "Site made by"]
                 [:ul [:li "Martin van Haeften"]
                  [:li "Jorik Kraaikamp"]]]]
                ]]))
