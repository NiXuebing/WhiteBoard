package com.flnet.whiteboard;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 *
 * @author : ACE
 * @date : 2019/6/24
 */
@Component
@Order(1)
public class ServerRunner implements CommandLineRunner {

    @Autowired
    private SocketIOServer server;

    @Override
    public void run(String... args) {
        server.start();
    }
}
