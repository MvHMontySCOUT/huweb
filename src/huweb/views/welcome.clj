(ns huweb.views.welcome
  (:require [huweb.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]))

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
           [:p "Welcome to huweb"]))