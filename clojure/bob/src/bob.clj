(ns bob)

(defn response-for [sentence]
  (if (= sentence (clojure.string/upper-case sentence))
    "Whoa, chill out!"
    "Whatever.")
)
