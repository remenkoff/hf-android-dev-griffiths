package net.remenkoff.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class TempActivity extends AppCompatActivity {

    private static final String K_SW_FRAG_TAG = "K_SW_FRAG_TAG";

    private StopwatchFragment stopwatchFragment = new StopwatchFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState(savedInstanceState);
    }

    private void setupInitialState(Bundle savedInstanceState) {
        int layoutId = 2147483647;
        FrameLayout layout = new FrameLayout(this);
        layout.setId(layoutId);

        setContentView(layout);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(layoutId, stopwatchFragment, K_SW_FRAG_TAG);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

}
