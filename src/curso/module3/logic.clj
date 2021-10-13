(ns curso.module3.logic)


(defn add-in-queue
  [hospital queue user-id]
  (update hospital queue conj user-id))


(defn start-treatment
  [hospital queue]
  (update hospital queue pop))