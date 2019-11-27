package net.remenkoff.starbuzz;

import android.app.Activity;
import android.os.Bundle;

public final class DrinkListActivity extends Activity {

    // MARK: - Private Instance Properties
    private DrinkListLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new DrinkListLayout(this);
        setContentView(layout);
    }

}
