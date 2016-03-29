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

import org.dasein.cloud.ResourceType;

import javax.annotation.Nonnull;

/**
 * User: daniellemayne
 * Date: 14/03/2016
 * Time: 11:49
 */
public class ConvergedInfrastructureResource {
    private ResourceType resourceType;
    private String resourceId;

    static public ConvergedInfrastructureResource getInstance(@Nonnull ResourceType resourceType, @Nonnull String resourceId) {
        ConvergedInfrastructureResource  resource = new ConvergedInfrastructureResource();
        resource.resourceType = resourceType;
        resource.resourceId = resourceId;

        return resource;
    }

    public @Nonnull ResourceType getResourceType() {
        return resourceType;
    }

    public @Nonnull String getResourceId() {
        return resourceId;
    }
}
