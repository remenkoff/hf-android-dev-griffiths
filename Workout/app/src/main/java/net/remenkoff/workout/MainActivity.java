package net.remenkoff.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.K_WORKOUT_ID_KEY, (int) index);
        startActivity(intent);
    }

}
