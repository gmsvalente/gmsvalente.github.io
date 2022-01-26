(ns site.components.modal-colors
  (:require [reagent-mui.material.modal :refer [modal]]
            [re-frame.core :as rf]
            [reagent-mui.styles :as styles]
            [site.components.buttons :refer [modal-color-button]]))

(defn modal-style [{:keys [theme]}]
  {".modal" {:width "500px"
             :height "500px"
             :border "2px solid yellow"
             :justify-contents "center"
             :align-items "center"
             :background-color "yellow"}})

(defn colors* [{:keys [class-name]}]
  [:div {:class [class-name]}
   [:div {:class "modal"}
    [:h1 "i am visible"]
    [modal-color-button]]])

(def colors (styles/styled colors* modal-style))

(defn modal-colors* [{:keys [class-name]}]
  (let [show-modal? (rf/subscribe [:show-modal])]
    [:div {:class class-name}
     [modal {:open @show-modal?
             :on-close #(rf/dispatch [:close-modal])}
      [colors]]]))

(def modal-colors (styles/styled modal-colors* modal-style))

