package hell.entities;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.HeroComparator;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Manager;
import hell.interfaces.Recipe;

import java.util.*;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {

    private Map<String, Hero> localHeroes;

    public ManagerImpl() {
        this.localHeroes = new HashMap<>();
    }

    @Override
    public String addHero(List<String> arguments) {
        String name = arguments.get(0);
        String type = arguments.get(1);

        Hero result = null;


        switch (type) {
            case "Barbarian":
                result = new Barbarian(name);
                break;
            case "Wizard":
                result = new Wizard(name);
                break;
            case "Assassin":
                result = new Assassin(name);
        }
        localHeroes.put(name, result);
        return String.format("Created %s - %s", type, name);
    }

    @Override
    public String addItem(List<String> arguments) {
        String itemName = arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus = Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPoints = Integer.parseInt(arguments.get(6));
        int damage = Integer.parseInt(arguments.get(7));


        Item common = new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPoints, damage);
        Hero current = this.localHeroes.get(heroName);
        current.addItem(common);

        return String.format("Added item - %s to Hero - %s", itemName, heroName);
    }

    @Override
    public String addRecipe(List<String> arguments) {
        String itemName = arguments.get(1);
        String heroName = arguments.get(2);
        int strengthBonus = Integer.parseInt(arguments.get(3));
        int agilityBonus = Integer.parseInt(arguments.get(4));
        int intelligenceBonus = Integer.parseInt(arguments.get(5));
        int hitPoints = Integer.parseInt(arguments.get(6));
        int damage = Integer.parseInt(arguments.get(7));
        List<String> requiredItems = arguments
                .stream()
                .skip(8)
                .collect(Collectors.toList());


        Recipe recipe = new RecipeItem(itemName, strengthBonus, agilityBonus,
                intelligenceBonus, hitPoints, damage, requiredItems);

        Hero current = this.localHeroes.get(heroName);
        current.addRecipe(recipe);

        return String.format("Added recipe - %s to Hero - %s", itemName, heroName);
    }

    @Override
    public String inspect(List<String> arguments) {
        Hero hero = this.localHeroes.get(arguments.get(1));

        return hero.toString();
    }

    @Override
    public String quit() {
        HeroComparator heroComparator = new HeroComparator();
        List<Hero> ordered = this.localHeroes.values().stream()
                .sorted(heroComparator)
                .collect(Collectors.toList());
        int index = 1;
        StringBuilder sb = new StringBuilder();
        for (Hero hero : ordered) {
            sb
                    .append(index)
                    .append(". ")
                    .append(hero.toString())
                    .append(System.lineSeparator());
            index++;
        }
        return sb.toString();
    }
}
