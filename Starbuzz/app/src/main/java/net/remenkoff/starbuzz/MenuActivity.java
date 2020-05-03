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
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MenuActivity extends Activity {

    // MARK: - Private Instance Properties
    private MenuLayout layout;

    private SQLiteDatabase db;
    private Cursor favoritesCursor;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
        setupOptionsListView();
        setupFavoritesListVew();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Cursor newCursor = db.query(
                "DRINK",
                new String[] {"_id", "NAME"},
                "FAVORITE = 1",
                null,
                null,
                null,
                null
        );

        CursorAdapter adapter = (CursorAdapter) layout.favoritesListView.getAdapter();
        adapter.changeCursor(newCursor);
        favoritesCursor = newCursor;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        favoritesCursor.close();
        db.close();
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

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(MenuActivity.this, DrinkListActivity.class);
                    startActivity(intent);
                }
            }
        };
        layout.menuListView.setOnItemClickListener(itemClickListener);

        setContentView(layout);
    }

    private void setupOptionsListView() {
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MenuActivity.this, DrinkDetailsActivity.class);
                    startActivity(intent);
                }
            }
        };
        layout.favoritesListView.setOnItemClickListener(itemClickListener);
    }

    private void setupFavoritesListVew() {
        try {
            SQLiteOpenHelper dbHelper = new StarbuzzDatabaseHelper(this);
            db = dbHelper.getReadableDatabase();

            favoritesCursor = db.query(
                    "DRINK",
                    new String[] {"_id", "NAME"},
                    "FAVORITE = 1",
                    null,
                    null,
                    null,
                    null
            );

            CursorAdapter favoritesAdapter = new SimpleCursorAdapter(
                    MenuActivity.this,
                    android.R.layout.simple_list_item_1,
                    favoritesCursor,
                    new String[] {"NAME"},
                    new int[] {android.R.id.text1},
                    0
            );
            layout.favoritesListView.setAdapter(favoritesAdapter);

        } catch(SQLiteException e) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }

        layout.favoritesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MenuActivity.this, DrinkDetailsActivity.class);
                intent.putExtra(DrinkDetailsActivity.K_DRINK_ID_KEY, (int)id);
                startActivity(intent);
            }
        });
    }
}
