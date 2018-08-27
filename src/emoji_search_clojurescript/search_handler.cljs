(ns emoji-search-clojurescript.search-handler
  (:require [emoji-search-clojurescript.state :as st]))

(defn keyword-search-helper [filter-term emoji]
  (if (not (or (= filter-term "") (= filter-term " ")))
    (.includes (.toLowerCase (get emoji :keywords)) filter-term)))

(defn search-title-and-keywords [filter-term emoji]
  (let [keyword-results (keyword-search-helper filter-term emoji)
        title-results (.includes (.toLowerCase (get emoji :title)) filter-term)]
    (if title-results
      title-results
      keyword-results)))

(defn search-handler []
  [:input.input.is-medium.is-success
   {
    :type "text"
    :placeholder "Search Emoji"
    :on-change (fn [e]
                 (let [filter-term (reset! st/search-term (.. e -target -value))
                       emoji-state @st/emojis]
                   (reset! st/filtered-emojis
                           (filter (partial search-title-and-keywords filter-term) emoji-state))))}])
