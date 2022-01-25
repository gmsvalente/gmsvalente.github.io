(ns site.components.contents
  (:require [site.style :refer [classes custom-styles]]
            [reagent-mui.styles :as styles]
            [reagent-mui.material.typography :refer [typography]]
            [reagent-mui.material.box :refer [box]]
            [reagent-mui.material.paper :refer [paper]]))

(defn content-page* [{:keys [class-name]}]
  [:div {:class class-name}
   [box {:class (:content-box classes)}
    [paper {:class (:content-paper classes)
            :elevation 7}
     [typography {:class (:content classes)}
      "Hi! My name is Gustavo and this is my space on Github!"]]]])

(def content-page (styles/styled content-page* custom-styles))
