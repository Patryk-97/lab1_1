package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private String id;

    private BigDecimal price;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String id, BigDecimal price, String name, Date snapshotDate, String type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getProductId() {
        return this.id;
    }

    public BigDecimal getProductPrice() {
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
