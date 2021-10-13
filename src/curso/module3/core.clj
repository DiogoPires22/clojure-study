(ns curso.module3.core
  [:use clojure.pprint])


(defn print-vector
  []
  (let [items ["111" "222"]]
  (println "vector")
  (println items)
  (println (conj items "333"))
  (println (pop items))))

(print-vector)


(defn print-list
  []
  (let [items '( "111" "222" )]
    (println "list")
    (println items)
    (println (conj items "333"))
    (println (pop items))))

(print-list)

(defn print-set
  []
  (let [items #{ "111" "222" }]
    (println "set")
    (pprint items)
    (pprint (conj items "333"))
    (pprint (pop items))))

(defn print-queue
  []
  (let [espera (conj clojure.lang.PersistentQueue/EMPTY "111" "222")]
    (println "fila")
    (println (seq espera))
    (println (seq (conj espera "333")))
    (println (seq (pop espera)))
    (println (peek espera))
    (pprint espera)))

(print-queue)
