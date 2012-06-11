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
               [:div#menu
                (link-to "/home" "Home")
                (link-to "/download" "Download")
                (link-to "/feedback" "Feedback")
                (link-to "/issues" "Issues")
                (link-to "/about" "About")
                ]
                
               [:div#wrapper
                content]]))
