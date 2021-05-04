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
                        JFrame
                        BorderFactory
                        JTextField JOptionPane ListSelectionModel DefaultListModel)
           (java.awt Font
                     Color
                     GridBagConstraints
                     GridBagLayout
                     Insets)
           (javax.swing.border BevelBorder)
           (java.awt.event ActionListener)))

;; Variables
(def date-list (new JList))

;;;----------------------------------------------------------;;;
;;; Creates a primary-frame for the to-do list application   ;;;
;;;----------------------------------------------------------;;;
(def primary-frame
  (doto (new JFrame)
    (.setTitle "Lad's To-Do-List!")
    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    (.setLayout (new GridBagLayout))))

;; Action functions for each button.
(defn add-entry-action []
  )

(defn delete-entry-action []
  )

(defn select-date-action []
  (let [selected-date (.getSelectedValue date-list)
        entries (into-array String (vec (map last (db/get-entries selected-date))))]
    (doto date-list
      (.addElement entries))))

;;
;; You need to go in an add a list model to the date-list so that
;; you can add and remove items easily. Right now date-list is not
;; mutable.
;;
;; Add a list selection model so that multiple dates can't be selected.
;;
;;
;;

(defn mark-complete-action []
  )


;;;----------------------------------------;;;
;;; Function to Initializes all components ;;;
;;;----------------------------------------;;;
(defn initialize-primary-frame
  "Initializes all the components and adds them to the frame."
  [frame]

  ;;;-------------------------------------------------;;;
  ;;; Date List Data, Label, Constraints, Scroll-Pane ;;;
  ;;;-------------------------------------------------;;;

  ;;; Gets the data for the dates from the data.clj file
  ;(def date-list-data
  ;  (into-array String (vec (db/get-dates-string))))

  (def date-list-model (new DefaultListModel))

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
  (def entries-list-data
    (into-array String [""]))

  ;; Creates a list component for the entries list
  (def entries-list
    (doto (new JList entries-list-data)))

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


  ;;;--------------------------------------------------;;;
  ;;; Select date, completed, add, and delete buttons  ;;;
  ;;;--------------------------------------------------;;;

  ;; Creates a button for selecting the date
  (def select-date-btn
    (doto (new JButton)
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "Select")))

  ;; Need to add the Button Action Listener!!

  ;; Creates constraints for the select button
  (def select-date-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 2)
      (set! (. grid-bag -gridy) 5)
      (set! (. grid-bag -gridwidth) 2)
      (set! (. grid-bag -ipadx) 4)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 15 28 10 0))
      grid-bag))

  ;; Adds the select date button and it's constraints to the frame.
  (doto frame
    (.add select-date-btn select-date-grid-bag))

  ;; Creates a button for indicating completed entries
  (def completed-btn
    (doto (new JButton)
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "Mark Complete")))

  ;; Need to add Button Action Listener!

  ;; Completed Button Constraints
  (def completed-btn-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 4)
      (set! (. grid-bag -gridy) 5)
      (set! (. grid-bag -ipadx) 11)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 15 18 10 0))
      grid-bag))

  ;; Adds the completed button and it's constraints to the frame.
  (doto frame
    (.add completed-btn completed-btn-grid-bag))

  ;; Creates a button for adding entries
  (def add-entry-btn
    (doto (new JButton)
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "Add Entry")))

  ;; Add Entry Button Constraints
  (def add-entry-btn-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 5)
      (set! (. grid-bag -gridy) 5)
      (set! (. grid-bag -gridwidth) 2)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 15 18 10 0))
      grid-bag))

  ;; Adds the add-entry button and it's constraints to the frame.
  (doto frame
    (.add add-entry-btn add-entry-btn-grid-bag))

  ;; Creates a button for deleting entries
  (def delete-entry-btn
    (doto (new JButton)
      (.setFont (new Font "Segoe UI" 0 12))
      (.setText "Delete Entry")))

  ;; Need to add Button Action Listener!

  ;; delete entries Button Constraints
  (def delete-entry-btn-grid-bag
    (let [grid-bag (new GridBagConstraints)]
      (set! (. grid-bag -gridx) 7)
      (set! (. grid-bag -gridy) 5)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -insets) (new Insets 15 18 10 0))
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
      (.setText "TIPS:")
      (.setBorder (BorderFactory/createBevelBorder BevelBorder/RAISED))))

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
      (set! (. grid-bag -gridheight) 3)
      (set! (. grid-bag -fill) GridBagConstraints/BOTH)
      (set! (. grid-bag -ipadx) 102)
      (set! (. grid-bag -ipady) 181)
      (set! (. grid-bag -anchor) GridBagConstraints/NORTHWEST)
      (set! (. grid-bag -weightx) 1.0)
      (set! (. grid-bag -weighty) 1.0)
      (set! (. grid-bag -insets) (new Insets 65 17 0 0))
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
      (set! (. grid-bag -insets) (new Insets 6 17 0 0))
      grid-bag))

  ;; Adds the title label and it's constraints to the frame
  (doto frame
    (.add title-label title-label-grid-bag))

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


  ;; Creates action listeners for each of the buttons
  (def add-entry-action-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (add-entry-action))))

  (def delete-entry-action-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (delete-entry-action))))

  (def select-date-action-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (select-date-action))))

  (def mark-complete-action-listener
    (proxy [ActionListener] []
      (actionPerformed [event] (mark-complete-action))))


  ;; Adds action listeners to each of the buttons
  (.addActionListener add-entry-btn add-entry-action-listener)
  (.addActionListener delete-entry-btn delete-entry-action-listener)
  (.addActionListener select-date-btn select-date-action-listener)
  (.addActionListener completed-btn mark-complete-action-listener)

  ) ;; End of initialize function.


;; Run the gui
(defn run []
  (initialize-primary-frame primary-frame)
  (doto primary-frame (.pack) (.setVisible true)))
