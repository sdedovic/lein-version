# lein-version
[![Clojars Project](https://img.shields.io/clojars/v/com.dedovic/lein-version.svg)](https://clojars.org/com.dedovic/lein-version)

A Leiningen plugin to replace instances of `:version` with the version specified in the Lein project. I use this to keep all deps consistent in my monorepo with [lein-monolith](https://github.com/amperity/lein-monolith).

## Usage

Put `[lein-version "1.0.0"]` into the `:plugins` vector. The middleware is implicitly applied though `lein-version.plugin/middleware` should be added the `:middleware` vector. There is no documentation - read the source code.

## Development
### Release
```bash
# given
direnv allow

lein release
```

