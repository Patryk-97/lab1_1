package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.price, this.name, this.snapshotDate, this.type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return Objects.equals(id, other.getId())
               && Objects.equals(price, other.getPrice())
               && Objects.equals(name, other.getName())
               && Objects.equals(snapshotDate, other.getSnapshotDate())
               && Objects.equals(type, other.getType());
    }
}
