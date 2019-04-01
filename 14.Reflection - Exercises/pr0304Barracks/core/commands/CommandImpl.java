package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;

public abstract class CommandImpl implements Executable {
    private String[] data;

    protected CommandImpl(String[] data) {
        this.data = data;

    }

    protected String[] getData() {
        return data;
    }

}
