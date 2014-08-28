package com.mathWorks.filter;

import com.mathWorks.validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gsakhardande on 27/8/14.
 */
public class SimpleNumberFilter implements NumberFilter {

    private final NumberValidator numberValidator;

    public SimpleNumberFilter(NumberValidator numberValidator) {
        this.numberValidator = numberValidator;
    }

    @Override
    public List<Integer> filter(List<Integer> inputNumbers) {
        List<Integer> outputNumbers = new ArrayList<>();
        for (Integer inputNumber : inputNumbers) {
            if(numberValidator.isValid(inputNumber)) {
                outputNumbers.add(inputNumber);
            }
        }
        return outputNumbers;
    }
}
