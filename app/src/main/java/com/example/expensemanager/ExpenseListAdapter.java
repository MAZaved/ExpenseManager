package com.example.expensemanager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ExpenseListAdapter extends RecyclerView.Adapter<ExpenseListAdapter.ExpenseViewHolder> {
    class ExpenseViewHolder extends RecyclerView.ViewHolder {

        private final TextView expenseItemView;

        private ExpenseViewHolder(View expenseView)
        {
            super(expenseView);
            expenseItemView = expenseView.findViewById(R.id.expenseNameTextView);
        }

    }

    private final LayoutInflater inflater;
    private List<Expense> expense; // Cached copy of words

    ExpenseListAdapter(Context context){inflater = LayoutInflater.from(context);}

    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = inflater.inflate(R.layout.recyclerview_item,parent,false);
        return new ExpenseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpenseViewHolder holder, int positon){
        if(expense != null){
            Expense current = expense.get(positon);
            holder.expenseItemView.setText(current.getExpenseName());
        }else {
            holder.expenseItemView.setText("No Item");
        }
    }

    void setExpenses(List<Expense> expenses) {
        expense = expenses;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
