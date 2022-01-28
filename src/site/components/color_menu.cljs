(ns site.components.color-menu
  (:require [re-frame.core :as rf]
            [reagent.core :as r]
            [reagent-mui.styles :as styles]
            [reagent-mui.material.box :refer [box]]
            [reagent-mui.material.tooltip :refer [tooltip]]
            [reagent-mui.material.paper :refer [paper]]
            ["@mui/material" :refer [colors]]))

(def all-colors
  (remove
   (fn [[k _]] (= k :common))
   (js->clj colors :keywordize-keys true)))


(defn custom-styles [{:keys [theme]}]
  {".color-box" {:float "right"
                 :position "absolute"
                 :right "5px"
                 :background "snow"
                 :box-shadow "0px 0px 13px black"
                 :width "300px"
                 :overflow "hidden"
                 :transition-property "height"
                 "@media screen and (max-width: 600px)"
                 {:margin-right 0}}
   ".colors" {:width "100px"}
   ".color-display" {:padding "10px"
                     :display "flex"
                     :justify-content "space-around"
                     :flex-direction "row"}
   ".color-button" {:width "25px"
                    :height "25px"
                    :border-radius "5px"}
   ".selected-color-box" {:box-shadow "0px 0px 2px black"
                          :width "100px"
                          :height "100px"}})

(defn selected-color-paper []
  (let [color @(rf/subscribe [:selected-color])]
    [:div {:class "selected-color-box"
           :style {:background-color (:500 color)}}]))

(defn color-button [[name color]]
  [tooltip {:title name}
   [:button {:class "color-button"
             :on-mouse-over #(rf/dispatch [:select-color color])
             :on-mouse-leave #(rf/dispatch [:unselect-color])
             :style {:background-color (:500 color)}}]])

(defn color-box* [{:keys [class-name]}]
  (let [height (str @(rf/subscribe [:color-menu-height]) "px")]
    [:div {:class class-name}
     [:div {:class "color-box"
            :style {:transition-duration "501ms"
                    :transition-timing-function "cubic-bezier(0.68, -0.55, 0.265, 1.55)"
                    :height height}}
      [:div {:class "color-display"}
       [:div {:class "colors"}
        (for [color all-colors]
          ^{:key (color 0)} [color-button color])]
       [:div {:class "selected-color-box"}
        [selected-color-paper]]]]]))

(def color-box (styles/styled color-box* custom-styles))
