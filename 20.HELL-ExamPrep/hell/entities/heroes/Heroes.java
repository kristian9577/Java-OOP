package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Heroes implements Hero {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory heroInventory;

    protected Heroes(String name, int strength, int agility, int intelligence,
                     int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.heroInventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.heroInventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.heroInventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.heroInventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.heroInventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.heroInventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() {
        try {
            Field field = this.heroInventory.getClass()
                    .getDeclaredField("commonItems");
            field.setAccessible(true);
            return ((Map<String, Item>) field.get(this.heroInventory)).values();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public Collection<Item> getItems2() {
//        try {
//            Field[] fields = this.heroInventory.getClass()
//                    .getDeclaredFields();
//            Field field = null;
//            for (Field currentField : fields) {
//                if (currentField.isAnnotationPresent(ItemCollection.class)) {
//                    field = currentField;
//                    break;
//                }
//            }
//
//            field.setAccessible(true);
//            return ((Map<String, Item>) field.get(this.heroInventory)).values();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public void addItem(Item item) {
        this.heroInventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.heroInventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        String itemsString = this.getItems().isEmpty() ? "None" : "\n";

        List<String> itemsStringsIterable = this.getItems()
                .stream()
                .map(Objects::toString)
                .collect(Collectors.toList());

        itemsString += String.join("\n", itemsStringsIterable);

        return String.format("Hero: %s, Class: %s\n" +
                        "HitPoints: %d, Damage: %d\n" +
                        "Strength: %d\n" +
                        "Agility: %d\n" +
                        "Intelligence: %d\n" +
                        "Items: %s", this.getName(), this.getClass().getSimpleName(),
                this.getHitPoints(), this.getDamage(), this.getStrength(), this.getAgility(),
                this.getIntelligence(), itemsString);
    }
}
