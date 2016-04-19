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
import javax.annotation.Nullable;

/**
 * User: daniellemayne
 * Date: 10/03/2016
 * Time: 12:45
 */
public class ConvergedInfrastructureProvisionOptions {
    private String name;
    private String baseName;
    private String description;
    private String resourceGroupId;
    private String providerDatacenterId;
    private String mode;
    private String template;
    private String parameters;
    private boolean templateContentProvided;
    private int instanceCount;

    static public ConvergedInfrastructureProvisionOptions getInstance(@Nonnull String name, @Nullable String description, @Nullable String resourceGroupId,
                                                               @Nullable String mode, @Nonnull String template,
                                                               @Nonnull String parameters, @Nonnull boolean templateContentProvided) {
        ConvergedInfrastructureProvisionOptions options = new ConvergedInfrastructureProvisionOptions();
        options.name = name;
        options.description = description;
        options.resourceGroupId = resourceGroupId;
        options.mode = mode;
        options.template = template;
        options.parameters = parameters;
        options.templateContentProvided = templateContentProvided;
        return options;
    }

    public String getName() {
        return name;
    }

    public String getBaseName() {
        return baseName;
    }

    public String getDescription() {
        return description;
    }

    public String getResourceGroupId() {
        return resourceGroupId;
    }

    public String getProviderDatacenterId() {
        return providerDatacenterId;
    }

    public String getMode() {
        return mode;
    }

    public String getTemplate() {
        return template;
    }

    public String getParameters() {
        return parameters;
    }

    /**
     * Determine whether the end user has provided the full template content, or links to files (template and parameters)
     * @return true if the full template content has been provided in the request
     */
    public boolean isTemplateContentProvided() {
        return templateContentProvided;
    }

    public int getInstanceCount() {
        return instanceCount;
    }

    public ConvergedInfrastructureProvisionOptions inDatacenter(String providerDatacenterId) {
        this.providerDatacenterId = providerDatacenterId;
        return this;
    }

    public ConvergedInfrastructureProvisionOptions withBaseName(String baseName) {
        this.baseName = baseName;
        return this;
    }

    public ConvergedInfrastructureProvisionOptions withInstanceCount(int instanceCount) {
        this.instanceCount = instanceCount;
        return this;
    }
}
