(ns site.components.headers
  (:require [re-frame.core :as rf]
            [reagent-mui.styles :as styles]
            [reagent-mui.material.app-bar :refer [app-bar]]
            [reagent-mui.material.toolbar :refer [toolbar]]
            [reagent-mui.material.typography :refer [typography]]
            [site.components.buttons :refer [control-btn]]))

(defn header-style [{:keys [theme]}]
  {".header" {:justify-content "space-between"
              :align-items "center"}
   ".header-title" {:font-family "Orbitron"
                    :font-size "30px"
                    :color (get-in theme [:palette :text :primary])
                    :text-shadow (str "1px 2px " (get-in theme [:palette :primary :A100]))
                    "@media screen and (max-width: 600px)"
                    {:font-size "24px"}}})

(defn header* [{:keys [class-name]}]
  [:div {:class class-name}
   [app-bar {:position "sticky"}
    [toolbar {:class "header"}
     [typography {:class "header-title"} "GV's space"]
     [control-btn]]]])

(def header (styles/styled header* header-style))
