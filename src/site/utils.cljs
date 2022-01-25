(ns site.utils)

(defn ->prefix [cls]
  (let [prefix "custom-mui"]
    (str prefix cls)))

(defn ->& [classes res cls style]
  (let [k (str "& ." (get classes cls))]
    (assoc res k style)))
