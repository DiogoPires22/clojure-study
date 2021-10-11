(ns curso.module1.class5)

(def precos [30 700 1000])

(println (precos 1))

(println (get precos 0))

(println (get precos 1))

; if not exists index return null
(println (get precos 17))
; default value if null
(println (get precos 17 0))

; persist a new value and return a new vector
(def newPrecos (conj precos 5))

(println newPrecos)


; update index 1 increasing 1
(println (update precos 0 inc))

; update index 1 decreasing 1
(println (update precos 1 dec))

(defn soma-1
  [valor]
  (println  "estou somando 1 em " valor)
  (+ valor 1))

(println (update precos 1 soma-1))

; código de aulas passadas

(defn aplica-desconto?
  [valor]
  (> valor 100))

(defn valor-descontado
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    ( let [taxa-de-juros (/ 10 100)
           desconto (* valor-bruto taxa-de-juros)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 100))

; MAP

(println (map valor-descontado precos))

; FILTER
(println (filter even? (range 10)))

(println
  (map valor-descontado
    (filter aplica-desconto? precos)))

; REDUCE

(println (reduce + precos))


(defn minha-soma
  [v1 v2]
  (+ v1  v2))

(println (reduce minha-soma precos))
(println (reduce minha-soma (range 10)))
(println (reduce minha-soma 0 [15]))
