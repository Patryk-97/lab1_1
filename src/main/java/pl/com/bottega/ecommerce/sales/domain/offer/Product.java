package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {

    private String id;

    private Money price;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String id, Money price, String name, Date snapshotDate, String type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getProductId() {
        return this.id;
    }

    public Money getProductPrice() {
        return this.price;
    }

    public String getProductName() {
        return this.name;
    }

    public Date getProductSnapshotDate() {
        return this.snapshotDate;
    }

    public String getProductType() {
        return this.type;
    }
}
