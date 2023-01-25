## Wrapper for cljfmt so that it is usable in helix editor

I wanted to use [cljfmt](https://github.com/weavejester/cljfmt) along with [helix](https://helix-editor.com/) which uses stdin/stdout for formatting so I made this wrapper.

### Local configuration

~/.clojure/deps.edn

```
:aliases
 { ...
  :cfmt {:extra-deps {jlabath/cljfmtstd {:local/root "/Users/jakub/projects/cljfmtstd"}}
         :main-opts ["-m" "jlabath.cljfmtstd"]}}
```

### Helix configuration

~/.config/helix/languages.toml

```
[[language]]
name = "clojure"
auto-format = true
formatter = { command = "clojure" , args = ["-Mcfmt"] }
```

### Other ways to call this

    cat <somefile> | clojure -Mcfmt
