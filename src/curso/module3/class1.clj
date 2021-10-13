(ns curso.module3.class1
  (:use clojure.pprint)
  (:require [curso.module3.model :as c.model]
            [curso.module3.logic :as c.logic]))

(defn simulate-a-day []
  (def hospital (c.model/create-hospital))
  (def hospital (c.logic/add-in-queue hospital :waiting "123"))
  (def hospital (c.logic/add-in-queue hospital :waiting "111"))
  (def hospital (c.logic/add-in-queue hospital :waiting "222"))
  (def hospital (c.logic/add-in-queue hospital :lab1 "444"))
  (def hospital (c.logic/add-in-queue hospital :lab3 "555"))
  (def hospital (c.logic/start-treatment hospital :waiting))
  (def hospital (c.logic/start-treatment hospital :lab1))

  (def hospital (c.logic/add-in-queue hospital :waiting "333"))
  (def hospital (c.logic/add-in-queue hospital :waiting "444"))
  (def hospital (c.logic/add-in-queue hospital :waiting "555"))
  (def hospital (c.logic/add-in-queue hospital :waiting "666"))
  (def hospital (c.logic/add-in-queue hospital :waiting "777"))
  (pprint hospital))

;;(simulate-a-day)

(defn add-in-waiting
  [hospital user-id]
  (c.logic/delayed-add-in-queue hospital :waiting user-id))


;; GLOBAL variable problems when sharing memory space in parallel code
(defn simulate-a-parallel-day []
  (def hospital (c.model/create-hospital))
  (.start (Thread. (fn [] (def hospital (add-in-waiting hospital "111")))))
  (.start (Thread. (fn [] (def hospital (add-in-waiting hospital "222")))))
  (.start (Thread. (fn [] (def hospital (add-in-waiting hospital "333")))))
  (.start (Thread. (fn [] (def hospital (add-in-waiting hospital "444")))))
  (.start (Thread. (fn [] (def hospital (add-in-waiting hospital "555")))))
  (.start (Thread. (fn [] (def hospital (add-in-waiting hospital "666")))))
  (.start (Thread. (fn [] (def hospital (add-in-waiting hospital "777")))))
  (.start (Thread. (fn [] (Thread/sleep 4000)
                           (pprint hospital)))))

(simulate-a-parallel-day)