package se.yrgo;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void canLevelUpMax() {
        ItemContainer dummy = new ItemContainer() {
            public Item get(int index) {
                return null;
            }

            public int put(Item i) {
                return 0;
            }

            public int size() {
                return 0;
            }
        };

        Player p = new Player(dummy, 40);
        assertThat(p.levelUp()).isEqualTo(40);
    }
}
