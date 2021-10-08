(ns curso.module2.class-2)

(def names-collection [ "daniela" "two" "ronaldo"])

(defn count-elements
  ( [elements] (count-elements 0 elements))
  ( [total s]
  (if (seq s)
      (recur (inc total) (next s))
      total)))

(println
  (count-elements names-collection))