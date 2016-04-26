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

import org.dasein.cloud.AbstractProviderService;
import org.dasein.cloud.CloudProvider;

import javax.annotation.Nullable;

/**
 * User: daniellemayne
 * Date: 10/03/2016
 * Time: 15:05
 */
public abstract class AbstractConvergedInfrastructureServices<T extends CloudProvider> extends AbstractProviderService<T> implements ConvergedInfrastructureServices {
    protected AbstractConvergedInfrastructureServices(T provider) {
        super(provider);
    }

    @Nullable
    @Override
    public ConvergedInfrastructureSupport getConvergedInfrastructureSupport() {
        return null;
    }

    @Override
    public boolean hasConvergedInfrastructureSupport() {
        return (getConvergedInfrastructureSupport() != null);
    }

    @Nullable
    @Override
    public TopologySupport getTopologySupport() {
        return null;
    }

    @Override
    public boolean hasTopologySupport() {
        return (getTopologySupport() == null);
    }
}
