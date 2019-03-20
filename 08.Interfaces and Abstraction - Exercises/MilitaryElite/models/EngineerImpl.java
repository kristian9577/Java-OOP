package MilitaryElite.models;

import MilitaryElite.enumerations.Corp;
import MilitaryElite.interfaces.Engineer;
import MilitaryElite.interfaces.Private;
import MilitaryElite.interfaces.Repair;

import java.util.ArrayList;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append(this.getCorps())
        .append(System.lineSeparator()).append("Repairs:");
        for (Repair repair : this.repairs) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(repair.toString());
        }
        return sb.toString();
    }
}
