package com.mathWorks.validator;

/**
 * Created by gsakhardande on 27/8/14.
 */
public class NumberInRangeValidator implements NumberValidator {

    private final int lowerBound;
    private final int upperBound;

    public NumberInRangeValidator(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean isValid(int number) {
        return number >= lowerBound && number <= upperBound;
    }
}
