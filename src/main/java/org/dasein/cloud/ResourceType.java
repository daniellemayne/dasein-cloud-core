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

/**
 * User: daniellemayne
 * Date: 10/03/2016
 * Time: 14:18
 */
public enum ResourceType {
    //Compute
    VIRTUAL_MACHINE,
    VOLUME,

    //Network
    FIREWALL,
    IP_ADDRESS,
    IP_FORWARDING_RULE,
    LOAD_BALANCER,
    LOAD_BALANCER_HEALTH_CHECK,
    SUBNET,
    VLAN,
    VPN,

    //Platform
    DATABASE,
    KEY_VALUE_DATABASE
}