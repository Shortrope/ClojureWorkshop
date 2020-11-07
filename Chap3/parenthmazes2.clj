;; old weapon damage hashmap
;(def weapon-damage {
    ;:fists 10, 
    ;:staff 35, 
    ;:sword 100, 
    ;:saucepan 150
;})

;; New weapon-damage dispatch table: table of pointers to functions
;; allows each weapon to have different behavior
(def weapon-fn-map 
    {
        :fists (fn [health] (if (< health 100) (- health 10) health)) 
        :staff (partial + 35)
        :sword #(- % 100)
        :saucepan #(- % 100 (rand-int 50))
    })
