(ns site.theme
  (:require [reagent.core :as r]
            [reagent-mui.styles :as styles]
            [reagent-mui.colors :as colors]
            [reagent-mui.material.css-baseline :refer [css-baseline]]))

(def custom-theme
  (r/atom {:palette {:primary colors/blue
                     :secondary colors/orange}}))

(defn with-theme [theme & children]
  [styles/theme-provider (styles/create-theme @theme)
   [css-baseline]
   (into [:<>] children)])
