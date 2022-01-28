(ns site.utils)

(defn with-class-name [class-name & children]
  (into [:div {:class class-name}] children))
