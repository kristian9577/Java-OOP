package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Inject;
import pr0304Barracks.contracts.Repository;


public class ReportCommand extends CommandImpl {

    @Inject
    private Repository repository;

    protected ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
