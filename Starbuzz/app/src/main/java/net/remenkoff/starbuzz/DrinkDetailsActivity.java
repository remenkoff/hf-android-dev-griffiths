package net.remenkoff.starbuzz;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

public final class DrinkDetailsActivity extends Activity implements DrinkDetailsLayout.Delegate {

    private class UpdateDrinkTask extends AsyncTask<Integer, Void, Boolean> {

        private ContentValues drinkValues;

        @Override
        protected void onPreExecute() {
            boolean isFavorite = layout.favoriteCheckBox.isChecked();
            drinkValues = new ContentValues();
            drinkValues.put("FAVORITE", isFavorite);
        }

        @Override
        protected Boolean doInBackground(Integer... drinks) {
            int drinkId = drinks[0];
            SQLiteOpenHelper dbHelper = new StarbuzzDatabaseHelper(DrinkDetailsActivity.this);
            try {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.update(
                        "DRINK",
                        drinkValues,
                        "_id = ?",
                        new String[] {Integer.toString(drinkId)}
                );
                return true;

            } catch(SQLiteException e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean isSuccess) {
            if (!isSuccess) {
                Toast.makeText(
                        DrinkDetailsActivity.this,
                        "Database unavailable",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }

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
        layout.delegate = this;

        int drinkId = getIntent().getIntExtra(K_DRINK_ID_KEY, -1);
        SQLiteOpenHelper dbHelper = new StarbuzzDatabaseHelper(this);
        try {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.query(
                    "DRINK",
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"},
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
                boolean isFavorite = cursor.getInt(3) == 1;

                layout.nameTextView.setText(drinkName);
                layout.descTextView.setText(drinkDesc);
                layout.drinkImageView.setImageResource(drinkImageId);
                layout.drinkImageView.setContentDescription(drinkDesc);
                layout.favoriteCheckBox.setChecked(isFavorite);
            }

            cursor.close();
            db.close();

        } catch(SQLiteException e) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }

        setContentView(layout);
    }

    @Override
    public void onFavoriteClick() {
        int drinkId = getIntent().getIntExtra(K_DRINK_ID_KEY, -1);
        new UpdateDrinkTask().execute(drinkId);
    }
}
