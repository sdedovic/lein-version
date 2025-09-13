(ns lein-version.plugin
  (:require [clojure.pprint :as pprint]))

(defn- replace-version [version-value dep]
  (if (vector? dep)
    (mapv #(if (= % :version) version-value %) dep)
    dep))

(defn middleware 
  [project]
  (let [version (:version project)]
    (-> project
        (update-in [:managed-dependencies] #(mapv (partial replace-version version) %)))))
