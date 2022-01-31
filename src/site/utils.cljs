(ns site.utils)

(defn with-class-name [class-name & children]
  (into [:div {:class class-name}] children))

(defn handle-intersect [entries observer]
  (.. entries
      (forEach
       (fn [entry]
         (let [is-intersecting? (.-isIntersecting entry)
               tgt (.-target entry)]
           (if is-intersecting?
             (do 
               (set! (.. tgt -style -opacity) 1.0)
               (set! (.. tgt -style -width) "95%"))
             (do 
               (set! (.. tgt -style -opacity) 0)
               (set! (.. tgt -style -width) "0px"))))))))

(defn create-observer [el]
  (let [options (clj->js {:root nil
                          :rootMargin "0px"
                          :threshold 0.2})
        observer (js/IntersectionObserver. handle-intersect options)]
    (.. observer (observe el))))
