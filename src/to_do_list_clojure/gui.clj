;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;                                                          ;;;;
;;;;     This file creates the GUI.                           ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.gui
  (:require [to-do-list-clojure.data :as db])
  (:import (javax.swing JTextPane JScrollPane
                        JLabel JList
                        JButton JFrame
                        BorderFactory JTextField
                        ListSelectionModel DefaultListModel AbstractListModel)

           (java.awt Font                   Color
                     GridBagConstraints     GridBagLayout
                     Insets)

           (javax.swing.border BevelBorder)
           (java.awt.event ActionListener)))

;;;----------------------------------------------------------;;;
;;; Creates a primary-frame for the to-do list application   ;;;
;;;----------------------------------------------------------;;;
(def primary-frame
  (doto (new JFrame)
    (.setTitle "Lad's To-Do-List!")
    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    (.setLayout (new GridBagLayout))))

;;;----------------------------------------------------------;;;
;;; Action Functions for each of the Buttons                 ;;;
;;;----------------------------------------------------------;;;

;;; Action to add an entry to the to-do-list.
;;; This action is connected to the add entry button.
(defn add-entry-action []
  ;(let [date-input (str (.getText date-input-text-field))
  ;      entry-input (str (.getText entry-input-text-field))]
  ;  (db/add-entry date-input 1 entry-input)
  ;  (.addElement date-list-model date-input)
  ;  )
  )

;;;
;;;
(defn delete-entry-action []

  )

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
      (set! (. grid-bag -heighty) 1.0)
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

















  (
  ;;;------------------------------------------------------------;;;
  ;;; List Data, Date and Entry Labels, Constraints, Scroll-Pane ;;;
  ;;;------------------------------------------------------------;;;

  (def date-list-model
    (doto (new DefaultListModel)
      (.addElement "mm/dd/yyyy")))

  ;; Creates a list component for the dates
  (def date-list
    (doto (new JList date-list-model)
      (.setSelectionMode ListSelectionModel/SINGLE_INTERVAL_SELECTION)
      (.setLayoutOrientation JList/VERTICAL)))

  ;; Creates a scroll pane component for the dates
  (def date-scroll-pane
    (doto (new JScrollPane)
      (.setViewportView date-list)))

  ;; Creates the Grid Bag Constraints for the date scroll component
  (def date-scroll-pane-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 2)
      (set! (. grid-bag -gridy) 1)
      (set! (. grid-bag -gridwidth) 2)
      (set! (. grid-bag -gridheight) 2)
      (set! (. grid-bag -fill) GridBagConstraints/BOTH)
      (set! (. grid-bag -ipadx) 56)
      (set! (. grid-bag -ipady) 262)
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
      (set! (. grid-bag -gridx) 5)
      (set! (. grid-bag -gridy) 0)
      (set! (. grid-bag -ipadx) 8)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 22 0 0))
      grid-bag))

  ;; Adds the entry list label and it's constraints
  (doto frame
    (.add entry-list-label entry-list-label-grid-bag))

  ;; Creates data to go into the entries list
  (def entries-list-model
    (doto (new DefaultListModel)
      (.addElement "Thing that needs to get done.")))

  ;; Creates a list component for the entries list
  (def entries-list
    (doto (new JList entries-list-model)))

  ;; Creates a scroll pane for the entries
  (def entries-scroll-pane
    (doto (new JScrollPane)
      (.setViewportView entries-list)))

  ;; Creates constraints for the entries scroll pane
  (def entries-scroll-pane-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 4)
      (set! (. grid-bag -gridy) 1)
      (set! (. grid-bag -gridwidth) 5)
      (set! (. grid-bag -gridheight) 2)
      (set! (. grid-bag -fill) GridBagConstraints/BOTH)
      (set! (. grid-bag -ipadx) 409)
      (set! (. grid-bag -ipady) 262)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -weightx) 1.0)
      (set! (. grid-bag -weighty) 1.0)
      (set! (. grid-bag -insets) (new Insets 6 19 0 16))
      grid-bag))

  ;; Adds the entries scroll pane and scroll pane constraints to the frame.
  (doto frame
    (.add entries-scroll-pane entries-scroll-pane-grid-bag))




  ;;;---------------------------------------------------------;;;
  ;;; Date input and entry input text fields and constraints  ;;;
  ;;;---------------------------------------------------------;;;

  ;; Creates a date input text field
  (def date-input-text-field
    (doto (new JTextField)
      (.setText "mm/dd/yyyy")))

  ;; Creates constraints for the date input text field
  (def date-input-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 2)
      (set! (. grid-bag -gridy) 4)
      (set! (. grid-bag -gridwidth) 2)
      (set! (. grid-bag -ipadx) 72)
      (set! (. grid-bag -ipady) 10)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 18 0 0))
      grid-bag))

  ;; Adds the date input text field and it's constraints to the frame
  (doto frame
    (.add date-input-text-field date-input-grid-bag))

  ;; Creates an entry input text field
  (def entry-input-text-field
    (doto (new JTextField)
      (.setText "Fold the laundry.")))

  ;; Creates constraints for the entry input text field
  (def entry-input-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 4)
      (set! (. grid-bag -gridy) 4)
      (set! (. grid-bag -gridwidth) 5)
      (set! (. grid-bag -ipadx) 426)
      (set! (. grid-bag -ipady) 10)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 10 18 0 16))
      grid-bag))

  ;; Adds the entry input text field and it's constraints to the frame
  (doto frame
    (.add entry-input-text-field entry-input-grid-bag))


  ;;;----------------------------------------------------------;;;
  ;;; Creates action listeners for each of the buttons         ;;;
  ;;; These listeners call action-functions.                   ;;;
  ;;;----------------------------------------------------------;;;
  (def add-entry-action-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (add-entry-action))))

  (def delete-entry-action-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (delete-entry-action))))

  (def select-date-action-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (select-date-action))))


  ;;;----------------------------------------------------------;;;
  ;;; Adds action listeners to each of the buttons.            ;;;
  ;;;----------------------------------------------------------;;;
  (.addActionListener add-entry-btn add-entry-action-listener)
  (.addActionListener delete-entry-btn delete-entry-action-listener)
  (.addActionListener select-date-btn select-date-action-listener)) ;; End of initialize function.


;;;----------------------------------------------------------------------;;;
;;; Function to run the main GUI. It initializes and displays the gui.   ;;;
;;;----------------------------------------------------------------------;;;
(defn run []
  (initialize-primary-frame primary-frame)
  (doto primary-frame (.pack) (.setVisible true)))




