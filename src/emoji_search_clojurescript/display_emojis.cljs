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
               [:div.columns [:div.column
                              [:a
                               {:on-click (fn []
                                            (let [textInput (js/document.createElement "textarea")] ; create
                                              (set! (.-style textInput) #js {:display "none"})
                                              (set! (.-innerHTML textInput) (get emoji :symbol))
                                              (js/document.body.appendChild textInput) ; add to body
                                              (.select textInput)
                                              (.execCommand js/document "copy")
                                              (js/window.document.body.removeChild textInput)))}
                               [:figure {:class "image is-32x32"}
                                [:img
                                 {:src (str "//cdn.jsdelivr.net/emojione/assets/png/"
                                            (.toString (.codePointAt symbol 0) 16) ".png")}]]]]
                [:div.column [:p {:id title-id} title]]]]]))]]])
