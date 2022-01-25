(ns site.events
  (:require [re-frame.core :as rf]
            [reagent-mui.colors :as colors]))

(rf/reg-event-db
 :init-db
 (fn []
   {:theme {:palette {:primary colors/blue
                      :secondary colors/orange}}}))

(rf/reg-sub
 :get-mode
 (fn [db _]
   (-> db :theme :palette :mode)))

(rf/reg-sub
 :get-theme
 (fn [db _]
   (:theme db)))
