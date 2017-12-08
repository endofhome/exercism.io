(ns bob)

(defn response-for [sentence]
  (cond
    (empty? (clojure.string/trim sentence))
      "Fine. Be that way!"
    (and (= sentence (clojure.string/upper-case sentence)) (re-seq #"[a-z]+" (clojure.string/lower-case sentence)))
      "Whoa, chill out!"
    (= (str(last sentence)) "?")
      "Sure."
    :else
      "Whatever.")
)
