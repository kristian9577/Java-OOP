package hell.entities.heroes;
import hell.interfaces.Hero;

import java.util.Comparator;

public class HeroComparator implements Comparator<Hero> {

    @Override
    public int compare(Hero o1, Hero o2) {
        long thisSum = o1.getStrength() + o1.getAgility() + o1.getIntelligence();
        long otherSum = o2.getStrength() + o2.getAgility() + o2.getIntelligence();

        if (thisSum > otherSum) {
            return -1;
        }
        if (thisSum < otherSum) {
            return 1;
        }
        thisSum = o1.getHitPoints() + o1.getDamage();
        otherSum = o2.getHitPoints() + o2.getDamage();

        return Long.compare(thisSum, otherSum);
    }
}
