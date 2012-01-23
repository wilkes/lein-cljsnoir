(ns {{name}}.core
  (:require [clojure.browser.repl :as repl]))

(defn ^:export main []
  ;; main entry point
  )

(defn ^:export repl [] (repl/connect "http://localhost:9000/repl"))
