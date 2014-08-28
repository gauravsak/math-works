package com.mathWorks.filter;

import java.util.List;

/**
 * Created by gsakhardande on 27/8/14.
 */
public class CompositeNumberFilter implements NumberFilter {

    private final List<NumberFilter> subFilters;

    public CompositeNumberFilter(List<NumberFilter> subFilters) {
        this.subFilters = subFilters;
    }

    @Override
    public List<Integer> filter(List<Integer> inputNumbers) {
        List<Integer> outputNumbers = inputNumbers;
        for(NumberFilter subFilter : subFilters) {
            outputNumbers = subFilter.filter(outputNumbers);
        }
        return outputNumbers;
    }
}
