(ns site.components.headers
  (:require [reagent-mui.styles :as styles]
            [reagent-mui.material.app-bar :refer [app-bar]]
            [reagent-mui.material.toolbar :refer [toolbar]]
            [reagent-mui.material.typography :refer [typography]]
            [re-frame.core :as rf]))

(defn header-style [{:keys [theme]}]
  (println theme)
  (let [title-shadow @(rf/subscribe [:get-mode])]
    {".header-title" {:font-family "Orbitron"
                      :font-size "30px"
                      :text-shadow (str "1px 2px " (get-in theme [:palette :primary (keyword title-shadow)]))
                      "@media screen and (max-width: 600px)"
                      {:font-size "24px"}}}))

(defn header* [{:keys [class-name]}]
  [:div {:class class-name}
   [app-bar {:position "sticky"}
    [toolbar 
     [typography {:class ["header-title"]} "GV's space"]]]])

(def header (styles/styled header* header-style))
