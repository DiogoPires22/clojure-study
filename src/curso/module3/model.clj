(ns curso.module3.model)

(def empty-list clojure.lang.PersistentQueue/EMPTY)

(defn create-hospital
  []
  {:waiting empty-list
   :lab1 empty-list
   :lab2 empty-list
   :lab3 empty-list})