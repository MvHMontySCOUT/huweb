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
               (include-css "/css/reset.css")]
              [:body
               [:div#menu
                [:p "test"]]
                (link-to "http://www.webnoir.org" "Noir")
               [:div#wrapper
                content]]))
