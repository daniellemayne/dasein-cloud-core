/**
 * Copyright (C) 2009-2016 Dell, Inc.
 * See annotations for authorship information
 * <p>
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.dasein.cloud.ci;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.Tag;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * [Class Documentation]
 * <p>Created by George Reese: 6/3/13 3:32 PM</p>
 *
 * @author George Reese
 */
public interface TopologySupport extends AccessControlledService {

    /**
     * Fetches the specified topology state from the cloud provider, if the specified topology exists.
     * @param topologyId the unique provider ID for the desired topology
     * @return the matching topology or <code>null</code> if no such topology exists
     * @throws CloudException an error occurred with the cloud provider while fetching the target topology
     * @throws InternalException an error occurred within Dasein Cloud while processing the request
     */
    public @Nullable Topology getTopology(@Nonnull String topologyId) throws CloudException, InternalException;

    /**
     * Verifies that the current account context is subscribed for access to topology support in this cloud and region.
     * @return true if the account is subscribed in the current region for topology support
     * @throws CloudException an error occurred with the cloud provider while checking the subscription
     * @throws InternalException an error occurred within Dasein Cloud while processing the request
     */
    public boolean isSubscribed() throws CloudException, InternalException;

    /**
     * Lists private topologies matching the specified filtering options.
     * @param options the options on which you would like to filter
     * @return a list of matching topologies from your private topology library
     * @throws CloudException an error occurred in the cloud provider while processing the request
     * @throws InternalException an error occurred within Dasein Cloud while processing the request
     */
    public @Nonnull Iterable<Topology> listTopologies(@Nullable TopologyFilterOptions options) throws CloudException, InternalException;

    /**
     * Updates meta-data for a topology with the new values. It will not overwrite any value that currently
     * exists unless it appears in the tags you submit.
     * @param topologyId the topology to update
     * @param tags the meta-data tags to set
     * @throws CloudException an error occurred within the cloud provider
     * @throws InternalException an error occurred within the Dasein Cloud API implementation
     */
    public void updateTags(@Nonnull String topologyId, @Nonnull Tag... tags) throws CloudException, InternalException;

    /**
     * Updates meta-data for multiple topologies with the new values. It will not overwrite any value that currently
     * exists unless it appears in the tags you submit.
     * @param topologyIds the topologies to update
     * @param tags the meta-data tags to set
     * @throws CloudException an error occurred within the cloud provider
     * @throws InternalException an error occurred within the Dasein Cloud API implementation
     */
    public void updateTags(@Nonnull String[] topologyIds, @Nonnull Tag... tags) throws CloudException, InternalException;

    /**
     * Removes meta-data from a topology. If tag values are set, their removal is dependent on underlying cloud
     * provider behavior. They may be removed only if the tag value matches or they may be removed regardless of the
     * value.
     * @param topologyId the topology to update
     * @param tags the meta-data tags to remove
     * @throws CloudException an error occurred within the cloud provider
     * @throws InternalException an error occurred within the Dasein Cloud API implementation
     */
    public void removeTags(@Nonnull String topologyId, @Nonnull Tag... tags) throws CloudException, InternalException;

    /**
     * Removes meta-data from multiple topologies. If tag values are set, their removal is dependent on underlying cloud
     * provider behavior. They may be removed only if the tag value matches or they may be removed regardless of the
     * value.
     * @param topologyIds the topology to update
     * @param tags the meta-data tags to remove
     * @throws CloudException an error occurred within the cloud provider
     * @throws InternalException an error occurred within the Dasein Cloud API implementation
     */
    public void removeTags(@Nonnull String[] topologyIds, @Nonnull Tag... tags) throws CloudException, InternalException;

    public TopologyCapabilities getCapabilities() throws CloudException, InternalException;

}