package com.ap.pre.tesco;

import java.util.*;

enum Categroy {
    PARACETAMOL,
    ANALGESIC,
    CHOCOLATE
}

class Item {
    private final int productId;
    private final Categroy categroy;
    private  int quantity;

    public Item(Categroy categroy, int productId, int quantity) {
        this.categroy = categroy;
        this.productId = productId;
        this.quantity = quantity;
    }

    public void incrementQuatity() {
        this.quantity++;
    }

    public int getProductId() {
        return productId;
    }

    public Categroy getCategroy() {
        return categroy;
    }

    public int getQuantity() {
        return quantity;
    }

}

abstract class Rule {
    abstract boolean evaluate(Cart cart);
}

class BulkBuyLimitRule extends  Rule {

    @Override
    boolean evaluate(Cart cart) {
        HashMap<Categroy,Integer> map = new HashMap<>();
        cart.getItems().forEach(item -> {
            map.put(item.getCategroy(), map.getOrDefault(item.getCategroy(), 0)+item.getQuantity());
        });

        boolean res = true;
        System.out.println(map.toString());
        for(Categroy c: map.keySet()) {
            res  = res && (map.get(c) <= 10);
        }

        return res;
    }
    
}

class BulkBuyLimitParacetalmol extends Rule {

    @Override
    boolean evaluate(Cart cart) {
        int totalQuantity = 0;
        for(Item i: cart.getItems()) {
            if(i.getCategroy() == Categroy.PARACETAMOL)
                totalQuantity += i.getQuantity();
        }
        return totalQuantity <= 5;
    }

}

class RuleEngine extends Rule {

    private List<Rule> rules = Arrays.asList(new BulkBuyLimitParacetalmol(), new BulkBuyLimitRule());

    @Override
    boolean evaluate(Cart cart) {
        boolean res = true;
        for(Rule r: rules) {
            res = res && r.evaluate(cart);
        }
        return res;
    }

}



class Cart {
    private List<Item> items = new ArrayList<>();

    public Cart(List<Item> items) {
        this.items= items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}


public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart(Arrays.asList(new Item(Categroy.PARACETAMOL,1,2),
        new Item(Categroy.ANALGESIC,2,3),
        new Item(Categroy.CHOCOLATE,3,8),
        new Item(Categroy.PARACETAMOL,4,3)
        ));

        System.out.println(new RuleEngine().evaluate(cart));
        
    }
    
}



/*
 * 
 * 
  Tesco gets millions of orders every day with an average basket size of 100 items.
    Tesco Business has got some regulations around selling products online and in stores.
    These regulations are mandatory from legal and business perspective to enforce for all order transactions.
        You are given an order with a list of products in the shopping cart/basket with productid, product Category and quantity. And also, Restriction Rules on Qty and Qty/Category.
        Example:
        Ordered items in the shopping cart/basket
        Item-1 -> productid=1, category=Paracetamol, quantity=3
        Item-2 -> productid=2, category=analgesic, quantity=3
        Item-3 -> productid=3, category=chocolate, quantity=8
        Item-4 -> productid=4, category= Paracetamol, quantity=2

        Business Restriction rules:
        Cannot buy more than 10 Quantity of any products - BulkBuyLimit
        Cannot buy more than 5 Quantity of paracetamol products – BulkBuyLimitCategory

        Write a restriction rule engine to run the restriction check against the shopping cart/basket and return the status as to MET/BREACHED indicating restriction
        status for the given restriction rules.
        For the above given example, the restriction status returned would be MET.
 * 
 * 
 */