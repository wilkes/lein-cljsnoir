# lein-cljsnoir

A Leiningen template for noir + clojurescript project, derived from the clojurescriptone project.
http://clojurescriptone.com

## Usage
Requires lein-newnew (https://github.com/Raynes/lein-newnew)

To install:

```
lein plugin install lein-newnew 0.1.2
lein plugin install lein-cljsnoir 0.2.0
```

To create a new project:

```bash
lein new cljsnoir {{name}}
lein deps
sh script/repl
```

To run the server and start clojure repl:

```
sh script/run
```

To start the server, a cljs-repl, and open a browser run:

```
sh script/cljs-repl
```

To run the server from within a repl (or slime):

```clojure
(use '{{name}}.dev-server)
(run-server)
```

For the clojurescript repl:

```clojure
(use '{{name}}.dev-server)
(cljs-repl)
```

## License

Copyright (C) 2012 Wilkes Joiner

Distributed under the Eclipse Public License, the same as Clojure.
