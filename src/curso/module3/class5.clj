(ns curso.module3.class5
  (:use [clojure.pprint])
  (:require [curso.module3.logic :as c.logic]
            [curso.module3.model :as c.model]))

(defn transfer-user!
  [hospital from to]
  (swap! hospital c.logic/transfer from to))

(defn add-in!
  [hospital queue user-id]
  (println "adding user" user-id "in" queue)
  (swap! hospital c.logic/add-in-queue queue user-id))

(defn simulate-a-day
  []
  (let [hospital (atom (c.model/create-hospital))
        users ["diogo" "diguinho" "fabio" "vitor"]]
    (doseq [user users]
      (add-in! hospital :waiting user))
    (transfer-user! hospital :waiting :lab1)
    (transfer-user! hospital :waiting :lab2)
    (transfer-user! hospital :waiting :lab3)
    (pprint hospital)))

(simulate-a-day)
