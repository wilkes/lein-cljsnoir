(ns {{name}}.application-host
  (:require [hiccup.page-helpers :as ph])
  (:use [noir.core :only (defpartial)]))

(defn nav-link [li-class href txt]
  [:li {:class li-class} [:a {:href href} txt]])

(defn topbar [environment]
  [:div.topbar
   [:div.topbar-inner
    [:div.container-fluid
     [:a.brand {:href "/"} "{{capitalized}}"]
     (if (= :development environment)
       [:ul#navigation.nav
        (nav-link "home" "/" "Home")
        (nav-link "development" "/development" "Development")
        (nav-link "production" "/production" "Production")])]]])

(defn goog-require [module]
  (ph/javascript-tag (str "goog.require('" module "');")))

(defpartial layout [config environment]
  (ph/html5
   [:head
    [:title "{{capitalized}}"]
    [:meta {:http-equiv "Content-Type" :content "text/html; charset=UTF-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=7;IE=8;IE=edge"}]

    "<!--[if lt IE 9]>
        <script src=\"http://html5shiv.googlecode.com/svn/trunk/html5.js\"></script>
     <![endif]-->"
    (ph/include-css "/css/bootstrap.css"
                    "/css/{{name}}.css")]
   [:body (topbar environment)
    [:div.container-fluid]
    [:footer [:p "&copy; {{capitalized}} 2012"]]
    (if (= :development environment)
      (concat [(ph/include-js "javascripts/out/goog/base.js")
               (ph/include-js (str "javascripts/" (:dev-js-file-name config)))]
              (map ph/javascript-tag (:dev-js config)))
      (concat [(ph/include-js (str "javascripts/" (:prod-js-file-name config)))]
              (map ph/javascript-tag (:prod-js config))))]))
