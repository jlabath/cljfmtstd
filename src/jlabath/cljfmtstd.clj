(ns jlabath.cljfmtstd
  (:require [cljfmt.core :as cfmt]))

(def options (assoc cfmt/default-options
                    :remove-multiple-non-indenting-spaces? true
                    :split-keypairs-over-multiple-lines? true
                    :sort-ns-references? true))

(defn -main
  [& _]
  (let [source (slurp *in*)]
    (print (cfmt/reformat-string source options))))



