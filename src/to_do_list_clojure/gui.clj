;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;                                                          ;;;;
;;;;     This file creates the GUI.                           ;;;;
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

;;;----------------------------------------------------------;;;
;;; Creates a primary-frame for the to-do list application   ;;;
;;;----------------------------------------------------------;;;
(def primary-frame
  (doto (new JFrame)
    (.setTitle "Lad's To-Do-List!")
    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    (.setLayout (new GridBagLayout))))


;;;----------------------------------------;;;
;;; Function to Initializes all components ;;;
;;;----------------------------------------;;;
(defn initialize-primary-frame
  "Initializes all the components and adds them to the frame."
  [frame]

  ;;;-------------------------------------------------;;;
  ;;; Date List Data, Label, Constraints, Scroll-Pane ;;;
  ;;;-------------------------------------------------;;;

  ;; Gets the data for the dates from the data.clj file
  (def date-list-data
    (into-array String ["One" "Two" "Three" "Four"]))

  ;; Creates a list component for the dates
  (def date-list
    (doto (new JList date-list-data)))

  ;; Date list model?

  ;; Creates a scroll pane component for the dates
  (def date-scroll-pane
    (doto (new JScrollPane)
      (.setViewportView date-list)))

  ;; Creates the Grid Bag Constraints for the date scroll component
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

  ;; Adds the dates scroll pane and the grid bag constraints to the frame
  (doto frame
    (.add date-scroll-pane date-scroll-pane-grid-bag))

  ;; Creates a label for the date list
  (def date-list-label
    (doto (new JLabel)
      (.setFont (new Font "Segoe UI" 1 18))
      (.setText "Date")))

  ;; Creates grid-bag constraints for the date list label
  (def date-list-label-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 2)
      (set! (. grid-bag -gridy) 0)
      (set! (. grid-bag -ipadx) 11)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 39 0 0))
      grid-bag))

  ;; Adds the date list label and date list label constraints to the frame
  (doto frame
    (.add date-list-label date-list-label-grid-bag))


  ;;;--------------------------------------------------;;;
  ;;; Entry List Data, Label, Constraints, Scroll-Pane ;;;
  ;;;--------------------------------------------------;;;

  ;; Creates a label component for the entries list
  (def entry-list-label
    (doto (new JLabel)
      (.setFont (new Font "Segoe UI" 1 18))
      (.setText "Entries")))

  ;; Creates the grid bag constraints for the entry list label
  (def entry-list-label-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 6)
      (set! (. grid-bag -gridy) 0)
      (set! (. grid-bag -ipadx) 8)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 11 0 0))
      grid-bag))

  ;; Adds the entry list label and it's constraints
  (doto frame
    (.add entry-list-label entry-list-label-grid-bag))

  ;; Creates data to go into the entries list
  (def entries-list-data
    (into-array String ["One" "Two" "Three" "Four"]))

  ;; Creates a list component for the entries list
  (def entries-list
    (doto (new JList entries-list-data)))

  ;; Entries List Model?

  ;; Creates a scroll pane for the entries
  (def entries-scroll-pane
    (doto (new JScrollPane)
      (.setViewportView entries-list)))

  ;; Creates constraints for the entries scroll pane
  (def entries-scroll-pane-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 5)
      (set! (. grid-bag -gridy) 1)
      (set! (. grid-bag -gridwidth) 3)
      (set! (. grid-bag -gridheight) 3)
      (set! (. grid-bag -fill) GridBagConstraints/BOTH)
      (set! (. grid-bag -ipadx) 523)
      (set! (. grid-bag -ipady) 295)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -weightx) 1.0)
      (set! (. grid-bag -weighty) 1.0)
      (set! (. grid-bag -insets) (new Insets 6 19 0 31))
      grid-bag))

  ;; Adds the entries scroll pane and scroll pane constraints to the frame.
  (doto frame
    (.add entries-scroll-pane entries-scroll-pane-grid-bag))


  ;;;--------------------------------------------------;;;
  ;;; Select date, completed, add, and delete buttons  ;;;
  ;;;--------------------------------------------------;;;

  ;; Creates a button for selecting the date
  (def select-date-btn
    (doto (new JButton)
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "Select")))

  ;; Button Events ?

  ;; Creates constraints for the select button
  (def select-date-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 2)
      (set! (. grid-bag -gridy) 4)
      (set! (. grid-bag -gridwidth) 2)
      (set! (. grid-bag -ipadx) 4)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 28 10 0))
      grid-bag))

  ;; Adds the select date button and it's constraints to the frame.
  (doto frame
    (.add select-date-btn select-date-grid-bag))

  ;; Creates a button for indicating completed entries
  (def completed-btn
    (doto (new JButton)
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "Mark Complete")))

  ;; Button events ?

  ;; Completed Button Constraints
  (def completed-btn-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 5)
      (set! (. grid-bag -gridy) 4)
      (set! (. grid-bag -ipadx) 11)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 29 10 0))
      grid-bag))

  ;; Adds the completed button and it's constraints to the frame.
  (doto frame
    (.add completed-btn completed-btn-grid-bag))

  ;; Creates a button for adding entries
  (def add-entry-btn
    (doto (new JButton)
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "Add Entry")))

  ;; Button events ?

  ;; Add Entry Button Constraints
  (def add-entry-btn-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 5)
      (set! (. grid-bag -gridy) 3)
      (set! (. grid-bag -gridwidth) 2)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 26 10 0))
      grid-bag))

  ;; Adds the add-entry button and it's constraints to the frame.
  (doto frame
    (.add add-entry-btn add-entry-btn-grid-bag))

  ;; Creates a button for deleting entries
  (def delete-entry-btn
    (doto (new JButton)
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "Delete Entry")))

  ;; Button events ?

  ;; delete entries Button Constraints
  (def delete-entry-btn-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 5)
      (set! (. grid-bag -gridy) 4)
      (set! (. grid-bag -ipadx) 11)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 29 10 0))
      grid-bag))

  ;; Adds the delete-entry button and it's constraints to the frame.
  (doto frame
    (.add delete-entry-btn delete-entry-btn-grid-bag))


  ;;;--------------------------------------------------;;;
  ;;; Tips Text-Pane, scroll-pane, and constraints     ;;;
  ;;;--------------------------------------------------;;;

  ;; Creates a tips text-pane component
  (def tips-text-pane
    (doto (new JTextPane)
      (.setEditable false)
      (.setBackground (new Color 240 240 240))
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "TIPS:")))

  ;; Creates a scroll pane for the tips text pane
  (def tips-scroll-pane
    (doto (new JScrollPane)
      (.setViewportView tips-text-pane)))

  ;; Creates constraints for the tips text pane
  (def tips-text-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 0)
      (set! (. grid-bag -gridy) 2)
      (set! (. grid-bag -gridwidth) 2)
      (set! (. grid-bag -fill) GridBagConstraints/BOTH)
      (set! (. grid-bag -ipadx) 124)
      (set! (. grid-bag -ipady) 78)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -weightx) 1.0)
      (set! (. grid-bag -weighty) 1.0)
      (set! (. grid-bag -insets) (new Insets 65 20 0 0))
      grid-bag))

  ;; Adds the tips scroll pane and it's constraints to the frame.
  (doto frame
    (.add tips-scroll-pane tips-text-grid-bag))


  ;;;--------------------------------------------------;;;
  ;;; Title label and it's constraints.                ;;;
  ;;;--------------------------------------------------;;;

  ;; Creates a label component for the title
  (def title-label
    (doto (new JLabel)
      (.setFont (new Font "Segoe UI" 1 24))
      (.setText "To-Do List")))

  ;; Creates constraints for the title Label
  (def title-label-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 0)
      (set! (. grid-bag -gridy) 1)
      (set! (. grid-bag -ipadx) 7)
      (set! (. grid-bag -ipady) 23)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 6 20 0 0))
      grid-bag))

  ;; Adds the title label and it's constraints to the frame
  (doto frame
    (.add title-label title-label-grid-bag))

  ) ;; End of initialize function.


;; Run the gui
(defn run []
  (initialize-primary-frame primary-frame)
  (doto primary-frame (.pack) (.setVisible true)))
