package dev.jackcorsi.unidaysapplication;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * An instance of this class represents a type of item that can be purchased. Item types can be created and queried
 * using the static methods.
 */
public class Item {

    private long id;
    private String name;
    private BigDecimal basePrice;

    private Item(long id, String name, BigDecimal basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    public long getId() {return id;}
    public String getName() {return name;}
    public BigDecimal getBasePrice() {return basePrice;}


    private static long nextId = Long.MIN_VALUE;
    private static HashMap<Long, Item> idMap = new HashMap<>();
    private static HashMap<String, Item> nameMap = new HashMap<>();

    /**
     * Constructs an Item with the given parameters and updates the internal maps which will allow it to be fetched
     * by its id or name. The Item's name will be auto-generated and can be accessed with {@link #getId()}
     * @param name The unique name for the item
     * @param basePrice the item's base price
     * @return The created Item
     */
    public static Item create(String name, BigDecimal basePrice) {
        long id = nextId++;
        Item item = new Item(id, name, basePrice);

        idMap.put(id, item);
        if (nameMap.containsKey(name)) {
            throw new RuntimeException("Attempted to create a second item called \"" + name
                    + "\". Item names must be unique");
        }
        nameMap.put(name, item);

        return item;
    }

    /**
     * Retrieves a reference to an Item previously created with {@link #create(String, BigDecimal)} by its assigned id
     * @return The item or null if it does not exist
     */
    public static Item getById(long id) {
        return idMap.get(id);
    }

    /**
     * As {@link #getById(long)}, but will throw a {@link RuntimeException} if the item does not exist
     * @return The Item, or death
     */
    public static Item byId(long id) {
        Item item = idMap.get(id);
        if (item == null)
            throw new RuntimeException("No matching item for id " + id + " .");
        else
            return item;
    }

    /**
     * Retrieves a reference to an Item previously created with {@link #create(String, BigDecimal)} by its unique name
     * @return The item or null if it does not exist
     */
    public static Item getByName(String name) {
        return nameMap.get(name);
    }

    /**
     * As {@link #getByName(String)}, but will throw a {@link RuntimeException} if the item does not exist
     * @return The Item, or death
     */
    public static Item byName(String name) {
        Item item = nameMap.get(name);
        if (item == null)
            throw new RuntimeException("No matching item with the name " + name + " .");
        else
            return item;
    }
}
