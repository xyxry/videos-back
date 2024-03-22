package com.xy.videosback.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

@ClientEndpoint
@Component
public class WebSocketClient {
    private Session session;
    public void open(String url){
        try {
            session = ContainerProvider.getWebSocketContainer().connectToServer(this, URI.create(url));
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @OnMessage
    public  void onMessage(String message, Session session){
        System.out.printf("接受消息",message);
    }
}
