package use_case.add_exercise;

public class AddExerciseInputData {
    final private String sports;
    final private float calorie;
    public AddExerciseInputData(String sports, float calorie){
        this.sports = sports;
        this.calorie = calorie;
    }

    String getName(){
        return sports;
    }
}
