(ns site.components.contents
  (:require [site.style :refer [classes custom-styles]]
            [reagent-mui.styles :as styles]
            [reagent-mui.material.typography :refer [typography]]
            [reagent-mui.material.box :refer [box]]
            [reagent-mui.material.paper :refer [paper]]))

(defn content-page* [{:keys [class-name]}]
  [box {:class class-name}
   [paper {:class (:content-paper classes)}
    [typography {:class (:content classes)
                 :variant "h6"}
     "Hi! My name is Gustavo and this is my Github Pages!"]]])

(def content-page (styles/styled content-page* custom-styles))
