package com.example.android_v4_debit_credit;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.android_v4_debit_credit.R.id.itemPlus;
public class MainActivity extends AppCompatActivity {

    //Вариант 2 с классом  NewsItems
    private ArrayList<NewsItems> items= new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterForNewsItems adapterForNewsItems;


    //переход на активити при нажатии кнопки (+)
    private Button btnActivitybtnPlus;



    @SuppressLint({"ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // активируем наш турбар для всех, добавить правильный импорт import androidx.appcompat.widget.Toolbar;
        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbaraoca);
        setSupportActionBar(toolbar);
        MainActivity.this.setTitle("Aoca"); // задали загаловок toorbar



        //Вариант 2 с классом NewsItems (вместо адаптера)
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // создаем адаптер
        adapterForNewsItems = new AdapterForNewsItems(this, items);  //item это как бы данные указанных переменных
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapterForNewsItems);

        //дополнение мои статическая БД от класса NewsItems
        {
            items.add(new NewsItems(
                    "Podcast 256: You down with GPT-3? Yeah you know me!",
                    "The post Podcast 256"
                    ));
            items.add(new NewsItems(
                    "Brian Gilmartin, CFA",
                    "CME  Volatility"

                    ));
            items.add(new NewsItems(
                    "Cointelegraph By",
                    "Developers  2.0 on July 27"
                    ));
        }
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
            Intent intent= new Intent(this, ActivitybtnPlus.class);
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