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

import org.apache.http.HttpStatus;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * User: daniellemayne
 * Date: 25/11/2015
 * Time: 12:10
 */
public class AuthenticationException extends CloudException {
    public enum AuthenticationFaultType {
        UNAUTHORISED, FORBIDDEN;  //HTTP Status codes 401 and 403
    }

    private AuthenticationFaultType authFaultType;

    public AuthenticationException(@Nonnull String msg) {
        super(msg);
        this.errorType = CloudErrorType.AUTHENTICATION;
        this.authFaultType = AuthenticationFaultType.UNAUTHORISED;
    }

    public AuthenticationException(@Nonnull String msg, @Nonnull Throwable cause) {
        super(msg, cause);
        this.errorType = CloudErrorType.AUTHENTICATION;
        this.authFaultType = AuthenticationFaultType.UNAUTHORISED;
    }

    /**
     * Constructs a cloud exception with cloud provider data added in
     * @param httpCode the HTTP error code
     * @param providerCode the provider-specific error code
     * @param msg the error message
     */
    public AuthenticationException(@Nonnegative int httpCode, @Nullable String providerCode, @Nonnull String msg) {
        super(msg);
        this.httpCode = httpCode;
        this.providerCode = providerCode;
        if (httpCode == HttpStatus.SC_FORBIDDEN) {
            this.authFaultType = AuthenticationFaultType.FORBIDDEN;
        }
        else {
            this.authFaultType = AuthenticationFaultType.UNAUTHORISED;
        }
    }

    /**
     * Constructs a cloud exception with cloud provider data added in
     * @param httpCode the HTTP error code
     * @param providerCode the provider-specific error code
     * @param msg the error message
     * @param cause the error that caused this exception to be thrown
     */
    public AuthenticationException(@Nonnegative int httpCode, @Nullable String providerCode, @Nonnull String msg, @Nonnull Throwable cause) {
        super(msg, cause);
        this.httpCode = httpCode;
        this.providerCode = providerCode;
        if (httpCode == HttpStatus.SC_FORBIDDEN) {
            this.authFaultType = AuthenticationFaultType.FORBIDDEN;
        }
        else {
            this.authFaultType = AuthenticationFaultType.UNAUTHORISED;
        }
    }

    /**
     * Indicates a specific fault type for this exception.
     * @param authFaultType the error that caused this exception to be thrown
     * @return this
     */
    public @Nonnull AuthenticationException withFaultType(@Nonnull AuthenticationFaultType authFaultType) {
        this.authFaultType = authFaultType;
        return this;
    }

    public AuthenticationFaultType getAuthFaultType() {
        return authFaultType;
    }
}
