package net.remenkoff.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public final class DrinkListActivity extends Activity {

    // MARK: - Private Instance Properties
    private DrinkListLayout layout;
    private SQLiteDatabase db;
    private Cursor cursor;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new DrinkListLayout(this);

        SQLiteOpenHelper dbHelper = new StarbuzzDatabaseHelper(this);

        try {
            db = dbHelper.getReadableDatabase();
            cursor = db.query(
                    "DRINK",
                    new String[] {"_id", "NAME"},
                    null,
                    null,
                    null,
                    null,
                    null
            );

            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[] {"NAME"},
                    new int[] {android.R.id.text1},
                    0
            );

            layout.drinkListView.setAdapter(listAdapter);

        } catch(SQLiteException e) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }

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
