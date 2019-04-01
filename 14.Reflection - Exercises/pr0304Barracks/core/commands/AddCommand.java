package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class AddCommand extends CommandImpl {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        this.repository.addUnit(this.unitFactory.createUnit(this.getData()[1]));

        return this.getData()[1] + " added!";
    }
}
