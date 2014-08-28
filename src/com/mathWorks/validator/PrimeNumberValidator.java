package com.mathWorks.validator;

/**
 * Created by gsakhardande on 27/8/14.
 */
public class PrimeNumberValidator implements NumberValidator {

    @Override
    public boolean isValid(int number) {
        boolean isPrime = true;
        if(number == 0 || number == 1) {
            return false;
        }
        for(int i=number/2; i >= 2; i--) {
            if(number%i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
}
