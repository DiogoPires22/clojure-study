(ns curso.module1.class6)
;keyword
; :key-word

(def estoque { :mochila 10
              :camisetas 5})

(println "Temos" (count estoque) "elementos")

(println "As chaves são" (keys estoque))

(println "Os valores são" (vals estoque))

;add new value in estoque

(def estoque (assoc estoque  :cadeira 3))

(println "As chaves são" (keys estoque))

;update a collection
(def estoque (update estoque :mochila #(- % 3)))

(println estoque)

(def order {:backpack {:count 1 :value 40}
            :tshirt   {:count 2 :value 250}})

(def order (assoc order :tenis {:count 1 :value 25}))

(println order)


;; ways to access a keyword

(println (get order :tenis))
(println (:tenis order))

(-> order
    :backpack
    :count
    println "asdasdas" ,,,)