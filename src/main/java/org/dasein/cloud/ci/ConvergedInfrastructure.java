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

import org.dasein.cloud.Taggable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * A converged infrastructure is a grouping of resources that are provisioned together to create a single computing
 * deployment.
 * User: daniellemayne
 * Date: 10/03/2016
 * Time: 10:21
 */
public class ConvergedInfrastructure implements Taggable{

    private String providerCIId;
    private String name;
    private String description;
    private ConvergedInfrastructureState ciState;
    private long provisioningTimestamp;
    private List<ConvergedInfrastructureResource> resources;
    private String providerDatacenterId;
    private String providerRegionId;
    private String providerResourcePoolId;
    private Map<String,String> tags;

    static public @Nonnull ConvergedInfrastructure getInstance(@Nonnull String providerCIId, @Nonnull String name,
                                                               @Nullable String description, @Nonnull ConvergedInfrastructureState state,
                                                               @Nullable long provisioningTimestamp, @Nonnull String providerDatacenterId,
                                                               @Nonnull String providerRegionId, @Nullable String providerResourcePoolId) {
        ConvergedInfrastructure ci = new ConvergedInfrastructure();
        ci.providerCIId = providerCIId;
        ci.name = name;
        ci.description = description;
        ci.ciState = state;
        ci.provisioningTimestamp = provisioningTimestamp;
        ci.providerDatacenterId = providerDatacenterId;
        ci.providerRegionId = providerRegionId;
        ci.providerResourcePoolId = providerResourcePoolId;
        ci.resources = new ArrayList<ConvergedInfrastructureResource>();
        return ci;
    }

    public ConvergedInfrastructure withResources(@Nonnull ConvergedInfrastructureResource... resource){
        for (int i = 0; i<resource.length; i++) {
            resources.add(resource[i]);
        }
        return this;
    }

    public @Nonnull String getProviderCIId() {
        return providerCIId;
    }

    public @Nonnull String getName() {
        return name;
    }

    public @Nonnull String getDescription() {
        return description != null ? description: "";
    }

    public @Nonnull ConvergedInfrastructureState getCiState() {
        return ciState;
    }

    public @Nullable long getProvisioningTimestamp() {
        return provisioningTimestamp;
    }

    public @Nonnull List<ConvergedInfrastructureResource> getResources() {
        return resources;
    }

    public @Nonnull String getProviderDatacenterId() {
        return providerDatacenterId;
    }

    public @Nonnull String getProviderRegionId() {
        return providerRegionId;
    }

    public @Nullable String getProviderResourcePoolId() {
        return providerResourcePoolId;
    }

    @Override
    public @Nonnull Map<String,String> getTags() {
        if( tags == null ) {
            tags = new HashMap<String,String>();
        }
        return tags;
    }

    public @Nullable Object getTag(@Nonnull String tag) {
        return getTags().get(tag);
    }

    public void setProviderDatacenterId(String providerDatacenterId) {
        this.providerDatacenterId = providerDatacenterId;
    }

    public void setProviderRegionId(String providerRegionId) {
        this.providerRegionId = providerRegionId;
    }

    public void setProviderResourcePoolId(String providerResourcePoolId) {
        this.providerResourcePoolId = providerResourcePoolId;
    }

    @Override
    public void setTag(@Nonnull String key, @Nonnull String value) {
        getTags().put(key, value);
    }

    /**
     * Clears out any currently set tags and replaces them with the specified list.
     * @param properties the list of tag values to be set
     */
    public void setTags(Map<String,String> properties) {
        getTags().clear();
        getTags().putAll(properties);
    }
}
