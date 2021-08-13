;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.data
  (:require [clojure.string :as str]))


;; The main database for storing to-do list data.
;; It is a vector containing vectors which themselves contain a date and entry.
(def main-data [["mm/dd/yyyy" "Example entry."]])


(defn wipe-main-data
  "Erases all data in main-data.
   Returns the now empty main-data vector
   This function should not exist."
  []
  (def main-data [])
  main-data)


(defn print-main-list
  "Prints out the contents of main-data in a very simple format.
   Used for testing/debugging more than anything"
  []
  (println main-data))


(defn add-entry
  "This function adds a date and entry text to the main-data vector.
  Adds them as strings."
  [date entry]
  (conj main-data (vector date entry)))


(defn remove-entry
  "This function removes a date/entry from the main-data vector."
  [date-entry-text]
  (let [date (subs date-entry-text 0 10)  ; extract the date from the gui entry
        entry (subs date-entry-text 15)  ; extract the entry from the gui entry
        date-entry-vector (vector date entry)
        (println date-entry-vector)
        (println main-data)
        index (.indexOf main-data date-entry-vector)
        temp-main-data main-data]
    ;; remove date-entry-vector from main-data
    (println main-data)
    ;(def main-data (into (subvec temp-main-data 0 index) (subvec temp-main-data (inc index))))
    (println (into (subvec temp-main-data 0 index) (subvec temp-main-data (inc index))))))


;(defn get-entries
;  "Returns all the entries for a particular date.
;   Returns as [[importance 'subject'] [importance 'subject'] ...]"
;  [date-str]
;  (let [date-millis (first (keys (format-date date-str)))]
;    (get main-data date-millis)))
;
;
;(defn get-dates-string
;  "Returns all the dates in main-data in a vector of strings."
;  []
;  (vec (map millis-to-date (keys main-data))))


