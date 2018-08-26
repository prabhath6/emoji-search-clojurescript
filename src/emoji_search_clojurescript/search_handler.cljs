(ns emoji-search-clojurescript.search-handler
  (:require [emoji-search-clojurescript.state :as st]))

;;TODO: Update this filter to look into title too.
(defn filter-helper [filter-term emoji]
  (if (or (= filter-term "") (= filter-term " "))
    emoji
    (.includes (.toLowerCase (get emoji :keywords)) filter-term)))

(defn search-handler []
  [:input.input.is-medium.is-success
   {
    :type "text"
    :placeholder "Search Emoji"
    :on-change (fn [e]
                 (let [filter-term (reset! st/search-term (.. e -target -value))
                       emoji-state @st/emojis]
                   (reset! st/filtered-emojis
                           (filter (partial filter-helper filter-term) emoji-state))))}])
