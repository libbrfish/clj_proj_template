(ns devos.template-test
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.spec.alpha :as s]
            [clojure.test :refer [deftest is testing]]
            [org.corfield.new] ; for the Specs
            [devos.template :as sut])) ; system under test

(deftest valid-template-test
  (testing "template.edn is valid."
    (let [template (edn/read-string (slurp (io/resource "devos/template/template.edn")))]
      (is
       (s/valid? :org.corfield.new/template template)
       (s/explain-str :org.corfield.new/template template)))))
