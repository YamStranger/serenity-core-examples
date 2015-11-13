package net.thucydides.showcase.junit.parallel;

import com.google.inject.Inject;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.UserStoryCode;
import net.thucydides.core.batches.BatchStrategy;
import net.thucydides.core.batches.UnsupportedBatchStrategyException;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * User: YamStranger
 * Date: 11/11/15
 * Time: 7:13 PM
 */
@RunWith(SerenityParameterizedRunner.class)
@UserStoryCode("US01")
@Concurrent
public class BachTestDataDriven {
    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{{1},{1},{1},{1}});
    }

    @Steps
    BachStepsDataDriven steps;
    private final int kilometersTravelled;

    public BachTestDataDriven(int kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    @Test
    public void shouldBeenRunInSeparatedThreads_1() {
        steps.initialization();
        steps.when_performing_action();
        steps.then_threads_count_should_be(4);
        System.out.println("Thread.currentThread="+Thread.currentThread());
    }

    @Test
    public void shouldBeenRunInSeparatedThreads_2() {
        steps.initialization();
        steps.when_performing_action();
        steps.then_threads_count_should_be(4);

    }

    @Test
    public void shouldBeenRunInSeparatedThreads_3() {
        steps.initialization();
        steps.when_performing_action();
        steps.then_threads_count_should_be(4);
        System.out.println("Thread.currentThread="+Thread.currentThread());

    }

    @Test
    public void shouldBeenRunInSeparatedThreads_4() {
        steps.initialization();
        steps.when_performing_action();
        steps.then_threads_count_should_be(4);
        System.out.println("Thread.currentThread="+Thread.currentThread());

    }
}
