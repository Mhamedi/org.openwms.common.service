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
package org.openwms.common.transport.api.messages;

import java.io.Serializable;
import java.util.Date;
import java.util.StringJoiner;

/**
 * A TransportUnitMO is a Message Object representing a {@code TransportUnit}.
 *
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 */
public class TransportUnitMO implements Serializable {

    private String pKey;
    private String barcode;
    private Date actualLocationDate;
    private String state;
    private String actualLocation;
    private String plcCode;
    private String targetLocation;
    private TransportUnitTypeMO transportUnitType;
    private String parent;

    /**
     * Required Default constructor.
     */
    public TransportUnitMO() {
    }

    private TransportUnitMO(Builder builder) {
        setpKey(builder.pKey);
        setBarcode(builder.barcode);
        setActualLocationDate(builder.actualLocationDate);
        setState(builder.state);
        setActualLocation(builder.actualLocation);
        setPlcCode(builder.plcCode);
        setTargetLocation(builder.targetLocation);
        setTransportUnitType(builder.transportUnitType);
        setParent(builder.parent);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getpKey() {
        return pKey;
    }

    public void setpKey(String pKey) {
        this.pKey = pKey;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getActualLocationDate() {
        return actualLocationDate;
    }

    public void setActualLocationDate(Date actualLocationDate) {
        this.actualLocationDate = actualLocationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getActualLocation() {
        return actualLocation;
    }

    public void setActualLocation(String actualLocation) {
        this.actualLocation = actualLocation;
    }

    public String getPlcCode() {
        return plcCode;
    }

    public void setPlcCode(String plcCode) {
        this.plcCode = plcCode;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(String targetLocation) {
        this.targetLocation = targetLocation;
    }

    public TransportUnitTypeMO getTransportUnitType() {
        return transportUnitType;
    }

    public void setTransportUnitType(TransportUnitTypeMO transportUnitType) {
        this.transportUnitType = transportUnitType;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TransportUnitMO.class.getSimpleName() + "[", "]").add("pKey='" + pKey + "'").add("barcode='" + barcode + "'").add("actualLocationDate=" + actualLocationDate).add("state='" + state + "'").add("actualLocation='" + actualLocation + "'").add("plcCode='" + plcCode + "'").add("targetLocation='" + targetLocation + "'").add("transportUnitType=" + transportUnitType).add("parent='" + parent + "'").toString();
    }


    public static final class Builder {
        private String pKey;
        private String barcode;
        private Date actualLocationDate;
        private String state;
        private String actualLocation;
        private String plcCode;
        private String targetLocation;
        private TransportUnitTypeMO transportUnitType;
        private String parent;
        private String asNextLocation;

        private Builder() {
        }

        public Builder withPKey(String val) {
            pKey = val;
            return this;
        }

        public Builder withBarcode(String val) {
            barcode = val;
            return this;
        }

        public Builder withActualLocationDate(Date val) {
            actualLocationDate = val;
            return this;
        }

        public Builder withState(String val) {
            state = val;
            return this;
        }

        public Builder withActualLocation(String val) {
            actualLocation = val;
            return this;
        }

        public Builder withPlcCode(String val) {
            plcCode = val;
            return this;
        }

        public Builder withTargetLocation(String val) {
            targetLocation = val;
            return this;
        }

        public Builder withTransportUnitType(TransportUnitTypeMO val) {
            transportUnitType = val;
            return this;
        }

        public Builder withParent(String val) {
            parent = val;
            return this;
        }

        public TransportUnitMO build() {
            return new TransportUnitMO(this);
        }
    }


}
