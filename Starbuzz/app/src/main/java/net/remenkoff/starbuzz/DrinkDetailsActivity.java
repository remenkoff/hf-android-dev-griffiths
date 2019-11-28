package net.remenkoff.starbuzz;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public final class DrinkDetailsActivity extends Activity {

    // MARK: - Public Type Interface
    public static final String K_DRINK_ID_KEY = "K_DRINK_ID_KEY";

    // MARK: - Private Instance Properties
    DrinkDetailsLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        int drinkIndex = getIntent().getIntExtra(K_DRINK_ID_KEY, -1);

        if (drinkIndex < 0 || Drink.drinks.length <= drinkIndex) {
            throw new IllegalArgumentException("There is no such an index for drinks!");
        }
        Drink drink = Drink.drinks[drinkIndex];

        layout = new DrinkDetailsLayout(this);
        layout.drinkImageView.setImageResource(drink.imageResourceId);
        layout.nameTextView.setText(drink.name);
        layout.descTextView.setText(drink.desc);

        setContentView(layout);
    }

}
