(ns emoji-search-clojurescript.made-with-bulma)

(defn made-with-bulma []
  [:footer.footer
   [:div.content.has-text-centered
    [:a {:href "https://bulma.io"}
     [:img {:src "img/made-with-bulma.png"
            :style {:width "128px" :height "24px"}}]]]])
