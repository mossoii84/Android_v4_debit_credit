package com.example.android_v4_debit_credit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_v4_debit_credit.data.Category;
import com.example.android_v4_debit_credit.data.Money;

import java.util.ArrayList;
import java.util.Date;

import static com.example.android_v4_debit_credit.R.id.itemPlus;

public class MainActivity extends AppCompatActivity {

    //Вариант 2 с классом  NewsItems
    private ArrayList<Money> items = new ArrayList<>();
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;


    @SuppressLint({"ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Aoca"); // задали загаловок toorbar


        //Вариант 2 с классом NewsItems (вместо адаптера)
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // создаем адаптер
        mainAdapter = new MainAdapter();
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(mainAdapter);

        //дополнение мои статическая БД от класса NewsItems
        {
            items.add(new Money(
                new Category("Cash back"),
                "+ 400 руб.",
                new Date()
            ));
            items.add(new Money(
                new Category("Products"),
                "- 400 руб.",
                new Date(1598336735L * 1000)
            ));
            items.add(new Money(
                new Category("Salary"),
                "+ 100000 руб.",
                new Date()
            ));
        }
        mainAdapter.updateList(items);
    }


    @Override   // ставим верхнее меню
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu); //указываем menu андройд сам выберит какое выводить на экран обысное/land
        return super.onCreateOptionsMenu(menu);
    }


    //    переход на другую страницу при нажатии на кнопку (в данном случаи +)
    // onOptionsItemSelected - обязательное использование данного метода при нажатии на меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // itemPlus -  добавил над классом import static com.example.android_v3_appmenu.R.id.itemPlus;
        if (id == itemPlus) {
            Intent intent = new Intent(this, AddItemActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    //При нажатии появляется/проподает выпадающее боковая панель
//    @Override  // по нажатию на кнопку плюс в меню, появляется всплывающее окно
//    public boolean onOptionsItemSelected(MenuItem item) {
//        ImageView imageView = (ImageView)findViewById(R.id.imageView1);
//
//        int id = item.getItemId();
//        // itemPlus -  добавил над классом import static com.example.android_v3_appmenu.R.id.itemPlus;
//        if (id == itemPlus) {
//            Intent intent= new Intent(this, ActivitybtnPlus.class);
//                 startActivity(intent);
//
//            imageView.setVisibility(View.INVISIBLE);
////          textView.setText("есть меню");
//        }
//        return super.onOptionsItemSelected(item);
//    }


}