import com.test.grpc.UserGrpc;
import com.test.grpc.UserOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import user.UserService;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GRPCClient {
//    private static final Logger logger = Logger.getLogger(GRPCClient.class.getName());
//    private final ManagedChannel channel;
//    private final UserGrpc.UserBlockingStub blockingStub;
//
//
//    public GRPCClient(String host, int port){
//        this(ManagedChannelBuilder.forAddress(host, port)
//                .usePlaintext()
//                .build());
//    }
//
//    GRPCClient(ManagedChannel channel){
//        this.channel = channel;
//        blockingStub = UserGrpc.newBlockingStub(channel);
//    }
//
//    public void shutdown() throws InterruptedException {
//        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//    }
//
//    public void login(String username, String password){
//        UserOuterClass.LoginRequest request = UserOuterClass.LoginRequest.newBuilder().setUsername(username).setPassword(password).build();
//        UserOuterClass.APIResponse response;
//
//        try {
//            response = blockingStub.login(request);
//
//        }catch (Exception e){
//            logger.log(Level.WARNING, "RPC failed: {0}", e);
//            System.out.println(e);
//            return;
//        }
//        System.out.println("Response : "+ response);
//        logger.info("Response : "+ response);
//    }

    public static void main(String[] args) throws Exception{
//        GRPCClient client = new GRPCClient("localhost", 9090);

        UserGrpc.UserBlockingStub blockingStub = UserGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build());
        System.out.println(blockingStub.login(UserOuterClass.LoginRequest.newBuilder().setUsername("nanda").setPassword("nanda").build()));
//        try {
//            client.login("nanda","nanda");
//        }finally {
//            client.shutdown();
//        }
    }
}

