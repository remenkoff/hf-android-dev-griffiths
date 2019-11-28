package net.remenkoff.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public final class DrinkListActivity extends Activity {

    // MARK: - Private Instance Properties
    private DrinkListLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new DrinkListLayout(this);

        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Drink.drinks
        );
        layout.drinkListView.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DrinkListActivity.this, DrinkDetailsActivity.class);
                intent.putExtra(DrinkDetailsActivity.K_DRINK_ID_KEY, (int) l);
                startActivity(intent);
            }
        };
        layout.drinkListView.setOnItemClickListener(itemClickListener);

        setContentView(layout);
    }

}
