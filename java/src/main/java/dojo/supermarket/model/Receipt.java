package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ReceiptItem> items = new ArrayList<>();
    private List<Discount> discounts = new ArrayList<>();

    public Double getTotalPrice() {
        double total = items.stream().mapToDouble(i -> i.getTotalPrice()).sum();
        total += discounts.stream().mapToDouble(i -> i.getDiscountAmount()).sum();
        return total;
    }

    public void addProduct(Product p, double quantity, double price, double totalPrice) {
        this.items.add(new ReceiptItem(p, quantity, price, totalPrice));
    }

    public List<ReceiptItem> getItems() {
        return new ArrayList<>(this.items);
    }

    public void addDiscount(Discount discount) {
        if (discount != null)
            this.discounts.add(discount);
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
