(ns site.core
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [goog.dom :as gdom]
            [site.theme :refer [with-theme]]
            [site.components.headers :refer [header]]
            [site.components.greetings :refer [greetings]]
            [site.events]
            [reagent-mui.material.paper :refer [paper]]))

(defn main []
  [with-theme
   [header]
   [greetings]
   [:div
    [paper {:style {:box-shadow "2px 2px 9px black"
                    :background-color "cyan"}}
     [:h1 "asod"]]]])

(defn ^:dev/after-load init []
  (rdom/render [main] (gdom/getElement "root")))

(defn launch []
  (rf/dispatch-sync [:init-db])
  (init))

