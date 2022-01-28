(ns site.components.buttons
  (:require [reagent-mui.styles :as styles]
            [reagent-mui.material.button :refer [button]]
            [reagent-mui.material.box :refer [box]]
            [re-frame.core :as rf]))

(defn button-style [{:keys [theme]}]
  {".icon" {:color (-> theme :palette :text :primary)}
   ".color-box" {:display "flex"
                 :flex-direction "row"}})



(defn color-button* [{:keys [class-name]}]
  [:div {:class class-name}
   [box {:class "color-box"}
    [button {:on-click #(rf/dispatch [:close-modal])} "Cancel"]
    [button "Set"]]])

(def color-button (styles/styled color-button* button-style))


