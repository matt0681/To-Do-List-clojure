;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.gui
  (:require [to-do-list-clojure.data :as db])
  (:import (javax.swing JTextPane
                        JScrollPane
                        JLabel
                        JList
                        JButton
                        JFrame
                        GroupLayout)
           (java.awt Font
                     Color)))


;; Initializing some components.
(def date-list-data
  (into-array String (vec (db/get-dates-string))))

(def date-list
  (doto (new JList date-list-data)))

(def date-scroll-pane
  (doto (new JScrollPane)
    (.setViewportView date-list)))

(def entry-list-label
  (doto (new JLabel)
    (.setFont (new Font "Segoe UI" 1 18))
    (.setText "Entries")))

(def date-list-label
  (doto (new JLabel)
    (.setFont (new Font "Segoe UI" 1 18))
    (.setText "Date")))

(def select-date-btn
  (doto (new JButton)
    (.setFont (new Font "Segoe UI" 0 12))
    (.setText "Select")))

(def tips-text-pane
  (doto (new JTextPane)
    (.setEditable false)
    (.setBackground (new Color 240 240 240))
    (.setFont (new Font "Segoe UI" 0 12))
    (.setText "TIPS:")))

(def tips-scroll-pane
  (doto (new JScrollPane)
    (.setViewportView tips-text-pane)))

(def entries-list-data
  (into-array String ["One" "Two" "Three" "Four"]))

(def entries-list
  (doto (new JList entries-list-data)))

(def entries-scroll-pane
  (doto (new JScrollPane)
    (.setViewportView entries-list)))

(def completed-btn
  (doto (new JButton)
    (.setFont (new Font "Segoe UI" 0 12))
    (.setText "Mark Complete")))

(def title-label
  (doto (new JLabel)
    (.setFont (new Font "Segoe UI" 1 24))
    (.setText "To-Do List")))

;; Creating the Layout / Positioning


(def test-label (new JLabel))
;; Initializes the main frame.
(def primary-frame
  (doto (new JFrame)
    (.setTitle "Lad's To-Do-List!")
    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    (.setLayout primary-layout)))

;; Run the gui
(defn run []
  (setup-primary-layout)
  (doto primary-frame (.pack) (.setVisible true)))
