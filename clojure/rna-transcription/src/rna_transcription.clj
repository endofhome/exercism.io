(ns rna-transcription)

(defn to-rna [dna]
  (cond
    (= (str dna) "C") "G"
    (= (str dna) "G") "C")
)
