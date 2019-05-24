package com.example.expensemanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Insert
    void insertExpense(Expense expense);

    @Query("SELECT * FROM expense_table WHERE expenseName = :name")
    List<Expense> findExpense(String name);

    @Query("DELETE FROM expense_table WHERE expenseName = :name")
    void deleteExpense(String name);

    @Query("SELECT * FROM expense_table ")
    LiveData<List<Expense>> getAllExpense();
}
