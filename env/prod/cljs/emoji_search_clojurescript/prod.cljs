(ns emoji-search-clojurescript.prod
  (:require
    [emoji-search-clojurescript.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
