package net.remenkoff.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

final class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    // MARK: - Type Properties
    private static final String DB_NAME = "starbuzz";
    private static final int DB_VERSION = 2;

    private static final String DRINK_TABLE_NAME = "DRINK";
    private static final String ID_COLUMN_NAME = "_id";
    private static final String NAME_COLUMN_NAME = "NAME";
    private static final String DESC_COLUMN_NAME = "DESCRIPTION";
    private static final String IMG_RES_ID_COLUMN_NAME = "IMAGE_RESOURCE_ID";

    // MARK: - Instantiation
    StarbuzzDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // MARK: - Super Overrides
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        updateMyDatabase(sqLiteDatabase, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        updateMyDatabase(sqLiteDatabase, i, i1);
    }

    // MARK: - Private Type Interface
    private static void insertDrink(SQLiteDatabase db, String name, String desc, int resID) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put(NAME_COLUMN_NAME, name);
        drinkValues.put(DESC_COLUMN_NAME, desc);
        drinkValues.put(IMG_RES_ID_COLUMN_NAME, resID);
        db.insert(DRINK_TABLE_NAME, null, drinkValues);
    }

    // MARK: - Private Instance Interface
    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE " + DRINK_TABLE_NAME + " (" +
                    ID_COLUMN_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME_COLUMN_NAME + " TEXT, " +
                    DESC_COLUMN_NAME + " TEXT, " +
                    IMG_RES_ID_COLUMN_NAME + " TEXT);");

            insertDrink(db, "Latte", "Espresso and steamed milk", R.drawable.latte);
            insertDrink(db, "Cappuccino", "Espresso, hot milk and steamed milk foam", R.drawable.cappuccino);
            insertDrink(db, "Filter", "Our best drip coffee", R.drawable.filter);
        }

        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }

}
