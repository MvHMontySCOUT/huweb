(ns huweb.models.issuetracker
  (:use clojure.java.io))

(defn writeissue! [issue]
 (with-open [wrtr (writer "test.txt" :append true)]
  (.write wrtr (str (apply str (interpose " " issue)) "\n"))))