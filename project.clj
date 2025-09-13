(defproject com.dedovic/lein-version "1.0.0"
  :plugins [[lein-changelog "0.3.2"]]

  :description "A lein plugin to inject the project version into dependency targets"
  :url "https://github.com/sdedovic/lein-version"
  :license {:name "Apache License, Version 2.0" 
            :url  "https://www.apache.org/licenses/LICENSE-2.0.html"}

  :deploy-repositories  [["releases" {:sign-releases false
                                      :url           "https://clojars.org/repo"
                                      :username      :env/clojars_user
                                      :password      :env/clojars_token}]]
  :release-tasks [;; 1 - tests
                  ["vcs" "assert-committed"]

                  ;; 2 - bump versions and update changelog sections
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["changelog" "release"]

                  ;; 3 - commit changes
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]                 ;; TODO: start signing things

                  ;; 4 - deploy to clojars
                  ["deploy"]

                  ;; 5 - bump version for new dev cycle and push
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]

  :eval-in-leiningen true)
