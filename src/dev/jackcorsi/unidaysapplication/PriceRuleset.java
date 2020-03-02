package dev.jackcorsi.unidaysapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * A collection of {@link PriceRule}s from which a {@link Bill} can be calculated for a basket
 */
public class PriceRuleset {

    private ArrayList<PriceRule> rules;
    private boolean sorted = false;

    public PriceRuleset(PriceRule... rules) {
        this.rules = new ArrayList<>(Arrays.asList(rules));
    }

    public PriceRuleset() {
        this.rules = new ArrayList<>();
    }

    public void addRules(PriceRule... rules) {
        sorted = false;
        Collections.addAll(this.rules, rules);
    }

    /**
     * Calculate the bill for a basket by applying each of the pricing rules in order of priority
     */
    public Bill getBill(Map<Long, Integer> basket) {
        if (!sorted) {
            Collections.sort(rules);
            sorted = true;
        }

        Bill bill = new Bill();

        for (PriceRule rule: rules)
            rule.apply(bill, basket);

        return bill;
    }
}
