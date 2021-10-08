(ns curso.module2.class-1)

;["daniela" "guilherme" "carlos" "paulo"]
; { "guilherme" 32 "paulo" 21 }
; '(1 2 3 4 5)
; #{}

; map
; reduce
; filter

(def names-collection [ "daniela" "guilherme" "carlos" "paulo"])

(defn my-map
  [f s]
  (let [ele (first s)  rest-s (rest s) ]
    (f ele)
    (if (not ( empty? rest-s))
          (my-map f rest-s)
          nil)))

(defn my-map
  [f s]
  (let [ele (first s)]
    (if (not ( nil? ele))
      (do
        (f ele)
        (recur f (rest s))))))


(my-map println names-collection)
