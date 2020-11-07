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
        :potatoe identity
    })

(defn strike 
    ([target] (strike target :fists))
    ([target weapon]
        ;(let [newhealth ((weapon-fn-map weapon) (:health target))]
            ;(assoc target :heath newhealth))))
        (let [weapon-fn (weapon weapon-fn-map)]
            (update target :health weapon-fn))))

(def ally {
    :name "Carla" 
    :health 80 
    :camp :gnomes
})
(def enemy {
    :name "Zulkaz" 
    :health 250 
    :armor 0.8 
    :camp :trolls
})

(strike ally)
(strike ally :fists)
(strike ally :staff)
(strike ally :sword)
(strike ally :saucepan)
(strike ally :potatoe)
(strike enemy)
(strike enemy :fists)
(strike enemy :staff)
(strike enemy :sword)
(strike enemy :saucepan)
(strike enemy :potatoe)
