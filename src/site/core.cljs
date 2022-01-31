(ns site.core
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [goog.dom :as gdom]
            [site.theme :refer [with-theme]]
            [site.components.headers :refer [header]]
            [site.components.greetings :refer [greetings]]
            [site.events]
            [reagent-mui.material.paper :refer [paper]]
            [reagent-mui.material.typography :refer [typography]]
            [reagent.core :as r]
            [site.utils :refer [create-observer]]
            [reagent-mui.styles :as styles]))


(defn custom-styles [{:keys [theme]}]
  (let [bg (-> theme :palette :primary :main)]
    {".dummy"  {:height "100px"
                :margin "13px auto"
                :background-color bg
                :box-shadow "1px 1px 3px black"
                :transition "opacity 900ms, width 900ms"
                :opacity 0
                :width 0}}))

(defn dummy-paper* [n]
  (r/create-class
   {:display-name (str "DummyPaper" n)
    :component-did-mount (fn [] (create-observer (gdom/getElement (str "slide" n))))
    :reagent-render 
    (fn [{:keys [class-name]}]
      [:div {:class class-name}
       [paper {:id (str "slide" n)
               :class "dummy" }
        [typography (str "Dummy Compo" n)]]])}))

(defn main []
  [with-theme
   [header]
   [greetings]
   (into 
    [:div]
    (for [i (range 10)]
      [(styles/styled (dummy-paper* i) custom-styles)]))])

(defn ^:dev/after-load init []
  (rdom/render [main] (gdom/getElement "root")))

(defn launch []
  (rf/dispatch-sync [:init-db])
  (init))

