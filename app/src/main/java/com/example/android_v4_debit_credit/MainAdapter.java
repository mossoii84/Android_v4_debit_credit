package com.example.android_v4_debit_credit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.android_v4_debit_credit.classes.Money;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainItemViewHolder>  implements View.OnClickListener {
    private List<Money> moneyList = new ArrayList<>();

    @Override
    public void onClick(View view) { }

    // Метод для обновления списка, если у нас изменился список и мы хотим показать актуальный список
    public void updateList(List<Money> moneyList) {
        this.moneyList = moneyList;
        // Уведомляем адаптор о том, что у нас поменялись данные и необходимо заново слинковать данные и вьюшки
        // То есть, заново будет вызваться метод onBindViewHolder
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Здесь мы создаем саму вьюшку, важно понимать, что вьюшек будет создано не столько же,
        // сколько элементов в списке, а столько, сколько может разместится на экране за раз + по две либо пл одной вьюшеке сверху и вьюшеке снизу
        // Например, у нас список из 100 элементов, а экран может разместить только 10 из них, так будет
        // созданно только 10 + 2 + 2 = 14 ViewHolder будет

        //Эту строчку мы прописываем таким способом для того чтобы можно было не использовать
        // Конструктор (для : List<Money>,LayoutInflater.from(context)) который является плохим решением
        // как я понимаю по этому мы используем LayoutInflater.from(viewGroup.getContext()).inflate(..)
        // вместо layoutInflater.inflate(R.layout.card_view, viewGroup,false);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new MainItemViewHolder(view);
    }





    @Override
    public void onBindViewHolder(@NonNull MainItemViewHolder holder, int position) {
        // Здесь мы просто вызываем метод для соединения данных и вьюшки, передаем туда необходимый объект
        holder.bind(moneyList.get(position));


    }

    @Override
    public int getItemCount() {
        return moneyList.size();
    }

}
