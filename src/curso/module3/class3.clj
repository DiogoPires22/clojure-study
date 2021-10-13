(ns curso.module3.class3
  (:use [clojure.pprint])
  (:require [curso.module3.logic :as c.logic]
            [curso.module3.model :as c.model]))

;; GLOBAL - every thread have access with the default value of symbol (root binding) and could redefine the value  = mutable
;; (def nome "diogo")
;; (def nome "guilherme)

(let [name "diogo"]
  ;code 1
  ;code 2
  (println name)
  ;dont redefine the global symbol, here we are shadowing the symbol, creating a new local symbol
  (let [name "xurupita"]
    ;code3
    ;code4
    (println name))
  (println name))


(defn atom-test []
  (let [silveira-hospital (atom {:waiting c.model/empty-list})]
    (pprint @silveira-hospital)

    ;WRONG WAY TO CHANGE A ATOM CONTENT
    ;(assoc @silveira-hospital :lab1 c.model/empty-list)
    ;(pprint @silveira-hospital)

    ;THIS IS ONE WAY TO CHANGE A ATOM CONTENT USING THE swap! command doing a side effect
    (swap! silveira-hospital assoc :lab1 c.model/empty-list)
    (pprint @silveira-hospital)
    (swap! silveira-hospital assoc :lab2 c.model/empty-list)
    (pprint @silveira-hospital)

    ;; ADDING A USER IN WAITING QUEUE USING SWAP
    (swap! silveira-hospital update :waiting conj "123")
    (pprint @silveira-hospital)))

;(atom-test)

(defn add-in-waiting!
  [hospital user-id]
  (swap! hospital c.logic/delayed-add-in-queue :waiting user-id)
  (println "adding user" user-id "in waiting"))

(defn add-in-waiting-without-sleep!
  [hospital user-id]
  (swap! hospital c.logic/add-in-queue :waiting user-id)
  (println "adding user" user-id "in waiting"))

(defn simulate-a-parallel-day-with-atoms []
  (let [hospital (atom (c.model/create-hospital))]
    (.start (Thread. (fn [] (add-in-waiting-without-sleep! hospital "111"))))
    (.start (Thread. (fn [] (add-in-waiting-without-sleep! hospital "222"))))
    (.start (Thread. (fn [] (add-in-waiting-without-sleep! hospital "333"))))
    (.start (Thread. (fn [] (add-in-waiting-without-sleep! hospital "444"))))
    (.start (Thread. (fn [] (add-in-waiting-without-sleep! hospital "555"))))
    (.start (Thread. (fn [] (add-in-waiting-without-sleep! hospital "666"))))
    (.start (Thread. (fn [] (add-in-waiting-without-sleep! hospital "777"))))
    (.start (Thread. (fn [] (Thread/sleep 1000)
                       (pprint hospital))))))

(simulate-a-parallel-day-with-atoms)





