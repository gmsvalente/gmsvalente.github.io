(ns site.components.headers
  (:require [reagent-mui.styles :as styles]
            [reagent-mui.material.app-bar :refer [app-bar]]
            [reagent-mui.material.toolbar :refer [toolbar]]
            [reagent-mui.material.typography :refer [typography]]))

(defn header-style [{:keys [theme]}]
  {".header-title" {:font-family "Orbitron"
                    :font-size "30px"
                    :text-shadow "1px 2px black"
                    "@media screen and (max-width: 600px)"
                    {:font-size "24px"}}})

(defn header* [{:keys [class-name]}]
  [:div {:class class-name}
   [app-bar {:position "sticky"}
    [toolbar 
     [typography {:class ["header-title"]} "GV's space"]]]])

(def header (styles/styled header* header-style))
