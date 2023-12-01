(ns reopen-file
  (:require ["vscode" :as vscode]))

(defn reopen-document []
  (let [current-uri (-> vscode/window.activeTextEditor .-document .-uri)]
    (-> (vscode/commands.executeCommand "workbench.action.closeActiveEditor")
        (.then
         #(-> (vscode/workspace.openTextDocument current-uri)
              (.then (fn [doc] (vscode/window.showTextDocument doc))))))))

(reopen-document)
