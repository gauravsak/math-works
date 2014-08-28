package com.mathWorks.filter;

import java.util.List;

/**
 * Created by gsakhardande on 27/8/14.
 */
public class OddPrimeNumberFilter extends CompositeNumberFilter {

    public OddPrimeNumberFilter(List<NumberFilter> subFilters) {
        super(subFilters);
    }

}
