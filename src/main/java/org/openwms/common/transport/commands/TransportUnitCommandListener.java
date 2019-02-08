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
package org.openwms.common.transport.commands;

import org.ameba.annotation.Measured;
import org.ameba.annotation.TxService;
import org.openwms.common.transport.api.commands.TUCommand;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * A TransportUnitCommandListener is listening on {@link TUCommand}s to process.
 *
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @see TUCommand
 */
@TxService
class TransportUnitCommandListener {

    private final TransportUnitCommandHandler handler;

    TransportUnitCommandListener(TransportUnitCommandHandler handler) {
        this.handler = handler;
    }

    @Measured
    @RabbitListener(queues = "${owms.commands.common.tu.queue-name}")
    public void onCommand(@Payload TUCommand command) {
        try {
            handler.handle(command);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e.getMessage(), e);
        }
    }
}