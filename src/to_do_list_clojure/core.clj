;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.core
  (:require [to-do-list-clojure.data :as db]
            [clojure.string :as str]))



(defn prompt-and-read
  "Prompts the user for a command and returns what the user enters.
   Returns nil if the command 'exit-to-do' is entered."
  []
  (print "[Please Enter a Command]> ")
  (flush)
  (let [input (read-line)]
    (if (= input "exit-to-do")
    nil
    input)))


(defn console-loop
  ""
  []
  (loop [input (prompt-and-read)]
    (-> input
        str/upper-case
        println)
    (recur (prompt-and-read))))


(defn -main
  [& Args]

  ;; Create here a console application which creates a to-do list.
  ;; Have a REPL Loop which displays the TO-do list and has commands to make changes.

  )

