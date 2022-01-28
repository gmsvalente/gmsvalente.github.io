(ns site.theme
  (:require [re-frame.core :as rf]
            [reagent-mui.styles :as styles]
            [reagent-mui.material.css-baseline :refer [css-baseline]]
            [reagent-mui.colors :as colors]
            [site.subs]))

(def custom-theme
  {:palette {:primary colors/red
             :secondary colors/blue
             :mode "light"}
   :typography {:font-family "Orbitron"}})

(defn with-theme [& children]
  (let [theme (rf/subscribe [:get-theme])]
    [styles/theme-provider (styles/create-theme @theme)
     [css-baseline]
     (into [:<>] children)]))

