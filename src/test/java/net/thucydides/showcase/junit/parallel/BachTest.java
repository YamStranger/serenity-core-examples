package net.thucydides.showcase.junit.parallel;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.UserStoryCode;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

/**
 * User: YamStranger
 * Date: 11/11/15
 * Time: 7:13 PM
 */
@RunWith(SerenityParameterizedRunner.class)
@UserStoryCode("US01")
@Concurrent
public class BachTest {
    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{{1}});
    }

    @Steps
    BachSteps steps;
    private final int kilometersTravelled;

    public BachTest(int kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    @Test
    public void shouldBeenRunInSeparatedThreads_1() {
        steps.initialization();
      //  steps.when_performing_action();
      //  steps.then_threads_count_should_be(4);
        System.out.println("Thread.currentThread="+Thread.currentThread());
    }
}
