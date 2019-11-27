package net.remenkoff.starbuzz;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

final class MenuLayout extends LinearLayout {

    // MARK: - Private Instance Properties
    private final int K_DEFAULT_PADDING = 16;

    // MARK: - Public Instance Properties
    public final ImageView logoImageView;
    public final ListView menuListView;


    // MARK: - Instantiation
    public MenuLayout(Context context) {
        super(context);

        logoImageView = new ImageView(context);
        menuListView = new ListView(context);

        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupLogoImageView();
        setupMenuListView();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setPadding(K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING);

        addView(logoImageView);
        addView(menuListView);
    }

    private void setupLogoImageView() {
        LayoutParams params = new LayoutParams(200, 100);
        logoImageView.setLayoutParams(params);
    }

    private void setupMenuListView() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        menuListView.setLayoutParams(params);
    }

}
