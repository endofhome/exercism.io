(ns bob
  (:require [clojure.string :as str]))

(defn response-for [sentence]
  (cond
    (empty? (str/trim sentence))
      "Fine. Be that way!"
    (and (= sentence (str/upper-case sentence)) (re-seq #"[a-z]+" (str/lower-case sentence)))
      "Whoa, chill out!"
    (= (str(last sentence)) "?")
      "Sure."
    :else
      "Whatever.")
)
