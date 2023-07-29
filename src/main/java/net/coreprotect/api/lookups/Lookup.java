package net.coreprotect.api.lookups;

import java.util.List;


/**
 * Interface that is responsible for the functionality of any class that requires queries to the CO database.
 */
public interface Lookup {
    /**
     * Performs the requested lookup.
     * @return A list of parseable lookup results as String arrays.
     */
    List<String[]> performLookup();
    void setLookupTime(long lookupTimeInMilliseconds);
}
