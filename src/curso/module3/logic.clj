(ns curso.module3.logic)

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
