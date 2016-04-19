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

import org.dasein.cloud.Capabilities;
import org.dasein.cloud.Requirement;
import org.dasein.cloud.util.NamingConstraints;

import javax.annotation.Nonnull;

/**
 * User: daniellemayne
 * Date: 24/03/2016
 * Time: 11:49
 */
public interface ConvergedInfrastructureCapabilities extends Capabilities {
    /**
     * Identifies whether the Converged Infrastructure requires a resource pool to be specified on launch
     * @return the requirement for resource pool on launch
     */public @Nonnull Requirement identifyResourcePoolLaunchRequirement();

    /**
     * Identifies whether the Converged Infrastructure requires the full template content
     * or if an id/link to an existing template object can be specified on launch
     * @return the requirement for template content on launch
     */
    public @Nonnull Requirement identifyTemplateContentLaunchRequirement();

    /**
     * Identifies the naming conventions that constrain how converged infrastructure (replica pools) may be named (friendly name) in this cloud.
     * @return naming conventions that constrain converged infrastructure naming
     */
    public @Nonnull
    NamingConstraints getConvergedInfrastructureNamingConstraints();
}
