package net.remenkoff.myfirstapp;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

    // MARK: - Private Instance Properties
    private MainLayout layout;
    private String greetingText = "Hello me, it's me again!";

    // MARK: - View Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new MainLayout(this);
        setContentView(layout);
        layout.greetingTextView.setText(greetingText);
    }

}
