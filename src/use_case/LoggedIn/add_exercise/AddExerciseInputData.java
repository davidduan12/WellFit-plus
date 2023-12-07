package use_case.LoggedIn.add_exercise;

public class AddExerciseInputData {
    final private String sports;
    final private double duration;
    public AddExerciseInputData(String sports, double duration){
        this.sports = sports;
        this.duration = duration;
    }

    public String getName(){
        return sports;
    }

    Double getDuration(){
        return duration;
    }
}
