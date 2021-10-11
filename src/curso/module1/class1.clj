(ns curso.module1.class1)

(defn print-message []
  (println "---------------------")
  (println  "Bem vindo ao estoque!"))


(defn valor-descontado
  "retorna o valor descontado que é o 90% do valor"
  [valor-bruto]
  (* valor-bruto 0.9))


(defn valor-descontado
  "retorna o valor com desconto de 10%"
  [valor-bruto]
  (* valor-bruto (- 1 0.10)))


(defn valor-descontado
  "retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [desconto (/ 10 100)]
    (println desconto)
    (* valor-bruto (- 1 desconto))))


(defn valor-descontado
  "retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto         (* valor-bruto taxa-de-desconto)]
    (println "desconto de " desconto)
    (- valor-bruto desconto)))


(defn valor-descontado
  "Desconto de 10% se o valor for maior de 100 reais"
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto (* valor-bruto taxa-de-desconto)]
    (println "desconto de " desconto)
    (- valor-bruto desconto))

  (println)
  (valor-descontado 100))
