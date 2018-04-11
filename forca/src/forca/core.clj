(ns forca.core
  (:gen-class))

  (def total-de-vidas 6)

  (def palavra-secreta "mel")

  (def conjunto #{"l" "m" "a"})

  (defn perdeu [] (print "Voce perdeu") )

  (defn ganhou [] (print "Voce ganhou") )

  (defn letras-faltantes [palavra acertos] 
    (remove (fn [letra] (contains? acertos (str letra)) ) palavra))

  (defn acertou-palavra-toda? [palavra acertos] 
    (empty? (letras-faltantes palavra acertos)))

  (defn le-letra! []  (read-line) )

  (defn acertou? [chute palavra] (.contains palavra chute) )

  (defn converte[] (* 7 (Integer/parseInt (le-letra!) )))

  (defn imprime-forca[vidas palavra acertos]
    (println "Vidas" vidas)
    (doseq [letra(seq palavra)] 
      (if (contains? acertos(str letra))
      (println letra "") 
      (print "_" "")
    ))
    (println) )

  (defn jogo [vidas palavra acertos] 
    (imprime-forca vidas palavra acertos)
    (cond 
        (= vidas 0) (perdeu)
        (acertou-palavra-toda? palavra acertos) (ganhou)
        :else
        (let [chute (le-letra!)]
            (if (acertou? chute palavra)
                (do
                  (println "Acertou uma letra!")
                  (recur vidas palavra (conj acertos chute))
                )
                (do
                  (println "Errou a letra! ")
                  (recur (dec vidas) palavra acertos)
                )))))
  

  (defn avalia-chute [chute vidas palavra acertos] 
    (if (acertou? chute palavra)
      (jogo vidas palavra (conj acertos chute))
      (jogo (dec vidas) palavra acertos)  ))


  (defn fbn[posicao]
    (cond 
        (= posicao 0) posicao
        (= posicao 1) posicao  
        :else
          (+ (fbn (- posicao 1)) (fbn (- posicao 2)))))

  (defn fib[posicao]
    (loop [a 1 b 1 numero 2] 
      (if
        (= numero posicao) b
        (recur b (+ a b) (inc numero) ) )))

  (defn somar[n]
    (loop [a 1 soma 1] 
      (if
        (= a n) soma
        (recur (inc a ) (+ soma (inc a) ))) ))


  (defn teste[]
    (loop [x 1]
      (when (< x 5)
        (println "x=" x)
        (recur (inc x))))   )



(defn comeca-o-jogo [] (jogo total-de-vidas palavra-secreta #{}))

(defn -main [& args]
  (comeca-o-jogo))
