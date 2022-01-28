(ns site.events
  (:require [re-frame.core :as rf]
            [site.theme :refer [custom-theme]]))

;;; initial db

(rf/reg-event-db
 :init-db
 (fn []
   {:theme custom-theme
    :color-menu {:height 0
                 :selected "none"}
    :current-color nil}))

;;; dark mode

(rf/reg-event-fx
 :change-mode
 (fn [{:keys [db]} _]
   (let [mode (get-in db [:theme :palette :mode])
         new-mode (if (= "dark" mode) "light" "dark")]
     {:db (assoc-in db [:theme :palette :mode] new-mode )})))


;;; color-picker

(rf/reg-event-fx
 :toggle-color-menu
 (fn [{:keys [db]} _]
   (let [height (get-in db [:color-menu :height])
         new-height (if (zero? height) 250 0)
         primary-color (get-in db [:theme :palette :primary])
         secondary-color (get-in db [:theme :palette :secondary])]
     {:db (-> db
              (assoc-in [:color-menu :height] new-height)
              (assoc :current-color {:primary primary-color
                                     :secondary secondary-color}))})))

(rf/reg-event-db
 :select-color
 (fn [db [_ color]]
   (-> db
       (assoc-in [:color-menu :selected] color)
       (assoc-in [:theme :palette :primary] color))))

(rf/reg-event-db
 :unselect-color
 (fn [db _]
   (let [pcolor (-> db :current-color :primary)
         scolor (-> db :current-color :secondary)]
     (-> db
         (assoc-in [:theme :palette :primary] pcolor)
         (assoc-in [:theme :palette :secondary] scolor)))))

(rf/reg-event-db
 :close-color-picker
 (fn [db _]
   (assoc-in db [:color-picker :height] 0)))

