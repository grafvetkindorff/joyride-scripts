(ns clear-repl
  (:require ["vscode" :as vscode]
            ["fs" :as fs]
            ["path" :as path]
            ["ext://betterthantomorrow.calva$v0" :as calva]
            [joyride.core :as joyride]
            [promesa.core :as p]
            [clojure.string :as str]))


(defn get-uri [editor]
  (-> editor .-document .-uri .-fsPath str))


(defn get-repl-path
  []
  (first (filterv #(= "output.calva-repl"
                      (-> %
                          (str/split #"/")
                          last))
                  (mapv get-uri vscode/window.visibleTextEditors))))


(defn write-to-file [path content]
  (fs/writeFileSync path content))


(write-to-file (get-repl-path) "")

