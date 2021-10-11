(ns curso.module2.class2)

(def names-collection [ "daniela" "two" "ronaldo"])

(defn count-elements
  ( [elements] (count-elements 0 elements))
  ( [total s]
  (if (seq s)
      (recur (inc total) (next s))
      total)))

(println
  (count-elements names-collection))

(defn count-elements-with-loop
   [elements]
   (loop [ total 0
           elements elements]
     (if (seq elements)
       (recur (inc total)(next elements))
       total)))

(println
  (count-elements-with-loop names-collection))