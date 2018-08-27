(ns emoji-search-clojurescript.search-handler
  (:require [emoji-search-clojurescript.state :as st]))

(defn search-helper [filter-term emoji param]
  (.includes (.toLowerCase (get emoji param)) filter-term))

(defn search-title-and-keywords [filter-term emoji]
  (let [keyword-results (search-helper filter-term emoji :keywords)
        title-results (search-helper filter-term emoji :title)]
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
