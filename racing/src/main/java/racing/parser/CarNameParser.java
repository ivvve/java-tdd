package racing.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {
    private final String delimiter;

    public CarNameParser(String delimiter) {
        this.delimiter = delimiter;
    }

    public List<String> parse(String source) {
        return Arrays.stream(source.split(this.delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
