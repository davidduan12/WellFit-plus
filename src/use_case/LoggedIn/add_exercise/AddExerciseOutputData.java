package use_case.LoggedIn.add_exercise;

public class AddExerciseOutputData {
    private final String sports;

    public AddExerciseOutputData(String sports){
        this.sports = sports;
    }
    public String getSports(){
        return sports;
    }
}
