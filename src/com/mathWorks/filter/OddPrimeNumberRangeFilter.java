package com.mathWorks.filter;

import java.util.List;

/**
 * Created by gsakhardande on 27/8/14.
 */
public class OddPrimeNumberRangeFilter extends CompositeNumberFilter {

    public OddPrimeNumberRangeFilter(List<NumberFilter> subFilters) {
        super(subFilters);
    }
}
