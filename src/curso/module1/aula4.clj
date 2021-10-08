(ns curso.module1.aula4)
; HIGHER ORDER FUNCTIONS
; IMUTABILITY

(defn valor-maior-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o com desconto de 10% se o valor bruto for maior que 100"
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println "função como parametro")
(println (valor-descontado valor-maior-que-100? 100))
(println (valor-descontado valor-maior-que-100? 10000))


(def mais-caro-que-100? (fn [valor] (> valor 100)))
(println (valor-descontado mais-caro-que-100? 10000))

; NAMELESS FUNCTION
(println (valor-descontado (fn [v] (> v 100)) 10000))
(println (valor-descontado #(> %1 100) 10000))
(println (valor-descontado #(> % 100) 10000))