(ns bob
  (:require [clojure.string :as str]))

(defn silence [sentence]
  (empty? (str/trim sentence)))

(defn shouting [sentence]
  (and (= sentence (str/upper-case sentence)) (re-seq #"[a-z]+" (str/lower-case sentence))))

(defn question [sentence]
  (= (str(last sentence)) "?"))

(defn response-for [sentence]
  (cond
    (silence sentence)
      "Fine. Be that way!"
    (shouting sentence)
      "Whoa, chill out!"
    (question sentence)
      "Sure."
    :else
      "Whatever.")
)