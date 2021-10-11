(ns curso.module2.logic)

(defn calculate-item-price
  [[_ item]]
  (*  (get item :price 0) (get item :count 0)))

(defn calculate-order-expense
  [order]
  (->> order
       (map calculate-item-price)
       (reduce +)))

(defn calculate-user-expense
  [orders]
  (->> orders
       (map :itens)
       (map calculate-order-expense)
       (reduce +)))

(defn get-user-info
  [[user-id orders]]
  {:user-id user-id
   :orders-count (count orders)
   :total-expense (calculate-user-expense orders)})

(defn resume-by-user
  [orders]
  (->> orders
       (group-by :user)
       (map get-user-info)))
