(ns site.core
  (:require [reagent.dom :as rdom]
            [reagent.core :as r]
            [goog.dom :as gdom]
            [reagent-mui.styles :as styles]
            [reagent-mui.colors :as colors]
            [reagent-mui.material.css-baseline :refer [css-baseline]]
            [reagent-mui.material.app-bar :refer [app-bar]]
            [reagent-mui.material.toolbar :refer [toolbar]]
            [reagent-mui.material.typography :refer [typography]]))

(def custom-theme
  (r/atom {:palette {:primary colors/blue
                     :secondary colors/orange}}))

(def classes
  (let [prefix "rmui"]
    {:root (str prefix "-root")
     :header-title (str prefix "-header-title")
     :menu-btn (str prefix "-menu-btn")}))

(defn custom-styles [{:keys [theme]}]
  (let [spc (:spacing theme)]
    {(str "&." (:root classes)) {:margin 0}
     (str "&." (:menu-btn classes)) {:color "inherit"}
     (str "&." (:header-title classes)) {:spacing (spc 2)
                                         :font-family "Orbitron"}}))

(defn git-page_ []
  [:<>
   [styles/theme-provider (styles/create-theme @custom-theme)
    [css-baseline]
    [app-bar
     [toolbar
      [typography {:class-name "rmui-header-title"} "My GitPage"]]]]])

(def git-page (styles/styled git-page_ custom-styles))

(defn ^:dev/after-load init []
  (rdom/render [git-page] (gdom/getElement "root")))

(defn launch []
  (init))

