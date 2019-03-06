package greedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentWeight;
    private long gold;
    private Map<String, Long> gems;
    private long totalGems;
    private Map<String, Long> cash;
    private long totalCahs;
    private boolean goldIsAdded;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentWeight = 0;
        this.gold = 0;
        this.gems = new HashMap<>();
        this.totalGems = 0;
        this.cash = new HashMap<>();
        this.totalCahs = 0;
        this.goldIsAdded=false;
    }

    public void addCash(String item, long quantity) {
        if (this.hasFreeCapacity(quantity) && this.totalGems >= this.totalCahs + quantity) {
            if (!this.cash.containsKey(item)) {
                this.cash.put(item, quantity);
            } else {
                this.cash.put(item, this.cash.get(item) + quantity);
            }
            this.totalCahs += quantity;
            this.currentWeight += quantity;
        }

    }

    private boolean hasFreeCapacity(long quantity) {
        return this.currentWeight + quantity <= this.capacity;
    }

    public void addGems(String item, long quantity) {
        if (this.hasFreeCapacity(quantity) && this.gold >= this.totalGems + quantity) {
            if (!this.gems.containsKey(item)) {
                this.gems.put(item, quantity);
            } else {
                this.gems.put(item, this.gems.get(item) + quantity);
            }
            this.totalGems += quantity;
            this.currentWeight += quantity;
        }
    }

    public void addGold(long quantity) {
        if (this.hasFreeCapacity(quantity)) {
            this.goldIsAdded=true;
            this.gold = quantity;
            this.currentWeight += quantity;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(this.goldIsAdded) {
            sb.append("<Gold> $").append(this.gold).append(System.lineSeparator());
            sb.append("##Gold - ").append(this.gold).append(System.lineSeparator());
        }
        if (this.gems.size() > 0) {
            sb.append("<Gem> $").append(this.totalGems).append(System.lineSeparator());
            this.gems.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = f.getValue().compareTo(s.getValue());
                }
                return result;
            }).forEach(entry -> {
                sb.append("##")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue())
                        .append(System.lineSeparator());
            });
        }
        if (this.cash.size() > 0) {
            sb.append("<Cash> $").append(this.totalCahs).append(System.lineSeparator());
            this.cash.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = f.getValue().compareTo(s.getValue());
                }
                return result;
            }).forEach(entry -> {
                sb.append("##")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue())
                        .append(System.lineSeparator());
            });
        }
        return sb.toString();
    }
}
