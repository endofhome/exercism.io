(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (cond
    (empty? s) ""
    :else s)
  )

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  )