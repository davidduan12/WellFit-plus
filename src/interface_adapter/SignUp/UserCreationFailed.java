package interface_adapter.SignUp;

public class UserCreationFailed extends RuntimeException{

    public UserCreationFailed(String error) {
        super(error);
    }
}
