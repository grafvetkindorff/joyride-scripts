(ns clear-repl
  (:require ["vscode" :as vscode]
            ["fs" :as fs]
            ["path" :as path]
            ["ext://betterthantomorrow.calva$v0" :as calva]
            [joyride.core :as joyride]
            [promesa.core :as p]
            [clojure.string :as str]
            #_[util.editor :as editor-utils]))


(def root-path (-> (first vscode/workspace.workspaceFolders) .-uri .-fsPath))


(defn write-to-file [path content]
  (fs/writeFileSync (path/resolve root-path path) content))


;; TODO: get current document and if it is a .calva-repl file, clear it
#_(defn current-document []
  (let [editor ^js vscode/window.activeTextEditor
        document (.-document editor)]
    document))

#_(vscode/window.showInformationMessage (.document (editor-utils/current-document)))

(write-to-file "box/.calva/output-window/output.calva-repl" "")

