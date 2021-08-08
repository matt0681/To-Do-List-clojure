;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;                                                          ;;;;
;;;;     This file creates the GUI.                           ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.gui
  (:require [to-do-list-clojure.data :as db])
  (:import (javax.swing JScrollPane
                        JLabel
                        JList
                        JButton
                        JFrame
                        JTextField
                        DefaultListModel JPanel)
           (java.awt Font
                     GridBagConstraints
                     GridBagLayout
                     Insets)
           (java.awt.event ActionListener)))

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

  ;;;--------------------------------------------------;;;
  ;;; Title label and it's constraints.                ;;;
  ;;;--------------------------------------------------;;;
  ;; Creates a label component for the title
  (def title-label
    (doto (new JLabel)
      (.setFont (new Font "Segoe UI Semibold" 1 24))
      (.setText "To-Do List")))

  ;; Creates constraints for the title Label
  (def title-label-constraints
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 0)
      (set! (. grid-bag -gridy) 0)
      (set! (. grid-bag -gridwidth) 5)
      (set! (. grid-bag -gridheight) 2)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 19 66 0 0))
      grid-bag))

  ;; Adds the title label and it's constraints to the frame
  (doto frame
    (.add title-label title-label-constraints))

  ;;;---------------------------------------------------;;;
  ;;; Hints labels and constraints                       ;;;
  ;;;---------------------------------------------------;;;
  ;; Creates hints-1 label
  (def hints-1-label
    (doto (new JLabel)
      (.setFont (new Font "Segoe UI" 0 14))
      (.setText "Tips:  To add an entry, enter it's date and text below and hit \"Add Entry\".")))
  ;; Creates hints-2 label
  (def hints-2-label
    (doto (new JLabel)
      (.setFont (new Font "Segoe UI" 0 14))
      (.setText "         To delete an entry, select it from the list and then hit \"Delete Entry\".")))

  ;; Creates constraints for the hints-1 label
  (def hints-1-constraints
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 9)
      (set! (. grid-bag -gridy) 0)
      (set! (. grid-bag -gridwidth) 12)
      (set! (. grid-bag -ipadx) 9)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 19 29 0 10))
      grid-bag))
  ;; Creates constraints for the hints-2 label
  (def hints-2-constraints
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 9)
      (set! (. grid-bag -gridy) 1)
      (set! (. grid-bag -gridwidth) 11)
      (set! (. grid-bag -gridheight) 3)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 3 29 0 0))
      grid-bag))

  ;; Adds the hints-1 and 2 labels and their constraints to the frame.
  (doto frame
    (.add hints-1-label hints-1-constraints)
    (.add hints-2-label hints-2-constraints))


  ;;;--------------------------------------------------;;;
  ;;; Date and Entry Labels and their Constraints      ;;;
  ;;;--------------------------------------------------;;;
  ;; Creates a Date Label
  (def date-label
    (doto (new JLabel)
      (.setFont (new Font "Segoe UI" 0 18))
      (.setText "Date")))
  ;; Creates an entry label
  (def entry-label
    (doto (new JLabel)
      (.setFont (new Font "Segoe UI" 0 18))
      (.setText "Entry")))

  ;; Creates the grid bag constraints for the date label
  (def date-label-constraints
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 0)
      (set! (. grid-bag -gridy) 4)
      (set! (. grid-bag -gridwidth) 2)
      (set! (. grid-bag -ipadx) 33)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 35 0 0))
      grid-bag))
  ;; Creates the grid bag constraints for the entry label
  (def entry-label-constraints
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 2)
      (set! (. grid-bag -gridy) 4)
      (set! (. grid-bag -gridwidth) 6)
      (set! (. grid-bag -ipadx) 39)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 18 0 0))
      grid-bag))

  ;; Adds the entry and date labels and their constraints to the frame
  (doto frame
    (.add date-label date-label-constraints)
    (.add entry-label entry-label-constraints))

  ;;;--------------------------------------------------;;;
  ;;; Actual To-Do List Component                      ;;;
  ;;;--------------------------------------------------;;;
  ;; Model for the list
  (def list-model
    (doto (new DefaultListModel)
      (.addElement "mm/dd/yyyy  -   Example entry.")))

  ;; Actual list component
  (def to-do-list
    (doto (new JList list-model)
      (.setFont (new Font "Segoe UI" 0 12))))

  ;; Creates a scroll pane for the list
  (def list-scroll-pane
    (doto (new JScrollPane)
      (.setViewportView to-do-list)))

  ;; Creates constraints for the list's scroll pane
  (def list-scroll-pane-constraints
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 0)
      (set! (. grid-bag -gridy) 5)
      (set! (. grid-bag -gridwidth) 10)
      (set! (. grid-bag -fill) GridBagConstraints/BOTH)
      (set! (. grid-bag -ipadx) 646)
      (set! (. grid-bag -ipady) 249)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -weightx) 1.0)
      (set! (. grid-bag -insets) (new Insets 6 35 0 0))
      grid-bag))

  ;; Adds the list and it's constraints to the frame
  (doto frame
    (.add list-scroll-pane list-scroll-pane-constraints))

  ;;;--------------------------------------------------;;;
  ;;; Delete and Add Entry Buttons                     ;;;
  ;;;--------------------------------------------------;;;
  ;; Creates a button for deleting the selected date
  (def delete-selected-button
    (doto (new JButton)
      (.setFont (new Font "Segoe UI" 0 14))
      (.setText "Delete Selected")))

  ;; Creates constraints for the delete selected button
  (def delete-button-constraints
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 0)
      (set! (. grid-bag -gridy) 6)
      (set! (. grid-bag -gridwidth) 3)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 6 35 0 0))
      grid-bag))

  ;; Adds the delete selected button and it's constraints to the frame.
  (doto frame
    (.add delete-selected-button delete-button-constraints))

  ;; Creates a button for adding entries
  (def add-button
    (doto (new JButton)
      (.setFont (new Font "Segoe UI" 0 14))
      (.setText "Add")))

  ;; Creates constraints for the add button
  (def add-constraints
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 0)
      (set! (. grid-bag -gridy) 7)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 6 35 10 0))
      grid-bag))

  ;; Adds the add button and it's constraints to the frame.
  (doto frame
    (.add add-button add-constraints))

  ;;;------------------------------------------------------------;;;
  ;;; Date and Entry Text Fields                                 ;;;
  ;;;------------------------------------------------------------;;;
  ;; Creates a date text field
  (def date-text-field-text)
  (def date-text-field
    (doto (new JTextField)
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "mm/dd/yyyy")))

  ;; Creates constraints for the date text field
  (def date-text-field-constraints
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 1)
      (set! (. grid-bag -gridy) 7)
      (set! (. grid-bag -gridwidth) 8)
      (set! (. grid-bag -ipadx) 121)
      (set! (. grid-bag -ipady) 7)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 6 10 10 0))
      grid-bag))

  ;; Adds the date text field and it's constraint to the frame
  (doto frame
    (.add date-text-field date-text-field-constraints))

  ;; Creates a entry text field
  (def entry-text-field-text)
  (def entry-text-field
    (doto (new JTextField)
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "entry")))

  ;; Creates constraints for the entry text field
  (def entry-text-field-constraints
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 9)
      (set! (. grid-bag -gridy) 7)
      (set! (. grid-bag -ipadx) 455)
      (set! (. grid-bag -ipady) 7)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 6 10 10 0))
      grid-bag))

  ;; Adds the entry text field and it's constraint to the frame
  (doto frame
    (.add entry-text-field entry-text-field-constraints))

  ;;;------------------------------------------------------------;;;
  ;;; Panel                                                      ;;;
  ;;;------------------------------------------------------------;;;
  ;; Creates a panel
  (def panel-component (new JPanel))

  ;; Adds the panel to the frame
  (doto frame
    (.add panel-component (new GridBagConstraints)))

  ;;;----------------------------------------------------------;;;
  ;;; Action Functions for each of the Buttons                 ;;;
  ;;;----------------------------------------------------------;;;
  ;; Action to add an entry to the to-do-list.
  ;; This action is connected to the add entry button.
  (defn add-entry-action []
    (print "Hello from the add button action.")

    ;(let [date-input ????
    ;      entry-input ????]
    ;  ;;(db/add-entry date-input 1 entry-input)
    ;  (.addElement to-do-list (str date-input "  -  " entry-input))
    ;  (print (str date-input "  -  " entry-input))
    ;  )
    )

  ;;
  (defn delete-entry-action []

    )

  ;;
  (defn entry-text-field-action []

    )

  ;;
  (defn date-text-field-action []
    ;(print (.getText date-text-field))
    )

  ;;;----------------------------------------------------------;;;
  ;;; Creates action listeners for each of the buttons         ;;;
  ;;; These listeners call action-functions.                   ;;;
  ;;;----------------------------------------------------------;;;
  (def add-action-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (add-entry-action))))

  (def delete-selected-action-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (delete-entry-action))))

  (def entry-text-field-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (entry-text-field-action))))

  (def date-text-field-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (date-text-field-action))))

  ;;;----------------------------------------------------------------;;;
  ;;; Adds action listeners to each of the buttons & Text Fields.    ;;;
  ;;;----------------------------------------------------------------;;;
  (.addActionListener add-button add-action-listener)
  (.addActionListener delete-selected-button delete-selected-action-listener)
  (.addActionListener entry-text-field entry-text-field-listener)
  (.addActionListener date-text-field date-text-field-listener)

)


;;;----------------------------------------------------------------------;;;
;;; Function to run the main GUI. It initializes and displays the gui.   ;;;
;;;----------------------------------------------------------------------;;;
(defn run []
  (initialize-primary-frame primary-frame)
  (doto primary-frame (.pack) (.setVisible true)))


