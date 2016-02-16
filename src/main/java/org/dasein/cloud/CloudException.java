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

package org.dasein.cloud;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <p>
 * Represents some kind of failure with the cloud provider or with the format of a request to the
 * cloud provider.
 * </p>
 * <p>
 * The Dasein Cloud API divides exceptional conditions into two groups: cloud exceptions and internal
 * exception. A cloud exception is simply an error that occurs in the cloud, whereas an internal
 * exception is one that occurs on the localhost within the implementation of this API for
 * a particular provider. This distinction can help clients determine how to recover from any
 * given error.
 * </p>
 * @author George Reese @ enstratius (http://www.enstratius.com)
 */
public class CloudException extends Exception {
    private static final long serialVersionUID = -1975104091752615199L;
    
    protected CloudErrorType errorType;
    protected int            httpCode;
    protected String         providerCode;
    
    /**
     * Constructs an unlabeled exception.
     */
    protected CloudException() {
        super();
    }

    /**
     * Constructs a cloud exception with a specific error message.
     * @param msg the message for the error that occurred
     */
    protected CloudException(@Nullable String msg) {
        super(msg);
    }
    
    /**
     * Constructs a cloud exception in response to a specific cause.
     * @param cause the error that caused this exception to be thrown
     */
    protected CloudException(@Nullable Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a cloud exception with a specific error message and cause.
     * @param msg the message for the error that occurred
     * @param cause the error that caused this exception to be thrown
     */
    protected CloudException(@Nullable String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }
    
    /**
     * Constructs a cloud exception with cloud provider data added in
     * @param type cloud error type
     * @param httpCode the HTTP error code
     * @param providerCode the provider-specific error code
     * @param msg the error message
     */
    protected CloudException(@Nullable CloudErrorType type, @Nonnegative int httpCode, @Nullable String providerCode, @Nullable String msg) {
        super(msg);
        this.errorType = type;
        this.httpCode = httpCode;
        this.providerCode = providerCode;
    }

    /**
     * Constructs a cloud exception with cloud provider data added in
     * @param type cloud error type
     * @param httpCode the HTTP error code
     * @param providerCode the provider-specific error code
     * @param msg the error message
     * @param cause the error that caused this exception to be thrown
     */
    protected CloudException(@Nullable CloudErrorType type, @Nonnegative int httpCode, @Nullable String providerCode, @Nullable String msg, @Nonnull Throwable cause) {
        super(msg, cause);
        this.errorType = type;
        this.httpCode = httpCode;
        this.providerCode = providerCode;
    }
    
    public @Nonnegative int getHttpCode() {
        return httpCode;
    }
    
    public @Nonnull CloudErrorType getErrorType() {
        return (errorType == null ? CloudErrorType.GENERAL : errorType);
    }
    
    public @Nonnull String getProviderCode() {
        return (providerCode == null ? "" : providerCode);
    }
}
