(ns run-length-encoding
  (:require [clojure.string :as str]))

(defn display [count]
  (cond
    (= 1 count) ""
    :else (str count)
    )
  )

(defn encode
  ([s] (encode s ""))
  ([s processed]
   (let [partitioned (partition-by #(= (first s) %) s)
         remainder (rest partitioned)
         times (display (count (first partitioned)))
         charToRepeat (first (first partitioned))
         encoded (str processed times charToRepeat)]
     (cond
       (and (not-empty (last partitioned)) (>= (count partitioned) 2))
            (encode (str/join (flatten (rest partitioned))) encoded)
       :else encoded
     ))
    )
  )

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (cond
    (empty? s) ""
    :else (encode s)
    )
  )

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  s
  )