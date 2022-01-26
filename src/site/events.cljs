(ns site.events
  (:require [re-frame.core :as rf]
            [reagent-mui.colors :as colors]))

(rf/reg-event-db
 :init-db
 (fn []
   {:theme {:palette {:primary colors/blue
                      :secondary colors/orange
                      :mode "light"}}
    :show-modal-colors? false}))

(rf/reg-event-fx
 :change-mode
 (fn [{:keys [db]} _]
   (let [mode (get-in db [:theme :palette :mode])
         new-mode (if (= "dark" mode) "light" "dark")]
     {:db (assoc-in db [:theme :palette :mode] new-mode )})))


(rf/reg-event-fx
 :modal-colors
 (fn [{:keys [db]}]
   {:db (update db :show-modal-colors? not)}))

(rf/reg-event-db
 :close-modal
 (fn [db _]
   (assoc db :show-modal-colors? false)))

(rf/reg-sub
 :show-modal
 (fn [db]
   (:show-modal-colors? db)))

(rf/reg-sub
 :get-mode
 (fn [db _]
   (-> db :theme :palette :mode)))

(rf/reg-sub
 :get-theme
 (fn [db _]
   (:theme db)))

(rf/reg-sub
 :get-contrast-text
 (fn [db _]
   (-> db :theme :palette :primary :contrast-text)))
