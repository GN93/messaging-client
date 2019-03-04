package message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable {

    private static final long serialVersionUID = 129381209321L;

    private MessageType messageType;
    private String content;
    private List<String> recipents;

    public Message(MessageType messageType, String content, List<String> recipents) {
        this.messageType = messageType;
        this.content = content;
        this.recipents = recipents;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageType=" + messageType +
                ", content='" + content + '\'' +
                ", recipents=" + recipents +
                '}';
    }
}
