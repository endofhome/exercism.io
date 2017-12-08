(ns bob)

(defn response-for [sentence]
  (cond
    (empty? sentence)
      "Fine. Be that way!"
    (= sentence (clojure.string/upper-case sentence))
      "Whoa, chill out!"
    (= (str(last sentence)) "?")
      "Sure."
    :else
      "Whatever.")
)
