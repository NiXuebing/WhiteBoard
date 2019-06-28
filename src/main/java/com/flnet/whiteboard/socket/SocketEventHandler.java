package com.flnet.whiteboard.socket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author : ACE
 * @date : 2019/6/24
 */
@Slf4j
@Component
public class SocketEventHandler {

    @Autowired
    private SocketIOServer server;

    @OnConnect
    public void onConnect(SocketIOClient client) {
        String username = client.getHandshakeData().getSingleUrlParam("username");
        log.info("用户{}上线了, sessionId: {}", username, client.getSessionId().toString());

        client.sendEvent("notification", "连接成功");
    }

    @OnDisconnect
    public void onDisConnect(SocketIOClient client) {
        String username = client.getHandshakeData().getSingleUrlParam("username");
        log.info("用户{}离开了", username);
    }

    /**
     * 自定义一个notification事件，也可以自定义其它任何名字的事件
     */
    @OnEvent("chatevent")
    public void chatevent(SocketIOClient client) {
        log.info("用户{}可以操作了");
    }

}
