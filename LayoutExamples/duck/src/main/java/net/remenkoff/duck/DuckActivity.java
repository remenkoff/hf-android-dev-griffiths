package net.remenkoff.duck;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public final class DuckActivity extends Activity {

    // MARK: - Private Instance Interface
    private DuckLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new DuckLayout(this);
        layout.imageView.setImageResource(R.drawable.duck);
        layout.titleTextView.setText(getString(R.string.da_title_text));
        layout.subtitleTextView.setText(getString(R.string.da_subtitle_text));

        setContentView(layout);
    }

}
