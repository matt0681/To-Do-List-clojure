;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.gui
  (:require [cljfx.api :as fx])
  (:import [javafx.application Platform]
           [javafx.scene.input KeyCode KeyEvent]
           [javafx.scene.paint Color]
           [javafx.scene.canvas Canvas])
  (:gen-class))

(def to-do-list-label
  {:fx/type :label
   :text "To-Do List"})

(def date-label
  {:fx/type :label
   :text "Date"})

(def entry-label
  {:fx/type :label
   :text "Entry"})

(def renderer
  (fx/create-renderer))

(renderer
  {:fx/type :stage
   :showing true
   :scene {:fx/type :scene
           :root {:fx/type :v-box
                  :children [date-label
                             entry-label]}}})
