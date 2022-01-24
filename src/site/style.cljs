(ns site.style
  (:require [site.utils :refer [->prefix ->&]]))

(def classes
  {:root (->prefix "-root")
   :header-title (->prefix "-header-title")
   :menu-btn (->prefix "-menu-btn")
   :content (->prefix "-content")
   :app-bar (->prefix "-app-bar")})

(defn custom-styles [{:keys [theme]}]
  (let [result {}
        spc (:spacing theme)
        ->& (partial ->& classes)]
    (-> result 
        (->& :root {:margin 0})
        (->& :app-bar {:position "relative"})
        (->& :menu-btn {:color "inherit"})
        (->& :header-title {:letter-spacing (spc 2)
                            :font-family "Orbitron"
                            "&:hover" {:letter-spacing (spc 1)}})
        (->& :content {:background-color "cyan"
                       :margin-top "44px"}))))
