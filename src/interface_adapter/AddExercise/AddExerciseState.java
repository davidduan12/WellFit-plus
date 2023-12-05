package interface_adapter.AddExercise;


public class AddExerciseState {
    private String exerciseName = "";
    private float exerciseLength = 0;
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

    public float getExerciseLength() {
        return exerciseLength;
    }

    public void setExerciseLength(float exerciseLength) {
        this.exerciseLength = exerciseLength;
    }

    public void setExerciseError(String exerciseError) {
        this.exerciseError = exerciseError;
    }
}
