(ns huweb.models.issuetracker
  (:use clojure.java.io))

(defn writeissue! [issue]
  (with-open [wrtr (writer "issue.txt" :append true)]
    (.write wrtr (str "<div class='row'><p class='nospacing red'><b>issue:</b> " (issue :message) "</p> <b>From:</b> " (issue :name) " <a href='mailto:" (issue :mail) "'>" (issue :mail)"</a></div>\n"))))

(defn readissue! [file]
  (slurp file))
