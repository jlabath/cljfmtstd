## Wrapper for cljfmt so that it is usable in helix editor

I wanted to use [cljfmt](https://github.com/weavejester/cljfmt) along with [helix editor](https://helix-editor.com/) which uses stdin/stdout for formatting so I made this wrapper.

### Local configuration

~/.clojure/deps.edn

```
:aliases
 { ...
  :cfmt {:extra-deps {jlabath/cljfmtstd {:git/url "https://github.com/jlabath/cljfmtstd.git"
                                         :git/sha "54d652d25a764cfd4a7fa48150d50109d0850bf3"}}
         :main-opts ["-m" "jlabath.cljfmtstd"]}}
```

Note: the name cfmt is arbitrary you can call it :bob instead of :cfmt and then invoke it with clojure -Mbob

### Helix configuration

~/.config/helix/languages.toml

```
[[language]]
name = "clojure"
auto-format = true
formatter = { command = "clojure" , args = ["-Mcfmt"] }
```

### Check if cfmt is installed properly

in shell use ^D (ctrl-d) to end input

```
$ clojure -Mcfmt
( + 1     1)
^D
(+ 1 1)
$
```
