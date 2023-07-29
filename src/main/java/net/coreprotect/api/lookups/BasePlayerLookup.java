package net.coreprotect.api.lookups;

import java.util.UUID;

/**
 * Abstract that represents the generalisation of a database lookup that can involve a player-based filter.
 */
public abstract class BasePlayerLookup extends BaseLookup{
    /**
     * Array of the UUIDs of players utilised as a filter during the lookup.
     */
    protected UUID[] filteredPlayerIds;

}
