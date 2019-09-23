(ns chap3-3.core)

(defn dec-maker
  "Create a custom decrementor"
  [num]
  (let [dec-number num]
    (fn [num]
      (- num dec-number))))
