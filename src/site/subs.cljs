(ns site.subs
  (:require [re-frame.core :as rf]))

;;; dark mode

(rf/reg-sub
 :get-mode
 (fn [db _]
   (-> db :theme :palette :mode)))

;;; color picker

(rf/reg-sub
 :color-menu-height
 (fn [db]
   (-> db :color-menu :height)))

(rf/reg-sub
 :selected-color
 (fn [db]
   (-> db :color-menu :selected)))

(rf/reg-sub
 :get-theme
 (fn [db]
   (:theme db)))

(rf/reg-sub
 :get-contrast-text
 (fn [db]
   (-> db :theme :palette :primary :contrast-text)))
