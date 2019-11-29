package net.remenkoff.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // MARK: - WorkoutListFragment.Listener
    @Override
    public void didSelectItem(long index) {
        int selectedWorkoutId = (int)index;

        FrameLayout fragmentContainerLayout = findViewById(R.id.detail_frag_container);
        boolean isFragmentContainerExists = fragmentContainerLayout != null;

        if (isFragmentContainerExists) {
            WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
            workoutDetailFragment.setWorkoutId(selectedWorkoutId);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.detail_frag_container, workoutDetailFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();

        } else {

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.K_WORKOUT_ID_KEY, selectedWorkoutId);
            startActivity(intent);
        }
    }

}
