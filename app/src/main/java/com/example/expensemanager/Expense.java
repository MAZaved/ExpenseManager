package com.example.expensemanager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense_table")
public class Expense {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "expenseName")
    private String expenseName;

    @ColumnInfo(name = "expenseAmount")
    private int expenseAmount;


    public Expense(@NonNull String expenseName,int expenseAmount)
    {
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
    }

//    public Expense(@NonNull String expenseAmount) {this.expenseName = expenseAmount;}

    public String getExpenseName(){return this.expenseName;}
    public int getExpenseAmount(){return this.expenseAmount;}
}
