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
import org.dasein.cloud.CloudException;
import org.dasein.cloud.CloudProvider;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.identity.ServiceAction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

/**
 * User: daniellemayne
 * Date: 10/03/2016
 * Time: 15:29
 */

public abstract class AbstractConvergedInfrastructureSupport<T extends CloudProvider> extends AbstractProviderService<T> implements ConvergedInfrastructureSupport {

    protected AbstractConvergedInfrastructureSupport(T provider) {
        super(provider);
    }

    @Override
    public @Nullable ConvergedInfrastructure getConvergedInfrastructure(@Nonnull String ciId) throws CloudException, InternalException {
        for( ConvergedInfrastructure ci : listConvergedInfrastructures(null) ) {
            if( ciId.equals(ci.getProviderCIId()) ) {
                return ci;
            }
        }
        return null;
    }

    @Override
    public @Nonnull Iterable<ResourceStatus> listConvergedInfrastructureStatus() throws CloudException, InternalException {
        ArrayList<ResourceStatus> status = new ArrayList<ResourceStatus>();

        for( ConvergedInfrastructure ci : listConvergedInfrastructures(null) ) {
            status.add(new ResourceStatus(ci.getName(), ci.getCiState()));
        }
        return status;
    }

    @Override
    public @Nonnull String[] mapServiceAction(@Nonnull ServiceAction action) {
        return new String[0];
    }

    @Override
    public void updateTags(@Nonnull String ciId, @Nonnull Tag... tags) throws CloudException, InternalException {
        // NO-OP
    }

    @Override
    public void updateTags(@Nonnull String[] ciIds, @Nonnull Tag ... tags) throws CloudException, InternalException {
        for( String id : ciIds ) {
            updateTags(id, tags);
        }
    }

    @Override
    public void removeTags(@Nonnull String ciId, @Nonnull Tag ... tags) throws CloudException, InternalException {
        // NO-OP
    }

    @Override
    public void removeTags(@Nonnull String[] ciIds, @Nonnull Tag ... tags) throws CloudException, InternalException {
        for( String id : ciIds ) {
            removeTags(id, tags);
        }
    }
}
