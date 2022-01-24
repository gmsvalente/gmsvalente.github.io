(ns site.components.contents
  (:require [reagent-mui.styles :as styles]
            [reagent-mui.material.typography :refer [typography]]
            [reagent-mui.material.box :refer [box]]
            [site.style :refer [classes custom-styles]]))

(defn content-page* [{:keys [class-name]}]
  [box {:class [class-name (:content classes)]}
   [typography "Hi test"]])


(def content-page (styles/styled content-page* custom-styles))
