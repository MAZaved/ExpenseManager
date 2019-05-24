package com.example.expensemanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ExpenseViewModel extends AndroidViewModel {

    private ExpenseRepository repository;
    private LiveData<List<Expense>> allExpense;

    public ExpenseViewModel(@NonNull Application application) {
        super(application);
        repository = new ExpenseRepository(application);
        allExpense = repository.getAllExpense();
    }

    LiveData<List<Expense>> getAllExpense(){return allExpense;}

    public void insertExpense(Expense expense, int value){repository.insertExpense(expense);}
}
