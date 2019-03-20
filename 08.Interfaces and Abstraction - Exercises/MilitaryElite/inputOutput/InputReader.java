package MilitaryElite.inputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    private BufferedReader reader;
    private final String END_STRING;

    public InputReader(InputStreamReader inputStreamReader, String end_string) {
        this.reader = new BufferedReader(inputStreamReader);
        END_STRING = end_string;
    }

    public List<String> readAllLines() throws IOException {
        List<String> lines = new ArrayList<>();

        String input = reader.readLine();

        while (!input.equals(this.END_STRING)) {
           lines.add(input);
            input = reader.readLine();
        }
        return lines;
    }
}
