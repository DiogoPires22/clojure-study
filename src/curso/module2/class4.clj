(ns curso.module2.class4
  ( :require
  [curso.module2.db :as c.db]
  [curso.module2.logic :as c.logic]))

(println (c.logic/resume-by-user (c.db/all-orders)))

(defn get-sorted-summary
  [orders]
  (let [ summary (c.logic/resume-by-user orders) ]
  (->> summary
       (sort-by :total-expense)
       (reverse))))


(let [orders (c.db/all-orders)
      summary (c.logic/resume-by-user orders)]
  (println "first element" (nth summary 1))
  (println "top2" (take 2 summary)))


(let [orders (c.db/all-orders)
      summary (get-sorted-summary orders)]
       (->> summary
         (some #(> (:total-expense %) 500))
         (println "expense > than 500")))
