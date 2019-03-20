package MilitaryElite.inputOutput;

import MilitaryElite.application.Army;
import MilitaryElite.interfaces.Soldier;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputWriter {
    private BufferedWriter writer;

    public OutputWriter(OutputStreamWriter streamWriter) {
        this.writer = new BufferedWriter(streamWriter);
    }

    public void writeAll(Army army) throws IOException {
        for (Soldier soldier : army.getSoldiers()) {
            this.writer.write(soldier.toString()+System.lineSeparator());
        }
        this.writer.close();
    }
}
