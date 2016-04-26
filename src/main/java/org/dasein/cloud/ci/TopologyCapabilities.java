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

import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.util.NamingConstraints;

import javax.annotation.Nonnull;
import java.util.Locale;

public interface TopologyCapabilities {

    /**
     * Identifies the naming conventions that constrain how topologies(replica pool templates) may be named (friendly name) in this cloud.
     * @return naming conventions that constrain topologies(replica pool templates) naming
     * @throws CloudException an error occurred in the cloud identifying this capability
     * @throws InternalException an error occurred within the Dasein Cloud implementation identifying this capability
     */
    public @Nonnull NamingConstraints getTopologyNamingConstraints() throws CloudException, InternalException;

    /**
     * Provides a localized term for topologies as the current cloud provider refers to them.
     * @param locale the locale for which the term should be translated
     * @return a localized term for topology in this cloud
     */
    public @Nonnull String getProviderTermForTopology(@Nonnull Locale locale);


}