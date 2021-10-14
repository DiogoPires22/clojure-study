(ns curso.module3.logic
  (:use [clojure.pprint]))

(defn available-allocation?
  [hospital queue-key]
  (-> hospital
      (get queue-key)
      (count)
      (< 6)))

(defn add-in-queue
  [hospital queue-key user-id]
  (if (available-allocation? hospital queue-key)
    (update hospital queue-key conj user-id)
    (throw (ex-info "queue is full" {:queue queue-key :user user-id}))))


;Its a mad function because there's a rand and its alter the state of sleep
(defn delayed-add-in-queue
  [hospital queue-key user-id]
  (if (available-allocation? hospital queue-key)
    (do
      (Thread/sleep (* (rand) 1000))
      (update hospital queue-key conj user-id))
    (throw (ex-info "queue is full" {:queue queue-key :user user-id}))))

(defn start-treatment
  [hospital queue]
  (update hospital queue pop))

(defn complete-start-treatment
  "horrible name rsrsrs"
  [hospital queue]
  {:user  (peek (get hospital queue))
   :hospital (update hospital queue pop)})


(defn start-treatment-with-juxt
  "horrible name rsrsrs"
  [hospital queue-id]
  (let [queue (get hospital queue-id)
        peek-pop (juxt peek pop)
        [user updated-queue] (peek-pop queue)
        updated-hospital (assoc hospital queue-id updated-queue)]
    {:user  user
     :hospital updated-hospital}))

(defn get-next
  "get the next "
  [hospital queue]
  (-> hospital
      (queue)
      peek))

(defn transfer
  [hospital from to]
  (let [people (get-next hospital from)]
    (-> hospital
        (start-treatment-with-juxt from)
        (:hospital)
        (add-in-queue to people))))
