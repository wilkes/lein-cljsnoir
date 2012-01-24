(ns {{name}}.core
  (:use [clojure.browser.dom :only (append get-element element)])
  (:require [clojure.browser.repl :as repl]
            [goog.string :as gstring]
            [goog.fx.dom.FadeInAndShow :as FadeInAndShow]))

(defn ^:export main []
  (append (get-element :greet-box)
          (element [:div  {:id "greeting" :style "display:none"}
                    [:h1 "To unpathed waters, undreamed shores."]
                    [:h3 (gstring/unescapeEntities "&mdash; William Shakespeare")]]))
  (.play (goog.fx.dom.FadeInAndShow. (get-element :greeting) 5000)))

(defn ^:export repl [] (repl/connect "http://localhost:9000/repl"))
