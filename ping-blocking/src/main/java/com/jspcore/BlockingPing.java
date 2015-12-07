package com.jspcore;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class BlockingPing extends AbstractVerticle {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void start() throws InterruptedException {
        log.info("Ping started");

        for (int i = 0; i < 10; i++) {
            log.info("sending message ping...");
            getVertx().eventBus().send("ping-pong", "ping-blocking", response -> {
                if (response.succeeded()) log.info("success");
                else log.info("error?");
            });

            Thread.sleep(1000);
        }
    }
}
