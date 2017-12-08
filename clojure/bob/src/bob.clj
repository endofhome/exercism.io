(ns bob)

(defn response-for [sentence]
  (if (= sentence "WATCH OUT!")
    "Whoa, chill out!"
    "Whatever.")
)
