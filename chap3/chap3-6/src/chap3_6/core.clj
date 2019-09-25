(ns chap3-6.core)

;;; Env code customized for exercise:

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "eye" :size 1}
                             {:name "ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "shoulder" :size 3}
                             {:name "upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "kidney" :size 1}
                             {:name "hand" :size 2}
                             {:name "knee" :size 2}
                             {:name "thigh" :size 4}
                             {:name "leg" :size 3}
                             {:name "achilles" :size 1}
                             {:name "foot" :size 2}])

(defn all-parts
  [part amount]
  (reduce  (fn
             [total current]
             (conj total {:name (str (:name part) (+ 1 current))
                          :size (:size part)}))
           (vector)
           (range amount))
  )

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts amount]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                    (all-parts part amount)))))))
