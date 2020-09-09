package com.example.android_v4_debit_credit.сategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_v4_debit_credit.R;
import com.example.android_v4_debit_credit.classes.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>{
    private List<Category> categoryList = new ArrayList<>();
    private OnCategoryClickListener categoryClickListener = null;


    public void setOnCategoryClickListener(OnCategoryClickListener listener) {
        categoryClickListener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(categoryList.get(position));
        holder.setListeners(categoryClickListener); //что срабатывает первым в Адаптере или в Holdere, слушатель идет от
                                           // клиента к БД или все равно сначала все пишется в БД а потом сюда поподает?
    }
    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    // Метод для обновления списка, если у нас изменился список и мы хотим показать актуальный список
    public void updateList(List<Category> categoryList) {
        this.categoryList = categoryList;
        // Уведомляем адаптор о том, что у нас поменялись данные и необходимо заново слинковать данные и вьюшки
        // То есть, заново будет вызваться метод onBindViewHolder
        notifyDataSetChanged();
    }
}
