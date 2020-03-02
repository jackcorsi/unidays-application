package dev.jackcorsi.unidaysapplication;

import java.util.*;

/**
 * A collection of {@link PriceRule}s from which a {@link Bill} can be calculated for a basket
 */
public class PriceRuleset {

    private SortedSet<PriceRule> rules;

    public PriceRuleset(PriceRule... rules) {
        this.rules = new TreeSet<PriceRule>(Arrays.asList(rules));
    }

    public PriceRuleset() {
        this.rules = new TreeSet<>();
    }

    public void addRules(PriceRule... rules) {
        this.rules.addAll(Arrays.asList(rules));
    }

    /**
     * Calculate the bill for a basket by applying each of the pricing rules in order of priority
     */
    public Bill getBill(Map<Long, Integer> basket) {
        Bill bill = new Bill();

        for (PriceRule rule : rules) {
            rule.apply(bill, basket);
        }

        return bill;
    }
}
