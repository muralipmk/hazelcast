import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastServer {

    public static void main(String[] args){
        HazelcastInstance hazelcastInstance= Hazelcast.newHazelcastInstance();
    }
}
