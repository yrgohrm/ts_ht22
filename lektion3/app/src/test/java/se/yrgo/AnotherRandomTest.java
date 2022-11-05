package se.yrgo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class AnotherRandomTest {
    @Test
    void someRandomTest() {
        Random rand = mock(Random.class);

        when(rand.nextInt(anyInt())).thenReturn(0);
        when(rand.nextInt(10)).thenReturn(5);
        when(rand.nextInt(intThat(n -> n > 1000))).thenReturn(500);

        assertThat(rand.nextInt(10)).isEqualTo(5);
        assertThat(rand.nextInt(2000)).isEqualTo(500);
        assertThat(rand.nextInt(10000)).isEqualTo(500);
        assertThat(rand.nextInt(1)).isZero();
        assertThat(rand.nextInt(567)).isZero();
    }

    @Test
    void someRandomTest2() {
        Random rand = mock(Random.class);

        when(rand.nextInt(anyInt())).thenReturn(0, 1, 2, 3);

        assertThat(rand.nextInt(10)).isZero();
        assertThat(rand.nextInt(10)).isEqualTo(1);
        assertThat(rand.nextInt(1)).isEqualTo(2);
        assertThat(rand.nextInt(5)).isEqualTo(3);

    }
}
