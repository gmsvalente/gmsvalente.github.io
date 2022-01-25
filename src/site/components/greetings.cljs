(ns site.components.greetings
  (:require [reagent-mui.styles :as styles]
            [reagent-mui.material.typography :refer [typography]]
            [reagent-mui.material.box :refer [box]]
            [reagent-mui.material.paper :refer [paper]]))

(defn greetings-style [{:keys [theme]}]
  (let [box-color (get-in theme [:palette :primary 200])]
    {".greeting-box" {:background-color box-color
                      :padding "32px"}
     ".greeting-paper" {:margin "28px"
                        :padding "12px"
                        :transition {:width "2s"
                                     :height "1s"}}
     ".greeting-text" {:font-family "Orbitron"
                       :margin "21px"
                       :text-align "center"
                       :font-size "28px"
                       "@media screen and (max-width: 960px)"
                       {:font-size "22px"}
                       "@media screen and (max-width: 600px)"
                       {:font-size "12px"}}}))

(defn greetings* [{:keys [class-name]}]
  [:div {:class class-name}
   [box {:class "greeting-box"}
    [paper {:class "greeting-paper"
            :elevation 7}
     [typography {:class "greeting-text"}
      "Hi! My name is Gustavo and this is my space on Github!"]]]])

(def greetings (styles/styled greetings* greetings-style))
