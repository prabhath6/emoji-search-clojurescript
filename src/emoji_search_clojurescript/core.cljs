(ns emoji-search-clojurescript.core
    (:require
     [reagent.core :as r]
     [emoji-search-clojurescript.state :as st]))

;; -------------------------
;; Views

(defn display-emojis []
  [:div.content
   [:table.table
    [:tbody
     (for [emoji (take 25 @st/emojis)]
       ^{:key (get emoji :title)}
       [:tr [:td
             [:div.columns [:div.column
              [:figure {:class "image is-32x32"}
               [:img {:src (str "//cdn.jsdelivr.net/emojione/assets/png/" (.toString (.codePointAt (get emoji :symbol) 0) 16) ".png")}]]]
              [:div.column (get emoji :title)]]]])]]])

(defn search-handler []
  [:input.input.is-medium.is-success
   {
    :type "text"
    :placeholder "Search Emoji"
    :on-change (fn [e]
                 (let [term-value (reset! st/search-term (.. e -target -value))]
                   (prn term-value)))}])

(defn home-page []
  [:section.hero
   [:div.hero-body
    [:div.container.has-text-centered
     [:h1.title "🙂 Emoji Search 🔢"] ;; should be a new component, and the two emojis should change randomly
     [search-handler]
     [display-emojis]]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
