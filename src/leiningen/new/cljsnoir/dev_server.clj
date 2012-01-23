(ns {{name}}.dev-server
  (:use [cljs.repl :only (repl)]
        [cljs.repl.browser :only (repl-env)]
        [noir.core :only (defpage)])
  (:require [noir.response :as response]
            [noir.server :as server]
            [one.reload :as reload]
            [{{name}}.config :as config]
            [{{name}}.application-host :as application-host]))

(server/add-middleware reload/watch-cljs config/config)
(server/add-middleware reload/reload-clj (:reload-clj config/config))

(defpage "/" [] (response/redirect "/development"))
(defpage "/development" [] (application-host/layout config/config :development))
(defpage "/production" [] (application-host/layout config/config :production))

(defn run-server [& [p]]
  (let [port (or p 8080)]
    (server/start port {:mode :dev
                        :ns '{{name}}})))

(defn cljs-repl
  "Start a ClojureScript REPL which can connect to the development
  version of the application. The REPL will not work until the
  development page connects to it, so you will need to either open or
  refresh the development page after calling this function."
  []
  (repl (repl-env)))
