package com.example.android_v4_debit_credit;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_v4_debit_credit.data.Category;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private TextView categoryView;
    private Category currentCategory;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryView = itemView.findViewById(R.id.tv_category_name);
    }

    public void bind(Category category) {
        currentCategory = category;
        categoryView.setText(category.getName());
    }

    public void setListeners(final OnCategoryClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCategoryClick(currentCategory);
            }
        });
    }
}
