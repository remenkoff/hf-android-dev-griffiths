package net.remenkoff.starbuzz;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

final class DrinkDetailsLayout extends LinearLayout {

    // MARK: - Private Instance Properties
    private final int K_DEFAULT_PADDING = 16;

    // MARK: - Public Instance Properties
    public final ImageView drinkImageView;
    public final TextView nameTextView;
    public final TextView descTextView;

    // MARK: - Instantiation
    public DrinkDetailsLayout(Context context) {
        super(context);

        drinkImageView = new ImageView(context);
        nameTextView = new TextView(context);
        descTextView = new TextView(context);

        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupDrinkImageView();
        setupNameTextView();
        setupDescriptionTextView();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);
        setOrientation(VERTICAL);
        setPadding(K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING);

        addView(drinkImageView);
        addView(nameTextView);
        addView(descTextView);
    }

    private void setupDrinkImageView() {

    }

    private void setupNameTextView() {

    }

    private void setupDescriptionTextView() {

    }

}
