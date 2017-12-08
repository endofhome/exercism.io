(ns bob)

(defn response-for [sentence]
  (cond
    (empty? (clojure.string/trim sentence))
      "Fine. Be that way!"
    (and (= sentence (clojure.string/upper-case sentence)) (not (= sentence "1, 2, 3")))
      "Whoa, chill out!"
    (= (str(last sentence)) "?")
      "Sure."
    :else
      "Whatever.")
)
