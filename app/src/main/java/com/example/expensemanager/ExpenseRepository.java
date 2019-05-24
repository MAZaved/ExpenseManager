package com.example.expensemanager;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ExpenseRepository {

    private ExpenseDao expenseDao;
    private LiveData<List<Expense>> allExpense;

    ExpenseRepository(Application application)
    {
        ExpenseRoomDatabase database = ExpenseRoomDatabase.getDatabase(application);
        expenseDao  = database.expenseDao();
        allExpense = expenseDao.getAllExpense();
    }

    LiveData<List<Expense>> getAllExpense()
    {
        return getAllExpense();
    }

    public void insertExpense( Expense expense)
    {
        new insertAsyncTask(expenseDao).execute(expense);
    }

    private static class insertAsyncTask extends AsyncTask<Expense,Void,Void>
    {
        private ExpenseDao asyncTaskDao;

        insertAsyncTask(ExpenseDao dao){asyncTaskDao = dao;}

        @Override
        protected Void doInBackground(final Expense... expenses){
            asyncTaskDao.insertExpense(expenses[0]);
            return null;
        }
    }

}
