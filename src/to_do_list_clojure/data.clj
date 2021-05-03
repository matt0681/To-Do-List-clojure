;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.data
  (:require [clojure.string :as str])
  (:import (java.util Date)
           (java.text SimpleDateFormat)))


;; The main database for storing to-do list data.
;; It is a map where the date is keyed to vectors containing
;; entries for those dates.
(def main-data {})


(defn wipe-main-data
  "Erases all data in main-list.
   Returns main-list"
  []
  (def main-data {})
  main-data)


(defn print-main-list
  "Prints out the contents of main-list in a very simple format.
   Used for testing/debugging more than anything"
  []
  (for [date main-data]
    (println date)))


(defn millis-to-date
  "Converts a date in milliseconds to a string of
   format 'mm/dd/yyyy'"
  [date-millis]
  (let [date-obj (new Date date-millis)
        sdf (SimpleDateFormat. "MM/dd/yyyy")
        date-str (.format sdf date-obj)]
    date-str))


(defn date-to-millis
  "Converts a date string of format 'mm/dd/yyyy'
   into it's equivalent milliseconds since the epoch."
  [date-str]
  (let [sdf (SimpleDateFormat. "MM/dd/yyyy")
        date (.parse sdf date-str)
        millis (.getTime date)]
    millis))


(defn format-date
  "The function to create a Date out of raw strings.
   Takes in a date in the format of 'mm/dd/yyyy' and returns
   a map where the key is the date in milliseconds since the
   epoch and the value is an empty vector. Example:
   (create-date '02/09/2001')
   => {981698400000 [], etc.}"
  [date-string]
  (assoc {} (date-to-millis date-string) []))


(defn format-entry
  "The function to create an Entry.
   Takes in an importance number and entry subject string and
   returns a vector containing those input items.
   Example: (create-entry 1 'Hi') => [1 'Hi']"
  [importance-num entry-string]
  [importance-num entry-string])


(defn add-date
  "This function adds a date to the main-data map.
   It takes in a date as a map {millis []}
   If the date already exists, does nothing.
   If the date doesn't exist, add it to main-data"
  [date-map]
  (if (contains? main-data (first (keys date-map)))
    nil
    (def main-data (merge main-data date-map))))


(defn add-entry
  "1. have it add the date to the main-list
   2. have it add the entry to the main-list"
  [date-str imp-num entry-str]
  (let [date-millis (first (keys (format-date date-str)))
        frmtd-date (format-date date-str)
        frmtd-entry (format-entry imp-num entry-str)]
    (add-date (format-date date-str))  ; This adds the date if it doesn't exist already.
    (def main-data ;; This adds the entry to the correct date
      (assoc-in main-data [date-millis]
                (conj (get main-data date-millis) frmtd-entry)))))


(defn get-entries
  "Returns all the entries for a particular date.
   Returns as [[importance 'subject'] [importance 'subject'] ...]"
  [date-str]
  (let [date-millis (first (keys (format-date date-str)))]
    (get main-data date-millis)))


(defn get-dates-string
  "Returns all the dates in main-data in string format."
  []
  (map millis-to-date (keys main-data)))


