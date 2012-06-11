(ns huweb.models.issuetracker)

(defn writeissue! [issue]
  (use 'clojure.java.io)
 (with-open [wrtr (writer "test.txt" :append true)]
  (.write wrtr "hoi")))