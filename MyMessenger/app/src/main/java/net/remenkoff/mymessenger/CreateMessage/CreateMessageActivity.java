package net.remenkoff.mymessenger.CreateMessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import net.remenkoff.mymessenger.R;

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
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, layout.msgEditText.getText().toString());

        if (intent.resolveActivity(this.getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
