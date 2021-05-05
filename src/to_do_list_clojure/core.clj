;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.core
  (:require [to-do-list-clojure.gui :as gui]
            [to-do-list-clojure.data :as db]))


(defn main []

  (db/add-date (db/format-date "02/09/2000"))
  (db/add-entry "02/09/2000" 1 "Hello!!")

  (gui/run))
