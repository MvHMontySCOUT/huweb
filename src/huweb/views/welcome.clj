(ns huweb.views.welcome
  (:require [huweb.views.common :as common]
;            [huweb.views.issue :as issue]
            [noir.content.getting-started])
 ; (:use [noir.core :only [defpage]]))
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
           [:p "Welcome to huweb"]))

(defpage "/about" []
         (common/layout
           [:p "Welcome to huweb"]))

(defpage "/feedback" []
         (common/layout
           [:p "Welcome to huweb"]))

(defpage "/issues" []
(common/layout

(form-to [:post "/login"]
               (text-field "Username")
               (password-field "Password")
               (submit-button "Login"))))

(defpage "/download" []
         (common/layout
           [:p "Welcome to huweb"]))