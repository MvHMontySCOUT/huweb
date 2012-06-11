(ns huweb.views.welcome
  (:require [huweb.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]))

(defpage "/Home" []
         (common/layout
           [:p "Welcome to huweb"]))

(defpage "/About" []
         (common/layout
           [:p "Welcome to huweb"]))

(defpage "/Feedback" []
         (common/layout
           [:p "Welcome to huweb"]))

(defpage "/issues" []
         (common/layout
           [:p "Welcome to huweb"]))

(defpage "/Download" []
         (common/layout
           [:p "Welcome to huweb"]))