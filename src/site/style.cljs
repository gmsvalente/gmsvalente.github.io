(ns site.style
  (:require [site.utils :refer [->prefix ->&]]))

(def classes
  {:root (->prefix "-root")
   :header-title (->prefix "-header-title")
   :menu-btn (->prefix "-menu-btn")
   :content (->prefix "-content")
   :content-paper (->prefix "-content-paper")})

(defn custom-styles [{:keys [theme]}]
  (let [styles {}
        spc (:spacing theme)
        ->& (partial ->& classes)]
    (-> styles 
        (->& :root {:margin "10px"})
        (->& :menu-btn {:color "inherit"})
        (->& :header-title {:font-family "Orbitron"})
        (->& :content-paper {:margin "18px"
                             :padding "12px"})
        (->& :content {:font-family "Orbitron"
                       :margin "21px"}))))
