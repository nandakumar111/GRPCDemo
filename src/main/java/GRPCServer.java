import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.UserService;

public class GRPCServer {
    public static void main(String[] args) {
        try {

            Server server = ServerBuilder.forPort(50051).addService(new UserService()).build();

            server.start();

            System.out.println("Server started at " + server.getPort());
            server.awaitTermination();
        }
        catch (Exception e){
            System.exit(1);
        }
    }
}
