package dev.jackcorsi.unidaysapplication;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Represents a policy which is applied to a basket and modifies the price accordingly, such as a promotion
 */
public abstract class PriceRule implements Comparable<PriceRule> {

    /**The first possible priority value**/
    public static final int PRIORITY_FIRST = -98786598;

    /**Default for multibuy saving applied before overall basket totals**/
    public static final int PRIORITY_MULTIBUY_DEFAULT = 0;

    /**Default for rules applied to the entire basket/ bill total, such as delivery fees**/
    public static final int PRIORITY_ENTIRE_BASKET_DEFAULT = 987698;

    /**Returns the priority value associated with this rule. Rules should be applied in ascending order of priority.**/
    public abstract int getPriority();

    /**Applies the rule according to the contents of {@param basket}, updating {@param bill} as necessary **/
    public abstract void apply(Bill bill, Map<Long, Integer> basket);

    public int compareTo(PriceRule that) {
        return this.getPriority() - that.getPriority();
    }


    /**The default rule that should probably be applied to every basket.
     * Adds the sum of the item base prices to the bill **/
    public static PriceRule baseTotal = new PriceRule () {
        @Override
        public int getPriority() {
            return PRIORITY_FIRST;
        }

        @Override
        public void apply(Bill bill, Map<Long, Integer> basket) {
            basket.forEach((Long itemId, Integer quantity) -> {
                Item item = Item.byId(itemId);
                bill.addToItemTotal(item.getBasePrice().multiply(new BigDecimal(quantity)));
            });
        }
    };

    /**Default delivery charge, unless the item total is over a certain amount **/
    public static PriceRule deliveryOrFree = new PriceRule() {
        @Override
        public int getPriority() {
            return PRIORITY_ENTIRE_BASKET_DEFAULT;
        }

        @Override
        public void apply(Bill bill, Map<Long, Integer> basket) {
            if (!basket.isEmpty() && bill.getItemTotal().compareTo(new BigDecimal(50)) < 0) {
                bill.addToDelivery(new BigDecimal(7));
            }
        }
    };
}
