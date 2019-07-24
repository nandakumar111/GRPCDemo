package user;

import com.test.grpc.UserGrpc.UserImplBase;
import com.test.grpc.UserOuterClass.*;
import io.grpc.stub.StreamObserver;

public class UserService extends UserImplBase {

    @Override
    public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
        System.out.println("Inside Login");

        APIResponse.Builder response = APIResponse.newBuilder();
        if (request.getUsername().equals(request.getPassword())){
            response.setCode(0).setMessage("success");
        }else{
            response.setCode(100).setMessage("Failure");
        }
        System.out.println(response);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

}
