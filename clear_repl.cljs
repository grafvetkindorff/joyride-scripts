(ns clear-repl
  (:require ["vscode" :as vscode]
            ["ext://betterthantomorrow.calva$v0" :as calva]
            [joyride.core :as joyride]
            [promesa.core :as p]
            [clojure.string :as str]
            [util.editor :as editor-utils]))


(defn info [& xs]
  (vscode/window.showInformationMessage (str/join " " xs)))


(def root-path (-> (first vscode/workspace.workspaceFolders) .-uri .-fsPath))
(info "The root path of this workspace:" root-path)


(defn write-to-file [path content]
  (fs/writeFileSync (path/resolve root-path path) content))


(write-to-file ".calva/output-window/output.calva-repl" "")
