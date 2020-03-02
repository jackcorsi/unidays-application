package dev.jackcorsi.unidaysapplication;

import java.math.BigDecimal;

public class Bill {

    private BigDecimal itemTotal = new BigDecimal(0);
    private BigDecimal delivery = new BigDecimal(0);

    public BigDecimal getItemTotal() {
        return itemTotal;
    }

    public BigDecimal getDeliveryCharge() {
        return delivery;
    }

    public BigDecimal getTotal() {
        return itemTotal.add(delivery);
    }

    public void negateItemTotal() {
        itemTotal = new BigDecimal(0);
    }

    public void negateDeliveryCharge() {
        delivery = new BigDecimal(0);
    }

    public BigDecimal subtractFromItemTotal(BigDecimal sub) {
        return itemTotal = itemTotal.subtract(sub);
    }

    public BigDecimal addToItemTotal(BigDecimal add) {
        return itemTotal = itemTotal.add(add);
    }

    public BigDecimal subtractFromDelivery(BigDecimal sub) {
        return delivery = delivery.subtract(sub);
    }

    public BigDecimal addToDelivery(BigDecimal add) {
        return delivery = delivery.add(add);
    }
}
