import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

import java.util.Scanner;

public class IssueCommand {

    public static void main(String[] args){
        HazelcastInstance hazelcastInstance= HazelcastClient.newHazelcastClient();
        ITopic<String> topic = hazelcastInstance.getTopic("command-queue");

        Scanner scanner= new Scanner(System.in);
        while(true) {
            System.out.print("Enter command: ");
            String str = scanner.nextLine();
            if (str.equals("exit")) {
                hazelcastInstance.shutdown();
                System.exit(0);
            } else
                topic.publish(str);
        }
    }
}
