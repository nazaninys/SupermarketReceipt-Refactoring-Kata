package dojo.supermarket.model;

public abstract class SpecialOffer {
    private SpecialOfferType specialOfferType;
    private int typeNumber;
    private String description;

    public int getTypeNumber() {
        return typeNumber;
    }

    public abstract String getDescription(double argument);

    public abstract double calculateDiscountAmount(double quantity, double unitPrice, double argument);


}
