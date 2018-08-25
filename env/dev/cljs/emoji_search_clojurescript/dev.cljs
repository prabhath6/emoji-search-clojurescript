(ns ^:figwheel-no-load emoji-search-clojurescript.dev
  (:require
    [emoji-search-clojurescript.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
