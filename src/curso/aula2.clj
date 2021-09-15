(ns curso.aula2)


(if (> 500 100)
  (println "maior")
  (println "menor ou igual"))


(defn valor-descontado
  "Retorna o com desconto de 10% se o valor bruto for maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (println "desconto de " desconto)
      (- valor-bruto desconto))
    valor-bruto))
