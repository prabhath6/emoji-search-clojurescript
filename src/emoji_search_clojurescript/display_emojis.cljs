(ns emoji-search-clojurescript.display-emojis
  (:require [emoji-search-clojurescript.state :as st]))

(defn display-emojis []
  [:div.content
   [:table.table
    [:tbody
     (for [emoji (take 25  @st/filtered-emojis)]
       ^{:key (get emoji :title)}
       [:tr [:td
             [:div.columns [:div.column
                            [:figure {:class "image is-32x32"}
                             [:img {:src (str "//cdn.jsdelivr.net/emojione/assets/png/" (.toString (.codePointAt (get emoji :symbol) 0) 16) ".png")}]]]
              [:div.column (get emoji :title)]]]])]]])
