(ns curso.module2.class5
  ( :require
    [curso.module2.db :as c.db]
    [curso.module2.logic :as c.logic]))


(defn heavy-expender?
  [user-info]
  (> (:total-expense user-info) 1000))


(let [orders (c.db/all-orders)
      summary (c.logic/resume-by-user orders)]
  (println "keep" (keep heavy-expender? summary))
  (println "filter" (filter heavy-expender? summary)))

; LAZY!!!!
(let [seq (range 10000)]
  (println (take 2 seq))
  (println (take 2 seq)))


(defn filter
  [tag, el]
  (println tag el)
  el)

(defn filter1
  [el]
  (filter "filter1" el))

(defn filter2
  [el]
  (filter "filter2" el))



(println  "------------------- vector ----------------------")


(->>  [ 1 2 3 4 5 6 7 8 9 0 1 2 3 45 5 6 7 8 9 0 1 2 3 4 5 1 2 3 4 5 6 7 8 9 0 1 2 3 45 5 6 7 8 9 0 1 2 3 4 5  ]
      (map filter1)
      (map filter2)
      println)


(println  "------------------ lista ligada ----------------------")

; lista ligada 100% lazy
(->>  '(1 2 3 4 5 6 7 8 9 0 1 2 3 45 5 6 7 8 9 0 1 2 3 4 5 1 2 3 4 5 6 7 8 9 0 1 2 3 45 5 6 7 8 9 0 1 2 3 4 5 )
      (map filter1)
      (map filter2)
      println)
