package net.remenkoff.mymessenger.ReceiveMessage;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

final class ReceiveMessageLayout extends LinearLayout {

    // MARK: - Public Type Properties
    public static final int id = 0xEEEEAEA;

    // MARK: - Private Instance Properties
    private final int K_DEFAULT_INDENT= 16;

    // MARK: - Package-Private Instance Interface
    final TextView msgTextView;

    // MARK: - Instantiation
    public ReceiveMessageLayout(Context context) {
        super(context);
        msgTextView = new TextView(context);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupMessageTextView();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);

        setOrientation(VERTICAL);
        setPadding(K_DEFAULT_INDENT, K_DEFAULT_INDENT, K_DEFAULT_INDENT, K_DEFAULT_INDENT);
        setId(ReceiveMessageLayout.id);

        addView(msgTextView);
    }

    private void setupMessageTextView() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        params.topMargin = K_DEFAULT_INDENT;

        msgTextView.setLayoutParams(params);
    }

}
