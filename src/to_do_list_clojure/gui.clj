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
                        JFrame)
           (java.awt Font
                     Color
                     GridBagConstraints
                     GridBagLayout
                     Insets)))

;; The Main Frame of the GUI
(def primary-frame
  (doto (new JFrame)
    (.setTitle "Lad's To-Do-List!")
    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    (.setLayout (new GridBagLayout))))

;; Initializes all the Data
(defn initialize
  ""
  [frame]

  (def date-list-data
    (into-array String (vec (db/get-dates-string))))

  (def date-list
    (doto (new JList date-list-data)))

  (def date-scroll-pane
    (doto (new JScrollPane)
      (.setViewportView date-list)))

  (def date-scroll-pane-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 2)
      (set! (. grid-bag -gridy) 1)
      (set! (. grid-bag -gridwidth) 3)
      (set! (. grid-bag -gridheight) 3)
      (set! (. grid-bag -fill) GridBagConstraints/BOTH)
      (set! (. grid-bag -ipadx) 72)
      (set! (. grid-bag -ipady) 295)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -weightx) 1.0)
      (set! (. grid-bag -weighty) 1.0)
      (set! (. grid-bag -insets) (new Insets 6 18 0 0))
      grid-bag))

  (doto frame
    (.add date-scroll-pane date-scroll-pane-grid-bag))

  (def entry-list-label
    (doto (new JLabel)
      (.setFont (new Font "Segoe UI" 1 18))
      (.setText "Entries")))

  (def entry-list-label-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 6)
      (set! (. grid-bag -gridy) 0)
      (set! (. grid-bag -ipadx) 8)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 11 0 0))
      grid-bag))

  (doto frame
    (.add entry-list-label entry-list-label-grid-bag))

  (def date-list-label
    (doto (new JLabel)
      (.setFont (new Font "Segoe UI" 1 18))
      (.setText "Date")))

  (def date-list-label-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 2)
      (set! (. grid-bag -gridy) 0)
      (set! (. grid-bag -ipadx) 11)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 39 0 0))
      grid-bag))

  (doto frame
    (.add date-list-label date-list-label-grid-bag))
  


  )


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


;; Run the gui
(defn run []
  (initialize primary-frame)
  (doto primary-frame (.pack) (.setVisible true)))
