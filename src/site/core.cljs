(ns site.core
  (:require [reagent.dom :as rdom]
            [goog.dom :as gdom]))

(defn git-page []
  [:div
   [:h1 "My GitPage"]
   [:hr]])

(defn ^:dev/after-load init []
  (rdom/render [git-page] (gdom/getElement "root")))

(defn launch []
  (init))

