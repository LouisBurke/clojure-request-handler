(ns webdev.item.handler
  (:require [webdev.item.model :refer [create-item
                                       read-item
                                       update-item
                                       delete-item]]))

(defn handle-index-items [req]
  (let [db (:webdev/db req)
        items (read-item db)]
    {:status 200
     :headers {}
     :body (str "<html><head></head><body><div>"
                (mapv :name items)
                "</div><form method=\"POST\" action=\"/request\">"
                "<input type=\"text\" name=\"name\" placeholder=\"name\">"
                "<input type=\"text\" name=\"description\" placeholder=\"description\">"
                "<input type=\"submit\">"
                "</body></html>")}))
