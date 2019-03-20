package MilitaryElite.models;

import MilitaryElite.enumerations.Corp;
import MilitaryElite.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corp corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return "Corps: " + this.corps.toString();
    }
}
