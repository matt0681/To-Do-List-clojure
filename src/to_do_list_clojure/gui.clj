;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.gui
  (:use seesaw.core))

(defn create-GUI
  ""
  []
  (native!)

  (def main-label
    (label :text "Hi there!"
           :border 5
           :background "#888"
           :foreground :blue))

  (def main-frame
    (frame :title "Lad's To-Do List!"
           :on-close :exit
           :content main-label
           :width 640
           :height 480
           :resizable? true))




  (-> main-frame show!))


