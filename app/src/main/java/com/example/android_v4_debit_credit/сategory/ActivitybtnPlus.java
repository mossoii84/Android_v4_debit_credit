package com.example.android_v4_debit_credit.сategory;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_v4_debit_credit.DialogClass;
import com.example.android_v4_debit_credit.MainActivity;
import com.example.android_v4_debit_credit.R;
import com.example.android_v4_debit_credit.classes.Category;
import com.example.android_v4_debit_credit.classes.Money;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ActivitybtnPlus extends AppCompatActivity {

    private boolean x = false;
    LinearLayout linearLayout;
    TextView textExpense;
    TextView textProfit;
    RecyclerView recycler;

    //Category
    CategoryAdapter categoryAdapter = new CategoryAdapter();
    Category category;

    //сохроняем состояние
    public ArrayList<Money> items = new ArrayList<>();
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    Button btn_addSave;
    EditText inputAmount;
    EditText inputCategory;
    EditText inputDate;
    String amount;
    String myCategory;
    String myDate;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitybtn_plus);
//      getSupportActionBar().setDisplayHomeAsUpEnabled(true); -//кнопка возврата "назад" к странице родителя
        //Добавили титр в Тоообар
        setTitle("Add expense or profit");
        expenseVisibleLinearList();
        profitVisibleLinearList();
        btnTextCancel();

        inputCategory = findViewById(R.id.inputCategory);
        inputCategory.setEnabled(false);

        recycler = findViewById(R.id.rv_category_list);
        recycler.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.HORIZONTAL, false));
        recycler.setAdapter(categoryAdapter);

        //Category
        categoryAdapter.setOnCategoryClickListener(new OnCategoryClickListener() {
            @Override
            public void onCategoryClick(Category category) {
                inputCategory.setText(category.getName());
                //inputCategory.getText() - так мы получает в формате script
            }
        });
        categoryAdapter.updateList(getCategoryList());




        //сохранение состояния
        inputAmount = findViewById(R.id.inputNumber);
        inputDate = findViewById(R.id.inputData);
        btn_addSave=findViewById(R.id.btn_add);
        btn_addSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //получаем даты в string
                Date date = new Date();
                myDate = inputDate.getText().toString();
                String dateTime = myDate.format(String.valueOf(date));

                myCategory =inputCategory.getText().toString(); //превращаем наш Category в string
                amount = inputAmount.getText().toString();
                if(items ==null){
                    List<Money> items = new ArrayList<>();
                    items.add(new Money(new Category(myCategory),amount,new Date(dateTime)));
                }else{
                    items.add(new Money(new Category(myCategory),amount,new Date(dateTime)));
                }
                saveDataIn();
            }
        });

        loadDataInArray();
    }
    //СОХРАНЕНИЕ СОСТОЯНИЯ  Вариант 2-A
    private void saveDataIn(){
        sPref = getSharedPreferences("MyFile",MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        //добавили стандарный класс
        Gson gson = new Gson();
        //передали наш массив
        String json = gson.toJson(items);
        //SAVED_TEXT - это ключ, json - наше значение
        ed.putString("SAVED_TEXT", json).apply();
               Toast.makeText(ActivitybtnPlus.this, "save-" + json, Toast.LENGTH_SHORT).show();
    }
    private void loadDataInArray(){
        sPref = getSharedPreferences("MyFile",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sPref.getString("SAVED_TEXT", "");
        Type type = new TypeToken<ArrayList<Money>>(){}.getType();
        items=gson.fromJson(json,type);
        //в данном активити только загружаем, но не выводим, а выводим в Main
        if(items ==null){
            items = new ArrayList<>();
        }
    }
















//    //При нажатии на textView(expense) появляется выплывающее меню
    public void expenseVisibleLinearList() {
        textExpense = (TextView) findViewById(R.id.expense);
        linearLayout = (LinearLayout)findViewById(R.id.liner_category);

        textExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
                //подчеркивание текста
                textExpense.setPaintFlags(textExpense.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            }
        });
    }
    public void profitVisibleLinearList() {
        textProfit = (TextView) findViewById(R.id.profit);
        linearLayout = (LinearLayout)findViewById(R.id.liner_category);

        textProfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
                //подчеркивание текста
                textProfit.setPaintFlags(textProfit.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            }
        });
    }


    //Диалоговое окно
    public void btnTextCancel() {
        Button textCancel = (Button) findViewById(R.id.btn_cancel);
        textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

            private void openDialog() {
                DialogClass dialogClass = new DialogClass(); //обращаемся к классу диалог
                dialogClass.show(getSupportFragmentManager(), "example dialog");
            }
        });
    }



    private List<Category> getCategoryList() {
        List<Category> list = new ArrayList<>();
        list.add(new Category("Cash back"));
        list.add(new Category("Salary"));
        list.add(new Category("Deposit"));
        return list;
    }

}
