package com.mathWorks.validator;

/**
 * Created by gsakhardande on 27/8/14.
 */
public class OddNumberValidator implements NumberValidator {

    @Override
    public boolean isValid(int number) {
        return number % 2 != 0;
    }
}
