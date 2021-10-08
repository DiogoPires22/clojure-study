(ns curso.module1.aula7)

;; MAP AND REDUCE

(def order {:backpack {:count 1 :value 100}
            :tshirt {:count 2 :value 0}})

(defn total-order-item
  [order-item]
  (* (order-item :count ) (order-item :value)))

(defn order-total
  [order]
  (->> order
  (vals)
  ( map total-order-item)
  (reduce +)))

;; FILTER

(defn free?
  [item]
  (<= (get item :value) 0))

(def paid? (comp not free?))

(println "free" (filter #(free? (second %)) order))

(println "paid" (filter #(paid? (second %)) order))
