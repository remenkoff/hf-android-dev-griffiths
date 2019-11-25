package net.remenkoff.mymessenger.ReceiveMessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public final class ReceiveMessageActivity extends Activity {

    // MARK: - Private Instance Properties
    private ReceiveMessageLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        String intentExtraMessage = getIntent().getStringExtra(Intent.EXTRA_TEXT);

        layout = new ReceiveMessageLayout(this);
        layout.msgTextView.setText(intentExtraMessage);

        setContentView(layout);
    }

}
