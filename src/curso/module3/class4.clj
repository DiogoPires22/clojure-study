(ns curso.module3.class4
  (:use [clojure.pprint])
  (:require [curso.module3.logic :as c.logic]
            [curso.module3.model :as c.model]))

(defn add-in-waiting-without-sleep!
  [hospital user-id]
  (swap! hospital c.logic/add-in-queue :waiting user-id)
  (println "adding user" user-id "in waiting"))

(defn simulate-a-parallel-day-with-atoms-with-mapv
  "Using mapv to force imperative code"
  []
  (let [hospital (atom (c.model/create-hospital))
        users ["111", "222", "333", "444", "555", "666"]
        start-begin-thread #(.start (Thread. (fn [] (add-in-waiting-without-sleep! hospital %))))]
    (mapv start-begin-thread users)
    (.start (Thread. (fn [] (Thread/sleep 1000)
                       (pprint hospital))))))
;; CURRYING
(defn start-begin-thread-without-partial
  ([hospital] (fn
                [people]
                (start-begin-thread hospital people)))
  ([hospital people]
  (.start (Thread. (fn [] (add-in-waiting-without-sleep! hospital people))))))

(defn simulate-a-parallel-day-with-atoms-with-mapv-currying
  "USING MAPV WITH CURRYING"
  []
  (let [hospital (atom (c.model/create-hospital))
        users ["111", "222", "333", "444", "555", "666"]]
    (mapv (start-begin-thread-without-partial hospital) users)
    (.start (Thread. (fn [] (Thread/sleep 1000)
                       (pprint hospital))))))

;; WITH PARTIAL
(defn start-begin-thread
  ([hospital people]
   (.start (Thread. (fn [] (add-in-waiting-without-sleep! hospital people))))))

(defn simulate-a-parallel-day-with-atoms-with-mapv-partial
  "USING MAPV WITH CURRYING"
  []
  (let [hospital (atom (c.model/create-hospital))
        users ["111", "222", "333", "444", "555", "666"]
        start (partial start-begin-thread hospital)]
    (mapv start users)
    (.start (Thread. (fn [] (Thread/sleep 1000)
                       (pprint hospital))))))

(simulate-a-parallel-day-with-atoms-with-mapv-partial)





