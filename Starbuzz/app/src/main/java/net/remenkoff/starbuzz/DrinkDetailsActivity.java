package net.remenkoff.starbuzz;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

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
        layout = new DrinkDetailsLayout(this);

        int drinkId = getIntent().getIntExtra(K_DRINK_ID_KEY, -1);
        SQLiteOpenHelper dbHelper = new StarbuzzDatabaseHelper(this);
        try {
            SQLiteDatabase db  = dbHelper.getReadableDatabase();
            Cursor cursor = db.query(
                    "DRINK",
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[] {Integer.toString(drinkId)},
                    null,
                    null,
                    null
            );

            if (cursor.moveToFirst()) {
                String drinkName = cursor.getString(0);
                String drinkDesc = cursor.getString(1);
                int drinkImageId = cursor.getInt(2);

                layout.nameTextView.setText(drinkName);
                layout.descTextView.setText(drinkDesc);
                layout.drinkImageView.setImageResource(drinkImageId);
                layout.drinkImageView.setContentDescription(drinkDesc);
            }

            cursor.close();
            db.close();

        } catch(SQLiteException e) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }

        setContentView(layout);
    }

}
