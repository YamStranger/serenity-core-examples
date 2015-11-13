package net.thucydides.showcase.junit.parallel;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.batches.BatchStrategy;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.core.webdriver.SystemPropertiesConfiguration;

import java.util.HashSet;
import java.util.Set;

import static net.thucydides.core.ThucydidesSystemProperty.THUCYDIDES_BATCH_COUNT;
import static net.thucydides.core.ThucydidesSystemProperty.THUCYDIDES_BATCH_SIZE;
import static org.assertj.core.api.StrictAssertions.*;

/**
 * User: YamStranger
 * Date: 11/11/15
 * Time: 7:19 PM
 */
public class BachSteps {
    private static Set<Long> threads;

    public int register() {
        synchronized (BachTestDataDriven.class) {
            if (BachSteps.threads == null) {
                BachSteps.threads = new HashSet<>();
            }
            BachSteps.threads.add(Thread.currentThread().getId());
            return BachSteps.threads.size();
        }
    }

    @Step
    public void initialization() {
        register();
       Configuration configuration = new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
        EnvironmentVariables environmentVariables = configuration.getEnvironmentVariables();
 /*
        for (String name : environmentVariables.getProperties().stringPropertyNames()) {
            System.out.println(name + "=\"" + environmentVariables.getProperty(name) + "\"");
        }
*/
        assertThat(THUCYDIDES_BATCH_COUNT.integerFrom(environmentVariables, 0)).isGreaterThan(0);


/*        String batchManagerProperty = ThucydidesSystemProperty.THUCYDIDES_BATCH_STRATEGY.from(environmentVariables,
            BatchStrategy.DIVIDE_EQUALLY.name());

        int batchCountValue = THUCYDIDES_BATCH_SIZE.integerFrom(environmentVariables, 0);
        if (batchCountValue == 0) {
            batchCountValue = THUCYDIDES_BATCH_COUNT.integerFrom(environmentVariables, 0);
        }
        System.out.println("batchCountValue" + "=\"" + batchCountValue + "\"");*/
/*
        try {
            BatchManager batchManager = BatchStrategy.valueOf(batchManagerProperty).instance(environmentVariables);
        } catch (Exception e) {
            throw new UnsupportedBatchStrategyException(batchManagerProperty + " is not a supported batch strategy.", e);
        }*/

    }

    @Step
    public void when_performing_action() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Step
    public void then_threads_count_should_be(int value) {
        assertThat(BachSteps.threads.size()).isGreaterThan(value);
    }
}
