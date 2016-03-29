/**
 * Copyright (C) 2009-2016 Dell, Inc.
 * See annotations for authorship information
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.dasein.cloud.ci;

import javax.annotation.Nonnull;

/**
 * User: daniellemayne
 * Date: 10/03/2016
 * Time: 12:17
 */
public class ConvergedInfrastructureFilterOptions {
    private boolean matchesAny;
    private String  regex;
    private String  dataCenterId;
    private String resourceGroupId;

    /**
     * Constructs an empty set of filtering options that will force match against any converged infrastructure by default.
     * @return an empty filtering options objects
     */
    public static @Nonnull
    ConvergedInfrastructureFilterOptions getInstance() {
        return new ConvergedInfrastructureFilterOptions(false);
    }

    /**
     * Constructs filter options that will match either any criteria or all criteria, but has no actual criteria
     * associated with it.
     * @param matchesAny true if it is sufficient that just one of the criteria are matched, false if all are needed to be matched
     * @return a newly constructed set of converged infrastructure filtering options
     */
    public static @Nonnull ConvergedInfrastructureFilterOptions getInstance(boolean matchesAny){
        return new ConvergedInfrastructureFilterOptions(matchesAny);
    }

    /**
     * Constructs a filter against a Java regular expression that must match all criteria.
     * @param regex the regular expression to match against the VM name, description, or tag values
     * @return a converged infrastructure filter options object
     */
    public static @Nonnull ConvergedInfrastructureFilterOptions getInstance(@Nonnull String regex){
        ConvergedInfrastructureFilterOptions options = new ConvergedInfrastructureFilterOptions(false);

        options.regex = regex;
        return options;
    }

    /**
     * Constructs a filter against a Java regular expression that must match criteria as specified
     * @param matchesAny true if it is sufficient that just one of the criteria are matched, false if all are needed to be matched
     * @param regex      the regular expression to match against the converged ifrastructure name or description
     * @return an converged infrastructure filter options object
     */
    public static @Nonnull ConvergedInfrastructureFilterOptions getInstance(boolean matchesAny, @Nonnull String regex){
        ConvergedInfrastructureFilterOptions options = new ConvergedInfrastructureFilterOptions(matchesAny);

        options.regex = regex;
        return options;
    }

    private ConvergedInfrastructureFilterOptions(boolean matchesAny){
        this.matchesAny = matchesAny;
    }

    public String getRegex(){
        return regex;
    }

    public String getDataCenterId(){
        return dataCenterId;
    }

    public String getResourceGroupId(){
        return resourceGroupId;
    }

    /**
     * Indicates whether there are any criteria associated with these options.
     * @return true if this filter options object has any criteria associated with it
     */
    public boolean hasCriteria(){
        return (dataCenterId != null || regex != null);
    }

    /**
     * Indicates whether these options can match a single criterion (true) or if all criteria must be
     * matched in order for the converged infrastructure to pass the filter (false).
     * @return whether matching any single criterion is sufficient to consider a converged infrastructure a match
     */
    public boolean isMatchesAny() {
        return matchesAny;
    }

    /**
     * Indicates that the criteria associated with this filter must match all set criteria.
     * @return this
     */
    public @Nonnull ConvergedInfrastructureFilterOptions matchingAll() {
        this.matchesAny = false;
        return this;
    }

    /**
     * Adds a regex to the set of filtering options. This regular expression is a standard Java regular expression
     * matches against the converged infrastructure name or description
     * @param regex the Java regular expression string to match against
     * @return this
     */
    public @Nonnull ConvergedInfrastructureFilterOptions matchingRegex(@Nonnull String regex){
        this.regex = regex;
        return this;
    }

    /**
     * Adds a dataCenterId to the set of filtering options.
     * @param dataCenterId the dataCenterId string to match against
     * @return this
     */
    public @Nonnull ConvergedInfrastructureFilterOptions withDataCenterId(@Nonnull String dataCenterId){
        this.dataCenterId = dataCenterId;
        return this;
    }

    /**
     * Adds a resourceGroupId to the set of filtering options.
     * @param resourceGroupId the dataCenterId string to match against
     * @return this
     */
    public @Nonnull ConvergedInfrastructureFilterOptions withResourceGroupId(@Nonnull String resourceGroupId){
        this.resourceGroupId = resourceGroupId;
        return this;
    }

    /**
     * Matches a converged infrastructure against the criteria in this set of filter options.
     * @param convergedInfrastructure the converged infrastructure to test
     * @return true if the converged infrastructure matches all criteria
     */
    public boolean matches(@Nonnull ConvergedInfrastructure convergedInfrastructure) {
        if( regex != null ) {
            boolean matches = (convergedInfrastructure.getName().matches(regex) || convergedInfrastructure.getDescription().matches(regex));
            if(!matches && !matchesAny){
                return false;
            }
            else if(matches && matchesAny){
                return true;
            }
        }
        if(dataCenterId != null){
            boolean matches = dataCenterId.equals(convergedInfrastructure.getProviderDatacenterId());
            if(!matches && !matchesAny){
                return false;
            }
            else if(matches && matchesAny){
                return true;
            }
        }
        if(resourceGroupId != null){
            boolean matches = resourceGroupId.equals(convergedInfrastructure.getProviderResourcePoolId());
            if(!matches && !matchesAny){
                return false;
            }
            else if(matches && matchesAny){
                return true;
            }
        }
        return !matchesAny;
    }
}
