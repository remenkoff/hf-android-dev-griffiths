package net.remenkoff.mymessenger.CreateMessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import net.remenkoff.mymessenger.R;
import net.remenkoff.mymessenger.ReceiveMessage.ReceiveMessageActivity;

public final class CreateMessageActivity extends Activity implements CreateMessageLayoutDelegate {

    // MARK: - Private Instance Properties
    private CreateMessageLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new CreateMessageLayout(this);
        layout.delegate = this;
        layout.sendButton.setText(getString(R.string.cm_send_btn_title));
        layout.msgEditText.setHint(getString(R.string.cm_msg_placeholder));

        setContentView(layout);
    }

    // MARK: - CreateMessageLayoutDelegate
    @Override
    public void didTapSendButton() {
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.INTENT_EXTRA_MSG, layout.msgEditText.getText().toString());
        startActivity(intent);
    }

}
