package ru.shop.model;

import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private final long cost;
    private final ProductType productType;

    public Product(UUID id, String name, long cost, ProductType productType) {
        this.productType = productType;
        this.cost = cost;
        this.name = name;
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public long getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
