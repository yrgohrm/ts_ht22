package se.yrgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.images.builder.Transferable;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import redis.clients.jedis.JedisPooled;

@Testcontainers
class GenericTest {

    private static final int REDIS_PORT = 6379;

    private static Logger logger = LoggerFactory.getLogger(GenericTest.class);

    @Container
    private GenericContainer<?> redis;

    @Container
    private GenericContainer<?> containerOne = new GenericContainer<>("redis:7.0.5");

    @Container
    private GenericContainer<?> containerTwo =
            new GenericContainer<>("redis:7.0.5").dependsOn(containerOne);

    public GenericTest() {
        try {
            byte[] data = GenericTest.class.getClassLoader().getResourceAsStream("redis.conf")
                    .readAllBytes();
            this.redis = new GenericContainer<>("redis:7.0.5").withExposedPorts(REDIS_PORT)
                    .withLogConsumer(new Slf4jLogConsumer(logger)).withEnv("SOMEENV", "SOMEVALUE")
                    .withSharedMemorySize(500L * 1024 * 1024)
                    .withCopyToContainer(Transferable.of(data), "/redis.conf")
                    .withCommand("redis-server /redis.conf");
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Test
    void testUsingRedis() {
        try (JedisPooled jedis =
                new JedisPooled(redis.getHost(), redis.getMappedPort(REDIS_PORT))) {
            final String name = "Bosse Bredsladd";
            jedis.set("employeeOfTheMonth", name);
            assertEquals(name, jedis.get("employeeOfTheMonth"));
        }
    }
}
