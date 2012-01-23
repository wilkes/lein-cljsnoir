(ns {{name}}.prod-server
  (:require [noir.server :as server]))

(defn -main [& [p]]
  (let [port (or p 9090)]
    (server/start port {:mode :prod
                        :ns '{{name}}})))
