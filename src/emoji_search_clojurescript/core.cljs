(ns emoji-search-clojurescript.core
    (:require
      [reagent.core :as r]))

;; -------------------------
;; Views

(defn home-page []
  [:section.hero
   [:div.hero-body
    [:div.container.has-text-centered
     [:h1.title "🙂 Emoji Search 🔢"]
     [:div.content
      [:table
       [:tbody
        (for [i [1 2 3 4]]
          [:tr [:td i]])]]]]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
