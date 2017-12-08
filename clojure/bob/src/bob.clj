(ns bob)

(defn response-for [sentence]
  (cond
    (= sentence (clojure.string/upper-case sentence))
      "Whoa, chill out!"
    (= (str(last sentence)) "?")
      "Sure."
    :else
      "Whatever.")
)
