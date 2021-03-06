/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class OfferItem {

    // product
    private Product product;

    private int quantity;

    private Money totalCost;

    // discount
    private String discountCause;

    private Money discount;

    public OfferItem(Product product, int quantity) {
        this(product, quantity, null, null);
    }

    public OfferItem(Product product, int quantity, Money discount, String discountCause) {
        this.product = product;

        this.quantity = quantity;
        this.discount = discount;
        this.discountCause = discountCause;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.add(discount.getDenomination());
        }

        this.totalCost.setDenomination(product.getPrice()
                                              .getDenomination()
                                              .multiply(new BigDecimal(quantity))
                                              .subtract(discountValue));
    }

    public Product getProduct() {
        return this.product;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public Money getDiscount() {
        return discount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discount, discountCause, product, quantity, totalCost);
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
        OfferItem other = (OfferItem) obj;
        return Objects.equals(discount, other.discount)
               && Objects.equals(discountCause, other.discountCause)
               && Objects.equals(product, other.product)
               && quantity == other.quantity
               && Objects.equals(totalCost, other.totalCost);
    }

    /**
     *
     * @param item
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (this.product.getPrice()
                        .getDenomination() == null) {
            if (other.getProduct()
                     .getPrice()
                     .getDenomination() != null) {
                return false;
            }
        } else if (!this.product.getPrice()
                                .getDenomination()
                                .equals(other.getProduct()
                                             .getPrice()
                                             .getDenomination())) {
            return false;
        }
        if (this.product.getName() == null) {
            if (other.getProduct()
                     .getName() != null) {
                return false;
            }
        } else if (!this.product.getName()
                                .equals(other.getProduct()
                                             .getName())) {
            return false;
        }

        if (this.product.getId() == null) {
            if (other.getProduct()
                     .getId() != null) {
                return false;
            }
        } else if (!this.product.getId()
                                .equals(other.getProduct()
                                             .getId())) {
            return false;
        }
        if (this.product.getType() == null) {
            if (other.getProduct()
                     .getType() != null) {
                return false;
            }
        } else if (!this.product.getType()
                                .equals(other.getProduct()
                                             .getType())) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = this.totalCost.getDenomination();
            min = other.getTotalCost()
                       .getDenomination();
        } else {
            max = other.getTotalCost()
                       .getDenomination();
            min = this.totalCost.getDenomination();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
