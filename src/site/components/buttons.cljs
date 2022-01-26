(ns site.components.buttons
  (:require [reagent-mui.styles :as styles]
            [reagent-mui.icons.palette :refer [palette]]
            [reagent-mui.icons.dark-mode :refer [dark-mode]]
            [reagent-mui.icons.light-mode :refer [light-mode]]
            [reagent-mui.material.icon-button :refer [icon-button]]
            [reagent-mui.material.button :refer [button]]
            [reagent-mui.material.box :refer [box]]
            [re-frame.core :as rf]))

(defn button-style [{:keys [theme]}]
  {".icon" {:color (-> theme :palette :text :primary)}
   ".modal-box" {:display "flex"
                 :flex-direction "row"}})

(defn control-btn* [{:keys [class-name]}]
  (let [mode @(rf/subscribe [:get-mode])
        mode-icon (if (= "dark" mode)  light-mode dark-mode)]
    [:div {:class class-name}
     [icon-button {:on-click #(rf/dispatch [:modal-colors])}
      [palette {:class "icon"}]]
     [icon-button {:on-click #(rf/dispatch [:change-mode])}
      [mode-icon {:class "icon"}]]]))

(def control-btn (styles/styled control-btn* button-style))


(defn modal-color-button* [{:keys [class-name]}]
  [:div {:class class-name}
   [box {:class "modal-box"}
    [button {:on-click #(rf/dispatch [:close-modal])} "Cancel"]
    [button "Set"]]])

(def modal-color-button (styles/styled modal-color-button* button-style))


