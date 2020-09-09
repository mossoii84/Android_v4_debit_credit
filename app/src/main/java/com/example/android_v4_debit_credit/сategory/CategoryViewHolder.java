package com.example.android_v4_debit_credit.сategory;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_v4_debit_credit.R;
import com.example.android_v4_debit_credit.classes.Category;


public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private TextView categoryView;
    private Category currentCategory;

    // получается в CategoryViewHolder мы ставим то что будет как бы виднеться на экране
    // в строке tv_category_name потому что это View???
    //itemView - это наш элемент списка, и мы можем так к нему получить доступ
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryView = itemView.findViewById(R.id.tv_category_name);

    }

    //Bind это как бы связть, связь чего? то что на экране и то что пришло из адаптера(из бд данные)
    // мы получаем данные от клиента  и записываем или получаем из БД и выводим для клиента
    public void bind(Category category) {
   currentCategory = category; //это можно не писать?, зачем мы сообще создали переменную currentCategory тогда?
        categoryView.setText(currentCategory.getName());
    }

    //для чего мы это делаем тут? я так понимаю чтобы в Активити мы могли обратится к нему???почему не пишем прямо там?
    public void setListeners(final OnCategoryClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() { //itemView- встроенный метод в Recycler
            @Override
            public void onClick(View view) {
                listener.onCategoryClick(currentCategory);
            }
        });
    }

}
