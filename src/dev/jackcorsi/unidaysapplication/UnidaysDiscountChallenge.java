package dev.jackcorsi.unidaysapplication;

import java.util.HashMap;

public class UnidaysDiscountChallenge {

    //Maps item IDs to quantity numbers
    private HashMap<Long, Integer> basket = new HashMap<>();
    private PriceRuleset rs;

    public UnidaysDiscountChallenge(PriceRuleset rs) {
        this.rs = rs;
    }

    public void addToBasket(long itemId) {
        int quantity = basket.getOrDefault(itemId, 0);
        basket.put(itemId, ++quantity);
    }

    public boolean removeOneFromBasket(long itemId) {
        Integer quantity = basket.get(itemId);
        if (quantity != null) {
            basket.put(itemId, --quantity);
            return true;
        }
        return false;
    }

    public int removeAllFromBasket(long itemId) {
        return basket.remove(itemId);
    }

    public Bill calculateTotalPrice() {
        return rs.getBill(basket);
    }
}
