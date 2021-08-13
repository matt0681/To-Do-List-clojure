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
  (let [temp-main-data main-data]
    (def main-data (conj temp-main-data (vector date entry)))))


(defn remove-entry
  "This function removes a date/entry from the main-data vector."
  [date-entry-text]
  (let [date (subs date-entry-text 0 10)
        entry (subs date-entry-text 15)
        vect (vector date entry)
        index (.indexOf main-data vect)
        temp-main-data main-data]
    (def main-data (into (subvec temp-main-data 0 index) (subvec temp-main-data (inc index))))))



