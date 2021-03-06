(ns emoji-search-clojurescript.core
    (:require
     [reagent.core :as r]
     [emoji-search-clojurescript.display-emojis :as d]
     [emoji-search-clojurescript.search-handler :as sh]
     [emoji-search-clojurescript.state :as st]
     [emoji-search-clojurescript.title-component :as tc]
     [emoji-search-clojurescript.made-with-bulma :as mb]))

;; -------------------------
;; Views

(defn home-page []
  [:section.hero
   [:div.hero-body
    [:div.container.has-text-centered
     [tc/title-component]
     [sh/search-handler]
     [d/display-emojis]
     [mb/made-with-bulma]]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
