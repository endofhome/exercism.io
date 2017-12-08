(ns hello-world)

(def greeting "Hello, ")

(defn hello [& names]
  (if (empty? names)
    (str greeting "World!")
    (str greeting (first names) "!"))
)
