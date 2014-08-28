package com.mathWorks;

import com.mathWorks.filter.*;
import com.mathWorks.validator.NumberInRangeValidator;
import com.mathWorks.validator.OddNumberValidator;
import com.mathWorks.validator.PrimeNumberValidator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by gsakhardande on 27/8/14.
 */
public class MathWorksTest {

    @Test
    public void itFiltersOutPrimeNumbers() {

        // Given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<Integer> expectedPrimeNumbers = Arrays.asList(2, 3, 5, 7, 11, 13);

        PrimeNumberFilter primeNumberFilter = new PrimeNumberFilter(new PrimeNumberValidator());

        // When
        List<Integer> primeNumbers = primeNumberFilter.filter(inputNumbers);

        // Then
        assertEquals(expectedPrimeNumbers, primeNumbers);
    }

    @Test
    public void itFiltersOutOddNumbers() {

        // Given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<Integer> expectedOddNumbers = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15);

        OddNumberFilter oddNumberFilter = new OddNumberFilter(new OddNumberValidator());

        // When
        List<Integer> oddNumbers = oddNumberFilter.filter(inputNumbers);

        // Then
        assertEquals(expectedOddNumbers, oddNumbers);
    }

    @Test
    public void itFiltersOutOddPrimeNumbers() {

        // Given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<Integer> expectedOddPrimeNumbers = Arrays.asList(3, 5, 7, 11, 13);

        OddNumberFilter oddNumberFilter = new OddNumberFilter(new OddNumberValidator());

        PrimeNumberFilter primeNumberFilter = new PrimeNumberFilter(new PrimeNumberValidator());

        List<NumberFilter> subfilters = new ArrayList<>();
        subfilters.add(oddNumberFilter);
        subfilters.add(primeNumberFilter);

        OddPrimeNumberFilter oddPrimeNumberFilter = new OddPrimeNumberFilter(subfilters);

        // When
        List<Integer> oddPrimeNumbers = oddPrimeNumberFilter.filter(inputNumbers);

        // Then
        assertEquals(expectedOddPrimeNumbers, oddPrimeNumbers);
    }

    @Test
    public void itFiltersOutNumbersInARange() {

        // Given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<Integer> expectedNumbersInRange = Arrays.asList(5, 6, 7, 8, 9, 10);

        int lowerBound = 5;
        int upperBound = 10;
        NumberRangeFilter numberRangeFilter = new NumberRangeFilter(new NumberInRangeValidator(lowerBound, upperBound));

        //When
        List<Integer> numbersInRange = numberRangeFilter.filter(inputNumbers);

        // Then
        assertEquals(expectedNumbersInRange, numbersInRange);
    }

    @Test
    public void itFiltersOutOddPrimeNumbersInARange() {

        // Given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35);
        List<Integer> expectedOddPrimeNumbersInRange = Arrays.asList(3, 5, 7, 11, 13, 17, 19, 23, 29, 31);

        OddNumberFilter oddNumberFilter = new OddNumberFilter(new OddNumberValidator());

        PrimeNumberFilter primeNumberFilter = new PrimeNumberFilter(new PrimeNumberValidator());

        int lowerBound = 2;
        int upperBound = 31;
        NumberRangeFilter numberRangeFilter = new NumberRangeFilter(new NumberInRangeValidator(lowerBound, upperBound));

        List<NumberFilter> subFilters = new ArrayList<>();
        subFilters.add(oddNumberFilter);
        subFilters.add(primeNumberFilter);
        subFilters.add(numberRangeFilter);

        OddPrimeNumberRangeFilter oddPrimeNumberRangeFilter = new OddPrimeNumberRangeFilter(subFilters);

        // When
        List<Integer> oddPrimeNumbersInRange = oddPrimeNumberRangeFilter.filter(inputNumbers);

        // Then
        assertEquals(expectedOddPrimeNumbersInRange, oddPrimeNumbersInRange);
    }
}
