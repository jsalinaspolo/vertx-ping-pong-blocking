package com.jspcore;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class Ping extends AbstractVerticle {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void start() {
        getVertx().deployVerticle(NonBlockingPing.class.getName(), new DeploymentOptions().setWorker(true),
                event -> {
                    log.info("Ping worker deployed");
                });
    }

}
