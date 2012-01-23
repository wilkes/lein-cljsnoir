(ns {{name}}.config)

(def ^{:doc "Configuration for the sample application."}
  config {:src-root "src"
          :app-root "src/cljs"
          :top-level-package "{{name}}"
          :js "resources/public/javascripts"
          :dev-js-file-name "main.js"
          :prod-js-file-name "mainp.js"
          :dev-js ["goog.require('{{sanitized}}.core');"
                   "{{sanitized}}.core.main();"
                   "{{sanitized}}.core.repl();"]
          :prod-js ["{{sanitized}}.core.main();"]
          :reload-clj ["/one/reload"
                       "/{{sanitized}}/config"
                       "/{{sanitized}}/dev_server"]})
