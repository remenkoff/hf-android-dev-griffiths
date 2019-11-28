package net.remenkoff.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    // MARK: - Public Type Interface
    public static final String K_WORKOUT_ID_KEY = "K_WORKOUT_ID_KEY";

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupFragment();
    }

    private void setupLayout() {
        setContentView(R.layout.activity_detail);
    }

    private void setupFragment() {
        int workoutId = getIntent().getIntExtra(K_WORKOUT_ID_KEY, -1);

        if (workoutId < 0) {
            throw new IllegalArgumentException("Workout ID can't be negative!");
        }

        WorkoutDetailFragment fragment = (WorkoutDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);

        if (fragment == null) {
            return;
        }

        fragment.setWorkoutId(workoutId);
    }

}
