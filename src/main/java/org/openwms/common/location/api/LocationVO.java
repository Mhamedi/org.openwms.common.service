/*
 * Copyright 2018 Heiko Scherrer
 *
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
 */
package org.openwms.common.location.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * A LocationVO.
 *
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 */
public class LocationVO extends ResourceSupport implements Target, Serializable {

    private String pKey;
    private String locationId;
    private String locationGroupName;
    private String plcCode;
    private boolean incomingActive;
    private boolean outgoingActive;
    private int plcState;

    /*~-------------------- methods --------------------*/
    /**
     * Checks whether the Location is blocked for incoming goods.
     *
     * @return {@literal true} if blocked, otherwise {@literal false}
     */
    @JsonIgnore
    public boolean isInfeedBlocked() {
        return !incomingActive;
    }

    /**
     * Checks whether the Location is blocked for outgoing goods.
     *
     * @return {@literal true} if blocked, otherwise {@literal false}
     */
    @JsonIgnore
    public boolean isOutfeedBlocked() {
        return !outgoingActive;
    }

    /*~-------------------- accessors --------------------*/
    public String getLocationGroupName() {
        return locationGroupName;
    }

    public void setLocationGroupName(String locationGroupName) {
        this.locationGroupName = locationGroupName;
    }

    public String getpKey() {
        return pKey;
    }

    public void setpKey(String pKey) {
        this.pKey = pKey;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getPlcCode() {
        return plcCode;
    }

    public void setPlcCode(String plcCode) {
        this.plcCode = plcCode;
    }

    public boolean isIncomingActive() {
        return incomingActive;
    }

    public void setIncomingActive(boolean incomingActive) {
        this.incomingActive = incomingActive;
    }

    public boolean isOutgoingActive() {
        return outgoingActive;
    }

    public void setOutgoingActive(boolean outgoingActive) {
        this.outgoingActive = outgoingActive;
    }

    public int getPlcState() {
        return plcState;
    }

    public void setPlcState(int plcState) {
        this.plcState = plcState;
    }

    /*~-------------------- overrides --------------------*/
    /**
     * {@inheritDoc}
     */
    @Override
    public String asString() {
        return locationId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", LocationVO.class.getSimpleName() + "[", "]").add("pKey='" + pKey + "'").add("locationId='" + locationId + "'").add("locationGroupName='" + locationGroupName + "'").add("plcCode='" + plcCode + "'").add("incomingActive=" + incomingActive).add("outgoingActive=" + outgoingActive).toString();
    }

    /**
     * {@inheritDoc}
     *
     * All fields.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        LocationVO that = (LocationVO) o;
        return incomingActive == that.incomingActive && outgoingActive == that.outgoingActive && plcState == that.plcState && Objects.equals(pKey, that.pKey) && Objects.equals(locationId, that.locationId) && Objects.equals(locationGroupName, that.locationGroupName) && Objects.equals(plcCode, that.plcCode);
    }

    /**
     * {@inheritDoc}
     *
     * All fields.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pKey, locationId, locationGroupName, plcCode, incomingActive, outgoingActive, plcState);
    }
}
