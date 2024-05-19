import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.numbers_reader.NumbersReader;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.DoubleStream;


public class LargeTests {
    final static int N_TRIES = 100;
    @ParameterizedTest(name = "Обработка {0} чисел")
    @ValueSource(ints = {1, 10, 100, 500, 1000, 5000, 10_000, 50_000, 100_000, 300_000, 500_000, 800_000, 1_000_000})
    void measureTimeTest(int number) throws IOException, URISyntaxException {
        final Path file = Path.of(SmallTests.class.getClassLoader().getResource(number + ".txt").toURI());

        ArrayList<Double> durations = new ArrayList<>();
        for (int i = 0; i < N_TRIES; i++) {
            NumbersReader numbersReader = new NumbersReader();
            long start = System.nanoTime();
            numbersReader.processFile(file);
            long end = System.nanoTime();
            double duration = (double) (end - start) / 1_000_000;
            durations.add(duration);
        }
        System.out.println(number + "; " + durations.stream().mapToDouble(d -> d).sum() / durations.size());
    }
}
