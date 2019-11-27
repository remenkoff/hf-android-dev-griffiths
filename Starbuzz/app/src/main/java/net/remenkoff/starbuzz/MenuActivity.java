package net.remenkoff.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class MenuActivity extends Activity {

    // MARK: - Private Instance Properties
    private MenuLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new MenuLayout(this);
        layout.logoImageView.setImageResource(R.drawable.starbuzz_logo);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.ma_menu_items,
                android.R.layout.simple_list_item_1
        );
        layout.menuListView.setAdapter(arrayAdapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(MenuActivity.this, DrinkListActivity.class);
                    startActivity(intent);
                }
            }
        };
        layout.menuListView.setOnItemClickListener(onItemClickListener);

        setContentView(layout);
    }

}
