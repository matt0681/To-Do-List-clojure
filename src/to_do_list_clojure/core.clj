;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.core
  (:require [to-do-list-clojure.gui :as gui]
            [to-do-list-clojure.data :as db]))

;; The main function which starts the program.
;; It calls the run function in gui.clj.
(defn main []
  (gui/run))





