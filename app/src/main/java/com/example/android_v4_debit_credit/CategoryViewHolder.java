package com.example.android_v4_debit_credit;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_v4_debit_credit.data.Category;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private TextView categoryView;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryView = itemView.findViewById(R.id.tv_category_name);
    }

    public void bind(Category category) {
        categoryView.setText(category.getName());
    }
}
