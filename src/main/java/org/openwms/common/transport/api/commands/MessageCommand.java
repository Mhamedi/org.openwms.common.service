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
package org.openwms.common.transport.api.commands;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * A MessageCommand is used to attach Messages.
 *
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 */
public class MessageCommand implements Command<MessageCommand.Type>, Serializable {

    public enum Type {
        /** Add a message to a TransportUnit. */
        ADD_TO_TU
    }

    @NotNull
    private Type type;
    private String transportUnitId;

    @NotEmpty
    private String messageText;
    private String messageNumber;
    private Date messageOccurred;

    @JsonCreator
    protected MessageCommand() {
    }

    private MessageCommand(Builder builder) {
        type = builder.type;
        transportUnitId = builder.transportUnitId;
        messageText = builder.messageText;
        messageNumber = builder.messageNumber;
        messageOccurred = builder.messageOccurred;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTransportUnitId() {
        return transportUnitId;
    }

    public void setTransportUnitId(String transportUnitId) {
        this.transportUnitId = transportUnitId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(String messageNumber) {
        this.messageNumber = messageNumber;
    }

    public Date getMessageOccurred() {
        return messageOccurred;
    }

    public void setMessageOccurred(Date messageOccurred) {
        this.messageOccurred = messageOccurred;
    }

    public static final class Builder {
        private @NotNull Type type;
        private String transportUnitId;
        private @NotEmpty String messageText;
        private String messageNumber;
        private Date messageOccurred;

        private Builder() {
        }

        public Builder withType(@NotNull Type val) {
            type = val;
            return this;
        }

        public Builder withTransportUnitId(String val) {
            transportUnitId = val;
            return this;
        }

        public Builder withMessageText(@NotEmpty String val) {
            messageText = val;
            return this;
        }

        public Builder withMessageNumber(String val) {
            messageNumber = val;
            return this;
        }

        public Builder withMessageOccurred(Date val) {
            messageOccurred = val;
            return this;
        }

        public MessageCommand build() {
            return new MessageCommand(this);
        }
    }
}
