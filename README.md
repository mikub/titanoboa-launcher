# titanoboa-launcher
Launcher for titanoboa server.
It creates a dynamic class loader before starting clojure runtime and titanoboa server. This makes it possible for titanoboa server to load maven dependencies dynamically during runtime even on java 9 and higher.
