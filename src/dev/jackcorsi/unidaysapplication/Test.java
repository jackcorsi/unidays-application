package dev.jackcorsi.unidaysapplication;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        PriceRuleset rs = new PriceRuleset(PriceRule.baseTotal, PriceRule.deliveryOrFree);
        rs.addRules(TestItems.DEFAULT_PROMOTIONS);

        while (stdin.hasNextLine()) {
            String line = stdin.nextLine().trim(); //Accept the item names in one line as they are in the table in the brief

            UnidaysDiscountChallenge ud = new UnidaysDiscountChallenge(rs);

            for (int i = 0; i < line.length(); i++) {
                String name = String.valueOf(line.charAt(i));
                Item item = Item.getByName(name);
                if (item != null) {
                    ud.addToBasket(item.getId());
                } else {
                    System.out.println("Couldn't find an item with the name \"" + name + "\". Aborting.");
                    return;
                }
            }

            System.out.println("All items added");
            Bill bill = ud.calculateTotalPrice();
            System.out.println("The total basket price was £" + bill.getItemTotal());
            System.out.println("With a delivery fee of £" + bill.getDeliveryCharge());
            System.out.println("");
        }
    }

}
