(ns curso.module2.db)

(def order1 {
             :user 15
             :itens {:backpack { :id :backpack :count 1 :price 50}
                     :tshirt { :id :tshirt :count 1 :price 50}
                     :shoes { :id :shoes :count 1 }}})

(def order2 {
             :user 15
             :itens {:backpack { :id :backpack :count 1 :price 50}
                     :tshirt { :id :tshirt :count 1 :price 50}
                     :shoes { :id :shoes :count 1 }}})

(def order3 {
             :user 10
             :itens {:backpack { :id :backpack :count 2 :price 80}
                     :tshirt { :id :tshirt :count 3 :price 40}
                     :shoes { :id :shoes :count 1 }}})

(def order4 {
             :user 5
             :itens {:backpack { :id :backpack :count 2 :price 80}
                     :tshirt { :id :tshirt :count 3 :price 40}
                     :shoes { :id :shoes :count 1 }}})

(def order5 {
             :user 20
             :itens {:backpack { :id :backpack :count 20 :price 80}}})

(defn all-orders []
  [order1 order2 order3 order4 order5])
