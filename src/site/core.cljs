(ns site.core
  (:require [reagent.dom :as rdom]
            [goog.dom :as gdom]
            [site.theme :refer [custom-theme with-theme]]
            [site.components.headers :refer [header-page]]
            [site.components.contents :refer [content-page]]))

(defn main []
  [with-theme custom-theme
   [header-page]
   [content-page]])


(defn ^:dev/after-load init []
  (rdom/render [main] (gdom/getElement "root")))

(defn launch []
  (init))

