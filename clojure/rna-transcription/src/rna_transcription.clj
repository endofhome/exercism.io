(ns rna-transcription
  (:require [clojure.string :as str]))

(def dna-to-rna-mappings {:c "G"
                          :g "C"
                          :a "U"
                          :t "A"})

(defn to-rna [dna]
  (let [lower-case-dna (map #(str/lower-case %) dna)
        keywords (map #(keyword %) lower-case-dna)]
  (str/join(map #(dna-to-rna-mappings %) keywords))))
