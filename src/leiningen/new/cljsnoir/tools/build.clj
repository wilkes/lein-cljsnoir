(ns one.build
    "*** LIFTED FROM CLOJURESCRIPTONE ***
     Support for building deployment artifacts for a project."
  (:use [cljs.closure :only (build)]
        [one.config :only (cljs-build-opts production-js)])
  (:require [clojure.java.io :as io]))

(defn build-project
  [config]
  (build (:app-root config) (assoc (cljs-build-opts config)
                              :optimizations :advanced
                              :output-to (production-js config))))
