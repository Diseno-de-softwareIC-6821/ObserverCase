
import Server.ServerSingleton;
import Socket.Settings;
import java.io.IOException;



/**
 *
 * @author Esteb
 */
public class SocialVipNetwork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Settings.getInstance().setPORT(6543);
        ServerSingleton.getInstance().turnOn();
    }
    
}
