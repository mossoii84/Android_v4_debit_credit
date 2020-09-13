package com.example.android_v4_debit_credit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_v4_debit_credit.classes.Category;
import com.example.android_v4_debit_credit.classes.Money;
import com.example.android_v4_debit_credit.сategory.ActivitybtnPlus;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import static com.example.android_v4_debit_credit.R.id.itemPlus;

public class MainActivity extends AppCompatActivity {

    //Вариант 2 с классом  NewsItems
    private ArrayList<Money> items = new ArrayList<>();
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;

    //сохроняем состояние
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    Button buttonDelete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Aoca"); // задали загаловок toorbar

        //подключаем наш recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // создаем адаптер
        mainAdapter = new MainAdapter();
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(mainAdapter);
        mainAdapter.updateList(items);


        loadDataInArray();
        deleteAllItems();
    }

    private void loadDataInArray(){
        sPref = getSharedPreferences("MyFile",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sPref.getString("SAVED_TEXT", "");
        Type type = new TypeToken<ArrayList<Money>>(){}.getType();
        items=gson.fromJson(json,type);
        //если наш массив пустой создаем новый экземпляр класса
        if(items ==null){
            items = new ArrayList<>();
        }else{
            mainAdapter.updateList(items);
        }
    }
    //Уничтожаем ВСЕ сохраненные состояния
    private void deleteAllItems(){
        buttonDelete = (Button) findViewById(R.id.button_deleteAllItemsMain);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sPref.edit().clear().commit();//удаляем наши состояния
                items.clear();//удаляем весь наш ArrayList, наши view на экране
                mainAdapter.updateList(items);
            }
        });
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
            Intent intent = new Intent(this, ActivitybtnPlus.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



}