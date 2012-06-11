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
               [:title "huweb"]
               (include-css "/css/reset.css")
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
                content]]))
