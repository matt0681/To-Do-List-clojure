;;;;----------------------------------------------------------;;;;
;;;;     Matthew Lad                                          ;;;;
;;;;     To-Do List Application                               ;;;;
;;;;     4/29/2021                                            ;;;;
;;;;----------------------------------------------------------;;;;

(ns to-do-list-clojure.core)
;(:require [to-do-list-clojure.data :as db]
;  [clojure.string :as str]
;  [seesaw.selector :as selector])
;(:use [seesaw.core])

;
;;; In 'MainGUI.java', the widgets all the widgets have their
;;; name set with 'setName()'.
;(defn identify
;  "Given a 'root' widget, find all the named widgets and set their Seesaw :id
;   so they can play nicely with select and everything."
;  [root-widget]
;  (doseq [w (select root-widget [:*])]
;    (if-let [n (.getName w)]
;      (selector/id-of! w (keyword n))))
;  root-widget)
;
;
;;;; Define a state to change after doing something.
;(def progress (atom 100))
;
;
;(declare submit-form simulate-send-info)
;
;(defn submit-form
;  "Simulate a send info functionality."
;  [form button widget]
;  ;; Check if button is enabled.
;  (if (config (select form button) :enabled?)
;    (do
;      (reset! progress 0)
;      (text! (select form button) "Sending...")
;      (config! (select form button) :enabled? false)
;      (future (simulate-send-info form button widget)))))
;
;(defn simulate-send-info
;  "Take some time to send info and update progress over time."
;  [form button widget]
;  (println "Sending info")
;  (while (<= @progress 100)
;    (do
;      (swap! progress inc) ; Update progress.
;      (value! (select form widget) @progress) ; Show progress on progress-bar.
;      (Thread/sleep 50))) ; Wait some time.
;  (config! (select form button) :enabled? true) ; Re-enable the button.
;  (text! (select form button) "Submit")
;  (alert "Successfuly submited.")
;  (println "Done")
;  (println (str "Here is the data: " (value form))))
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;            Initialization           ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
;;;; A helper to create an instance of the form, annotate it for Seesaw and do
;;;; some other initialization.
;(defn my-form
;  []
;  (let [form (identify (seesaw_gui_application.MainWindow.))]
;    ;; Initialize the state combobox.
;    (config! (select form [:#gender]) :model gender)
;
;    ;; Events - a function that should be run from the start.
;    ;; For example: `(future (auto-count form [:#progress-bar]))`.
;
;    ;; Button binding.
;    (listen
;      ;; If button clicked execute function.
;      (select form [:#submit-button]) :mouse-clicked
;      (fn [e] (submit-form form [:#submit-button] [:#progress-bar])))
;    form))
;
;;;; Creates the panel and initializes it to the defaults above with
;;;; 'seesaw.core/value!' and show it in a dialog. Note how, besides setting the
;;;; names of the widgets, the code in `MainWindow.java` is strictly for layout. All
;;;; behavior, etc is done in Clojure.
;(defn -main
;  [& args]
;  (invoke-later
;    (let [form  (value! (my-form) defaults)
;          output (-> form pack! show!)]
;      nil)))

