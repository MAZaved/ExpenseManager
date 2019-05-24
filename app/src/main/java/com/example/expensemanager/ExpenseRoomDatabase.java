package com.example.expensemanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Context;
import android.os.AsyncTask;

@Database(entities = {Expense.class}, version = 1)
public abstract class ExpenseRoomDatabase extends RoomDatabase {

    public abstract ExpenseDao expenseDao();
    private static ExpenseRoomDatabase INSTANCE;

    static ExpenseRoomDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (ExpenseRoomDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ExpenseRoomDatabase.class,"expense_database").addCallback(sRoomDatabaseCallBack).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallBack = new RoomDatabase.Callback()
    {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase database)
        {
            super.onOpen(database);

            new PopulateDbAsync(INSTANCE).execute();
        }

    };


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final ExpenseDao mDao;

        PopulateDbAsync(ExpenseRoomDatabase db) {
            mDao = db.expenseDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mDao.deleteExpense("Food");

            Expense expense = new Expense("Food",500);
            mDao.insertExpense(expense);
            expense = new Expense("Watch",1000);
            mDao.insertExpense(expense);
            return null;
        }
    }


}
