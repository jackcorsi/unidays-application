package dev.jackcorsi.unidaysapplication;

import java.math.BigDecimal;
import java.util.Map;

/**
 * A bunch of {@link Item}s and associated promotional discounts for testing the basket system
 */
public class TestItems {

    //These are the example items given in the brief

    public static Item itemA = Item.create("A", new BigDecimal(8));

    public static Item itemB = Item.create("B", new BigDecimal(12));
    public static PriceRule itemBDefaultPromotion = new PriceRule() {
        @Override
        public int getPriority() {
            return PriceRule.PRIORITY_MULTIBUY_DEFAULT;
        }

        @Override
        public void apply(Bill bill, Map<Long, Integer> basket) {
            System.out.println("item B");
            Integer quantity = basket.get(itemB.getId());
            if (quantity != null) {
                BigDecimal pairs = new BigDecimal(quantity / 2);
                bill.subtractFromItemTotal(itemB.getBasePrice().multiply(pairs).multiply(new BigDecimal(2)));
                bill.addToItemTotal(pairs.multiply(new BigDecimal(20)));
            }
        }
    };

    public static Item itemC = Item.create("C", new BigDecimal(4));
    public static PriceRule itemCDefaultPromotion = new PriceRule() {
        @Override
        public int getPriority() {
            return PriceRule.PRIORITY_MULTIBUY_DEFAULT;
        }

        @Override
        public void apply(Bill bill, Map<Long, Integer> basket) {
            System.out.println("item C");
            Integer quantity = basket.get(itemC.getId());
            if (quantity != null) {
                BigDecimal triples = new BigDecimal(quantity / 3);
                bill.subtractFromItemTotal(itemC.getBasePrice().multiply(triples).multiply(new BigDecimal(3)));
                bill.addToItemTotal(triples.multiply(new BigDecimal(10)));
            }
        }
    };

    public static Item itemD = Item.create("D", new BigDecimal(7));
    public static PriceRule itemDDefaultPromotion = new PriceRule() {
        @Override
        public int getPriority() {
            return PriceRule.PRIORITY_MULTIBUY_DEFAULT;
        }

        @Override
        public void apply(Bill bill, Map<Long, Integer> basket) {
            System.out.println("item D");
            Integer quantity = basket.get(itemD.getId());
            if (quantity != null) {
                BigDecimal pairs = new BigDecimal(quantity / 2);
                bill.subtractFromItemTotal(itemD.getBasePrice().multiply(pairs));
            }
        }
    };

    public static Item itemE = Item.create("E", new BigDecimal(5));
    public static PriceRule itemEDefaultPromotion = new PriceRule() {
        @Override
        public int getPriority() {
            return PriceRule.PRIORITY_MULTIBUY_DEFAULT;
        }

        @Override
        public void apply(Bill bill, Map<Long, Integer> basket) {
            System.out.println("item E");
            Integer quantity = basket.get(itemE.getId());
            if (quantity != null) {
                BigDecimal triples = new BigDecimal(quantity / 3);
                bill.subtractFromItemTotal(itemE.getBasePrice().multiply(triples));
            }
        }
    };

    /**
     * Contains all of the itemDefaultPromotions to go with the items
     */
    public static final PriceRule[] DEFAULT_PROMOTIONS = {
            itemBDefaultPromotion,
            itemCDefaultPromotion,
            itemDDefaultPromotion,
            itemEDefaultPromotion
    };
}
