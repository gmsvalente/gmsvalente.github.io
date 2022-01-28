(ns site.components.headers
  (:require [re-frame.core :as rf]
            [reagent-mui.styles :as styles]
            [reagent-mui.material.app-bar :refer [app-bar]]
            [reagent-mui.material.toolbar :refer [toolbar]]
            [reagent-mui.material.typography :refer [typography]]
            [reagent-mui.icons.palette :refer [palette]]
            [reagent-mui.icons.dark-mode :refer [dark-mode]]
            [reagent-mui.icons.light-mode :refer [light-mode]]
            [reagent-mui.material.icon-button :refer [icon-button]]
            [site.components.color-menu :refer [color-box]]))

(defn custom-styles [{:keys [theme]}]
  (let [text-shadow (get-in theme [:palette :primary :A100])
        primary (get-in theme [:palette :text :primary])]
    {".header" {:justify-content "space-between"
                :align-items "center"}
     ".header-title" {:font-family "Orbitron"
                      :font-size "30px"
                      :color primary
                      :text-shadow (str "1px 2px " text-shadow)
                      "@media screen and (max-width: 600px)"
                      {:font-size "24px"}}}))


(defn header* [{:keys [class-name]}]
  (let [mode @(rf/subscribe [:get-mode])
        mode-icon (if (= "dark" mode) light-mode dark-mode)]
    [:div {:class class-name}
     [app-bar {:position "sticky"}
      [toolbar {:class "header"}
       [typography {:class "header-title"} "GV's space"]
       [:div {:class class-name}
        [icon-button {:on-click #(rf/dispatch [:toggle-color-menu])}
         [palette]]
        [icon-button {:on-click #(rf/dispatch [:change-mode])}
         [mode-icon]]]]]
     [color-box]]))

(def header (styles/styled header* custom-styles))
