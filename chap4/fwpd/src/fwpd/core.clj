(ns fwpd.core)

;;; Environment Code Higginbotham:

(def filename "suspects.csv")
(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

;;; My solution to exercise 1:

(defn turn-result-into-list-of-names
  [result]
  (reduce (fn [list-of-names current]
            (conj list-of-names (:name current)))
          ()
          result))

(def filtered-list (glitter-filter 3 (mapify (parse (slurp filename)))))
(turn-result-into-list-of-names filtered-list)
;; ("Carlisle Cullen" "Jacob Black" "Edward Cullen")

;;; My solution to exercise 2:

(defn append
  [list-of-suspects new-suspect]
  (concat list-of-suspects (list new-suspect)))

(append (turn-result-into-list-of-names filtered-list) "Janko Marklein" )
;; ("Carlisle Cullen" "Jacob Black" "Edward Cullen" "Janko Marklein")

;; (defn validate
;;   [conversions record]
;;   (reduce (fn
;;          [total record-item]
;;             (if (some (fn
;;                         [key-value-pair]
;;                         (println key-value-pair))
;;                       ))
;;          ))
;;   )


;; (map (fn
;;        [key-value-pair]
;;        (println key-value-pair))
;;      (first list-of-all-suspects))
     
;; (def validations {:name string?
;;                   :glitter-index integer?})

;; (defn get-all-keywords-in-map
;;   [sample-map]
;;   (map first sample-map))

;; (get-all-keywords-in-map list-of-all-suspects)
;; (first {:name "Edward Cullen", :glitter-index 10})
