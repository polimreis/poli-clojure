(ns cipher.core)

(defn g [x y]  (+ (* x 10) y))

(defn test-if [x y] (if (> x y) (- x y) 0 ))


(defn to-int
  "takes a lowercase letter character and returns its position in the alphabet: a = 0, b = 1, etc."
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))


(defn to-char
  "takes  the position in the alphabet and return a lowercase letter character"
  [position]
  (let [initial (int \a)]
    (char (+  initial  position ))))


(defn shift
  [c acresc]
  (to-char (mod (+ (to-int c) acresc ) 26))
  )


(defn encript-caesar
  [array-char acc]
  (apply str (mapv #(shift % acc ) array-char ))
  )

(defn decript-caesar
  [array-char acc]
  (apply str (mapv #(shift % (* -1 acc)) array-char))
  )




(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
