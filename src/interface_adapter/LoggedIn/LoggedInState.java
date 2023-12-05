package interface_adapter.LoggedIn;

public class LoggedInState {
    private String username = "";

    public LoggedInState(LoggedInState copy){
        username = this.username;
    }

    public LoggedInState(){}

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
