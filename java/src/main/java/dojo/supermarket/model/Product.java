package dojo.supermarket.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Product {
    private final String name;
    private final ProductUnit unit;

    public Product(String name, ProductUnit unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }


    public ProductUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        return o == this || (
                o != null && o.getClass() == this.getClass() && this.equals((Product) o)
        );
    }

    public boolean equals(@NotNull Product product) {
        return product == this || (
                product.getName().equals(this.name) && product.getUnit().equals(this.unit)
        );
    }



    @Override
    public int hashCode() {

        return Objects.hash(name, unit);
    }
}
