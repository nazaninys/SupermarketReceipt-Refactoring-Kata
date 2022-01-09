package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private final List<ProductQuantity> items = new ArrayList<>();
    Map<Product, Double> productQuantities = new HashMap<>();


    List<ProductQuantity> getItems() {
        return new ArrayList<>(items);
    }

    void addItem(Product product) {
        this.addItemQuantity(new ProductQuantity(product, 1.0));
    }

    Map<Product, Double> productQuantities() {
        return productQuantities;
    }


    public void addItemQuantity(ProductQuantity pq) {
        items.add(new ProductQuantity(pq.getProduct(), pq.getQuantity()));
        if (productQuantities.containsKey(pq.getProduct())) {
            productQuantities.put(pq.getProduct(), productQuantities.get(pq.getProduct()) + pq.getQuantity());
        } else {
            productQuantities.put(pq.getProduct(), pq.getQuantity());
        }
    }

    void handleOffers(Receipt receipt, Map<Product, Offer> offers, SupermarketCatalog catalog) {
        for (Product p: productQuantities().keySet()) {
            if (offers.containsKey(p)) {
                Offer offer = offers.get(p);
                Discount discount = offer.getDiscount(p, productQuantities.get(p), catalog.getUnitPrice(p));
                receipt.addDiscount(discount);
            }
        }
    }
}
