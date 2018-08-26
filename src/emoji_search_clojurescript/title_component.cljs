(ns emoji-search-clojurescript.title-component
  (:require [emoji-search-clojurescript.state :as st]))

(defn title-component []
  (let [start (get (nth @st/emojis (rand-int (count @st/emojis))) :symbol)
        end (get (nth @st/emojis (rand-int (count @st/emojis))) :symbol)]
    [:h1.title (str start " Emoji Search " end)]))
