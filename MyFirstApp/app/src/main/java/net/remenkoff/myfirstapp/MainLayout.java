package net.remenkoff.myfirstapp;

import android.content.Context;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

public final class MainLayout extends ConstraintLayout {

    // MARK: - Public Type Properties
    public final static int id = 1987;

    // MARK: - Public Instance Properties
    public final TextView greetingTextView;

    // MARK: - Instantiation
    public MainLayout(Context context) {
        super(context);
        greetingTextView = new TextView(context);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupGreetingTextView();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);
        setId(MainLayout.id);
    }

    private void setupGreetingTextView() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.topToTop = this.getId();
        params.rightToRight = this.getId();
        params.bottomToBottom = this.getId();
        params.leftToLeft = this.getId();

        greetingTextView.setLayoutParams(params);

        addView(greetingTextView);
    }

}
