(ns site.components.headers
  (:require [reagent-mui.styles :as styles]
            [reagent-mui.material.app-bar :refer [app-bar]]
            [reagent-mui.material.toolbar :refer [toolbar]]
            [reagent-mui.material.typography :refer [typography]]
            [site.style :refer [classes custom-styles]]))

(defn header-page* [{:keys [class-name]}]
  [app-bar {:class class-name
            :position "stick"}
   [toolbar {:class (:app-bar classes)}
    [typography {:class (:header-title classes)} "My GitPage"]]])

(def header-page (styles/styled header-page* custom-styles))
