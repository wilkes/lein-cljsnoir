# lein-cljsnoir

A Leiningen template for noir + clojurescript project, derived from the clojurescriptone project.
http://clojurescriptone.com

## Usage
```bash
lein new cljsnoir {{name}}
lein deps
sh script/repl
```

```clojure
(use '{{name}}.dev-server)
(run-server)
```

For the clojurescript repl
```clojure
(use '{{name}}.dev-server)
(cljs-repl)
```

## License

Copyright (C) 2012 Wilkes Joiner

Distributed under the Eclipse Public License, the same as Clojure.
