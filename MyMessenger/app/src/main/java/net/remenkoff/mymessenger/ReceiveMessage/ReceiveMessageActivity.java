package net.remenkoff.mymessenger.ReceiveMessage;

import android.app.Activity;
import android.os.Bundle;

public final class ReceiveMessageActivity extends Activity {

    // MARK: - Public Type Properties
    public static final String INTENT_EXTRA_MSG = "INTENT_EXTRA_MSG";

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
        String intentExtraMessage = getIntent().getStringExtra(INTENT_EXTRA_MSG);

        layout = new ReceiveMessageLayout(this);
        layout.msgTextView.setText(intentExtraMessage);

        setContentView(layout);
    }

}
