(ns emoji-search-clojurescript.display-emojis
  (:require [emoji-search-clojurescript.state :as st]))

(defn display-emojis []
  [:div.content
   [:table.table
    [:tbody
     (for [emoji (take 25  @st/filtered-emojis)]
       (let [title (get emoji :title)
             symbol (get emoji :symbol)
             title-id (str "emoji-title-" title)]
        ^{:key title}
        [:tr [:td
              [:a
               ;;{:on-click (fn [e]
               ;;                 (prn (. js/document (.getElementById js/document (str "emoji-title-" (get emoji :title))))))}
                [:div.columns [:div.column
                              [:figure {:class "image is-32x32"}
                              [:img
                                {:src (str "//cdn.jsdelivr.net/emojione/assets/png/"
                                          (.toString (.codePointAt symbol 0) 16) ".png")}]]]
                 [:div.column [:p {:id title-id } title]]]]]]))]]])
