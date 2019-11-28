package net.remenkoff.workout;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {

    // MARK: - Private Instance Properties
    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();

        if (view == null || Workout.workouts.length <= workoutId) {
            return;
        }

        Workout workout = Workout.workouts[(int) workoutId];

        TextView titleTextView = view.findViewById(R.id.title_text_view);
        titleTextView.setText(workout.name);

        TextView descTextView = view.findViewById(R.id.desc_text_view);
        descTextView.setText(workout.desc);
    }

    // MARK: - Public Instance Interface
    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

}
