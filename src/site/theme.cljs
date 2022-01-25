(ns site.theme
  (:require [reagent-mui.styles :as styles]
            [reagent-mui.material.css-baseline :refer [css-baseline]]
            [re-frame.core :as rf]
            [site.events]))

(def custom-theme
  (rf/subscribe [:get-theme]))

(defn with-theme [theme & children]
  [styles/theme-provider (styles/create-theme @theme)
   [css-baseline]
   (into [:<>] children)])
