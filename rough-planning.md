# Required
## `UnidaysDiscountChallenge`
`addToBasket` adds an item

`calculateTotalPrice` returns a `Bill`

`UnidaysDiscountChallenge(PriceRuleSet r)`

## `Bill`
`getTotalPrice()`

`getDeliveryCharge()`

# Implementation
## `PriceRuleset`
`addRule(PriceRule r)`

`getBill(Map<long, int>)`

Internal priority queue?

## `Item`

`static Item create(String name, BigDecimal basePrice)`

`static Item getById(long id)`

`static Item getByName(String name)`

`long getId()`

`String getName()`

## `PriceRule`

`abstract void apply(BigDecimal basketPrice, Map<long, int> basket)`

`abstract int getPriority()`