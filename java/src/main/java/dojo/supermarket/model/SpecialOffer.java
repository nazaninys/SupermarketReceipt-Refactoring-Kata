package dojo.supermarket.model;

public abstract class SpecialOffer {
    private SpecialOfferType specialOfferType;
    protected int typeNumber;
    private String description;

    public SpecialOffer(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public abstract String getDescription(double argument);

    public abstract double calculateDiscountAmount(double quantity, double unitPrice, double argument);

    public boolean hasDiscount(double quantity) {
        int quantityAsInt = (int) quantity;
        if (quantityAsInt < typeNumber)
            return false;
        else
            return true;
    }

    public double getDiscountAmount(double quantity, double unitPrice, double argument) {
        if (!hasDiscount(quantity))
            return 0;
        else
            return calculateDiscountAmount(quantity, unitPrice, argument);
    }

}
