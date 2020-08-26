package com.example.android_v4_debit_credit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterForNewsItems extends RecyclerView.Adapter<AdapterForNewsItems.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<NewsItems> items; //наши переменные(textTitle,image,textDescription) без создания доп класса

    AdapterForNewsItems(Context context, List<NewsItems> items) {
        this.items = items;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override  //onCreateViewHolder: возвращает объект ViewHolder, который будет хранить данные по одному объекту NewsItems.
    public AdapterForNewsItems.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.card, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override  //onBindViewHolder: выполняет привязку объекта ViewHolder к объекту NewsItems по определенной позиции.
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        NewsItems item = items.get(position); // position = это типо i при переборе
        viewHolder.textTitle.setText(item.getTitle());
        viewHolder.textDescription.setText(item.getDescription());
//        viewHolder.imageView.setImageResource(item.getImageView());
    }

    @Override  //getItemCount: возвращает количество объектов в списке
    public int getItemCount() {
        return items.size();
    }

    //Для хранения данных в классе адаптера определен статический класс ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle, textDescription;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitre);
           textDescription = itemView.findViewById(R.id.textDescription);
//            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
