(ns leiningen.new.cljsnoir
  (:use leiningen.new.templates)
  (:require [clojure.string :as string]))

(def render (renderer "cljsnoir"))

(defn cljsnoir
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)
              :capitalized (string/capitalize name)}]
    (->files data
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render "gitignore" data)]
             ["script/setup_classpath.sh" (render "script/setup_classpath.sh" data)]
             ["script/repl" (render "script/repl" data)]
             ["script/run" (render "script/run" data)]
             ["script/test" (render "script/test" data)]
             ["script/cljs-repl" (render "script/cljs-repl" data)]
             ["resources/public/css/bootstrap.css" (render "resources/public/css/bootstrap.css" data)]
             ["resources/public/css/{{name}}.css" (render "resources/public/css/todo.css" data)]
             ["src/clj/{{sanitized}}/config.clj" (render "config.clj" data)]
             ["src/clj/{{sanitized}}/dev_server.clj" (render "dev_server.clj" data)]
             ["src/clj/{{sanitized}}/prod_server.clj" (render "prod_server.clj" data)]
             ["src/clj/{{sanitized}}/application_host.clj" (render "application_host.clj" data)]
             ["src/clj/one/build.clj" (render "tools/build.clj" data)]
             ["src/clj/one/config.clj" (render "tools/config.clj" data)]
             ["src/clj/one/reload.clj" (render "tools/reload.clj" data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)])))
