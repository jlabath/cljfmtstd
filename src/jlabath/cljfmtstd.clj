(ns jlabath.cljfmtstd
  (:require [cljfmt.core :as cfmt])
  (:gen-class))

(def options (assoc cfmt/default-options
                    :remove-multiple-non-indenting-spaces? true
                    :split-keypairs-over-multiple-lines? true
                    :sort-ns-references? true))

(defn -main
  [& _]
  (let [source (slurp *in*)]
    (println (cfmt/reformat-string source options))))



