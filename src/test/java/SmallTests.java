import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.numbers_reader.NumbersReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class SmallTests {
    @Test
    @DisplayName("Пустой файл")
    void emptyFile() throws IOException, URISyntaxException {
        final Path empty_file = Path.of(SmallTests.class.getClassLoader().getResource("empty_file.txt").toURI());
        NumbersReader reader = new NumbersReader(empty_file);
        assertThat(reader.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Одно число")
    void singleNumber() throws IOException, URISyntaxException {
        final Path one_number_file = Path.of(SmallTests.class.getClassLoader().getResource("one_number.txt").toURI());
        NumbersReader reader = new NumbersReader(one_number_file);
        assertThat(reader.isEmpty()).isFalse();
        assertThat(reader._max()).isEqualTo(1234);
        assertThat(reader._min()).isEqualTo(1234);
        assertThat(reader._sum()).isEqualTo(1234);
        assertThat(reader._mult()).isEqualTo(1234);
    }

    @Test
    @DisplayName("Два числа")
    void twoNumbers() throws IOException, URISyntaxException {
        final Path two_numbers_file = Path.of(SmallTests.class.getClassLoader().getResource("two_numbers.txt").toURI());
        NumbersReader reader = new NumbersReader(two_numbers_file);
        assertThat(reader.isEmpty()).isFalse();
        assertThat(reader._max()).isEqualTo(4321);
        assertThat(reader._min()).isEqualTo(1234);
        assertThat(reader._sum()).isEqualTo(1234 + 4321);
        assertThat(reader._mult()).isEqualTo(1234 * 4321);
    }

    @Test
    @DisplayName("4 числа")
    void fourNumbers() throws IOException, URISyntaxException {
        final Path four_numbers_file = Path.of(SmallTests.class.getClassLoader().getResource("four_numbers.txt").toURI());
        NumbersReader reader = new NumbersReader(four_numbers_file);
        assertThat(reader.isEmpty()).isFalse();
        assertThat(reader._max()).isEqualTo(4);
        assertThat(reader._sum()).isEqualTo(10);
        assertThat(reader._mult()).isEqualTo(24);
    }
}
