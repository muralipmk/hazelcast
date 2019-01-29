import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

import java.util.Collection;

public class CommandListener implements MessageListener<String> {

    public void subscribe(){
        HazelcastInstance instance= HazelcastClient.newHazelcastClient();
        ITopic<String> topic = instance.getTopic("command-queue");
        topic.addMessageListener(this);
    }

    public void onMessage(Message<String> message) {
        System.out.println("Message Received: " + message.getMessageObject());
    }

    public static void main(String[] args){
        CommandListener listener= new CommandListener();
        listener.subscribe();
    }
}
