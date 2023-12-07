package interface_adapter.LoggedIn.AddExercise;


public class AddExerciseState {
    private String exerciseName = "";
    private double exerciseLength = 0;
    private String exerciseError = null;


    public AddExerciseState(AddExerciseState copy) {
        exerciseName = copy.exerciseName;
        exerciseLength = copy.exerciseLength;
    }

    public AddExerciseState() {
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public double getExerciseLength() {
        return exerciseLength;
    }

    public void setExerciseLength(double exerciseLength) {
        this.exerciseLength = exerciseLength;
    }

    public String getExerciseError(){return exerciseError;}


    public void setExerciseError(String exerciseError) {
        this.exerciseError = exerciseError;
    }
}
