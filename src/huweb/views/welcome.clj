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
           [:p "Welcome to huweb"]))

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