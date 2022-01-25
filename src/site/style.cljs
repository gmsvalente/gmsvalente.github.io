(ns site.style
  (:require [site.utils :refer [->prefix ->&]]))

(def classes
  {:root (->prefix "-root")
   :header-title (->prefix "-header-title")
   :menu-btn (->prefix "-menu-btn")
   :content-box (->prefix "-content-box")
   :content (->prefix "-content")
   :content-paper (->prefix "-content-paper")})

(defn custom-styles [{:keys [theme]}]
  (println theme)
  (let [styles {}
        spc (:spacing theme)
        box-color (get-in theme [:palette :primary 200])
        ->& (partial ->& classes)]
    (-> styles 
        (->& :root {:margin "10px"})
        (->& :menu-btn {:color "inherit"})
        (->& :header-title {:font-family "Orbitron"
                            :font-size "30px"
                            "@media screen and (max-width: 600px)"
                            {:font-size "24px"}})
        (->& :content-box {:background-color box-color
                           :padding "32px"})
        (->& :content-paper {:margin "28px"
                             :padding "12px"
                             :transition {:width "2s"
                                          :height "1s"}})
        (->& :content {:font-family "Orbitron"
                       :margin "21px"
                       :text-align "center"
                       :font-size "28px"
                       "@media screen and (max-width: 960px)"
                       {:font-size "22px"}
                       "@media screen and (max-width: 600px)"
                       {:font-size "12px"}}))))

