//package com.xy.videosback.websocket;
//
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.WebSocketMessage;
//import org.springframework.web.socket.WebSocketSession;
//
//public class MyWebSocketHandler implements WebSocketHandler {
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        System.out.printf("连接成功");
//        // 连接建立时执行的逻辑
//    }
//
//
//
//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//        // 处理收到的消息
//        String payload = (String) message.getPayload();
//        // 可以将消息广播给所有连接的客户端等
//    }
//
//    @Override
//    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
//        // 发生错误时的处理逻辑
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
//        // 连接关闭时执行的逻辑
//    }
//
//    @Override
//    public boolean supportsPartialMessages() {
//        return false;
//    }
//}
