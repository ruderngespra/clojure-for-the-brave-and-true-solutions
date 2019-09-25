(ns chap3-4.core)

(defn mapset
  [map-function sequence]
  (apply sorted-set (map map-function sequence))
  )
