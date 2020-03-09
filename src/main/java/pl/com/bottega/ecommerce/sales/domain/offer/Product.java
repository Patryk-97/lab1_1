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

    public String getId() {
        return this.id;
    }

    public Money getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public Date getSnapshotDate() {
        return this.snapshotDate;
    }

    public String getType() {
        return this.type;
    }
}
