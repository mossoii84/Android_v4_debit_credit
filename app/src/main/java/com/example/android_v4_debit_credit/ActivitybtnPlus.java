package com.example.android_v4_debit_credit;


import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.android_v4_debit_credit.R.id.itemPlus;

public class ActivitybtnPlus extends AppCompatActivity {


    private boolean x = false;
    LinearLayout linearLayout;
    TextView textExpense;
    TextView textProfit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitybtn_plus);

        // активируем наш турбар для всех, добавить правильный импорт import androidx.appcompat.widget.Toolbar;
        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbaraoca);
        setSupportActionBar(toolbar);
        //Добавили титр в Тоообар
        getSupportActionBar().setTitle("Add expense or profit");

        //кнопка возврата "назад" к странице родителя
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //podcherkivanie(); // нажатие на TextView
        expenseVisibleLinearList();
        profitVisibleLinearList();
        btnTextCancel();

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }




    //При нажатии на textView(expense) появляется выплывающее меню
    public void expenseVisibleLinearList() {
        textExpense = (TextView) findViewById(R.id.expense);
        linearLayout = (LinearLayout)findViewById(R.id.categoryList);

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
        linearLayout = (LinearLayout)findViewById(R.id.categoryList);

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
        TextView textCancel = (TextView) findViewById(R.id.textCancel);
        textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

            private void openDialog() {
                DialogClass dialogClass = new DialogClass();
                dialogClass.show(getSupportFragmentManager(),"example dialog");
            }
        });
    }







}