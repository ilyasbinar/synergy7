package com.example.socketDemoS7.socketio;

import lombok.Data;

@Data
public class Message {
    private String from;
    private String to;
    private String content;
}
