(ns curso.module2.class3
  (:require [curso.module2.db :as c.db]
            [ curso.module2.logic :as c.logic]))

(->> (c.db/all-orders)
     (c.logic/resume-by-user)
       println)
