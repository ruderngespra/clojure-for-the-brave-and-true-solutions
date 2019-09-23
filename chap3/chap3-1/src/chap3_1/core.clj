(ns chap3-1.core)

;;; Basic str examples:
(str)
(str 1 2 3)
(str [1 2 3])
(apply str [1 2 3])

;;; Destructuring of strings:
(let [[first & remaining] "Hello"]
  remaining
  )

;;; basic vector examples:
(vector)
[]
(vector 1 2 3)
(class (vector 1 2 3))

;;; basic hash-map examples:
(hash-map)
{}
{:key1 2} 
(into {:key2 4} {:key1 2})

;;; Only with the hash-map keyword can you reassign the same keyname:
(hash-map :key1 1 :key3 4 :key1 2)
;;; => {:key3 4, :key1 2}

;;; Build a hash-map out of a string via seq.
(map #(hash-map % 0) (seq "abcdefgh"))
;;;({\a 0} {\b 0} {\c 0} {\d 0} {\e 0} {\f 0} {\g 0} {\h 0}) 
(apply hash-map (.split "a 1 b 2 c 3" " "))
;;;{"a" "1", "b" "2", "c" "3"}

;;; basic hash-set examples:
(hash-set 1 2 3 5 324 5 2)
;;; #{1 3 2 5 324}
(apply hash-set "Lorem ipsum dolor sit amet")
;;; #{\space \a \d \e \i \L \l \m \o \p \r \s \t \u}
