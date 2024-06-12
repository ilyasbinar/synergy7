package com.example.socketDemoS7.socketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import org.springframework.stereotype.Component;

@Component
public class SocketIOController {
    private final SocketIOServer socketIOServer;

    public SocketIOController(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;

        this.socketIOServer.addConnectListener(onUserConnected);
        this.socketIOServer.addDisconnectListener(onUserDisconnected);
        this.socketIOServer.addEventListener("binar-room", Message.class, onMessageSent);

        this.socketIOServer.addEventListener("binar-promo", BinarPromoMessage.class, onBinarPromoMessageSent);

    }

    private ConnectListener onUserConnected = socketIOClient -> System.out.println("SocketIOController onConnected");

    private DisconnectListener onUserDisconnected = socketIOClient -> System.out.println("SocketIOController disconnected");

    private DataListener<Message> onMessageSent = new DataListener<Message>() {
        @Override
        public void onData(SocketIOClient socketIOClient, Message message, AckRequest ackRequest) throws Exception {
            socketIOServer.getBroadcastOperations()
                    .sendEvent(message.getTo(), message.getContent());
            ackRequest.sendAckData("Message sent to "+ message.getTo());
        }
    };

    private DataListener<BinarPromoMessage> onBinarPromoMessageSent = new DataListener<BinarPromoMessage>() {
        @Override
        public void onData(SocketIOClient socketIOClient, BinarPromoMessage message, AckRequest ackRequest) throws Exception {

            String contentPromotion = "Silakan beli "+message.getProduct()+" sedang diskon menjadi "+ message.getPrice();

            socketIOServer.getBroadcastOperations()
                    .sendEvent("promo-product", contentPromotion);
            ackRequest.sendAckData("Promo product message sent to all");
        }
    };
}
