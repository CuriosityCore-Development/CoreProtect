package net.coreprotect.api.lookups;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that represents the generalisation of a lookup within the CoreProtect plugin.
 */
public abstract class BaseLookup implements Lookup{
    /**
     * The range of time, in milliseconds, to lookup.
     */
    protected long lookupTimeInMilliseconds;

    @Override
    public List<String[]> performLookup() {
        if(!lookupRequirementsMet()){
            return new ArrayList<>();
        }

        ResultSet lookupResultSet = queryDatabaseForResultSet();

        return parseResultSet(lookupResultSet);
    }

    /**
     * Sets the time range of the lookup.
     * @param lookupTimeInMilliseconds The amount of time to search, starting from the moment the perform method is
     *                                 called.
     */
    @Override
    public void setLookupTime(long lookupTimeInMilliseconds) {
        this.lookupTimeInMilliseconds = lookupTimeInMilliseconds;
    }

    /**
     * Abstract method for querying the database for a result set. The result set will be subsequently parsed.
     * @return The result set of the database query.
     */

    protected abstract ResultSet queryDatabaseForResultSet();

    /**
     * Check to determine if the lookup requirements have been met.
     * @return True if all requirements for the lookup are met, false if they are not.
     */
    protected abstract boolean lookupRequirementsMet();

    /**
     * Parse the result set of the database query into a List of String arrays, where each array element is the String
     * value of the parsed results.
     * @param lookupResultSet The result set obtained from a database query.
     * @return The parsed results of the database query.
     */
    protected abstract List<String[]> parseResultSet(ResultSet lookupResultSet);

}
