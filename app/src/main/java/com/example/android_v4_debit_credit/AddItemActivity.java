package com.example.android_v4_debit_credit;


import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_v4_debit_credit.data.Category;

import java.util.ArrayList;
import java.util.List;

public class AddItemActivity extends AppCompatActivity {

    private boolean x = false;
    LinearLayout linearLayout;
    TextView textExpense;
    TextView textProfit;
    RecyclerView recycler;
    CategoryAdapter adapter = new CategoryAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitybtn_plus);

        //Добавили титр в Тоообар
        setTitle("Add expense or profit");

        //кнопка возврата "назад" к странице родителя

        //podcherkivanie(); // нажатие на TextView
        expenseVisibleLinearList();
        profitVisibleLinearList();
        btnTextCancel();

        recycler = findViewById(R.id.rv_category_list);
        recycler.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.HORIZONTAL, false));
        recycler.setAdapter(adapter);

        adapter.updateList(getCategoryList());

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

        textExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //подчеркивание текста
                textExpense.setPaintFlags(textExpense.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            }
        });
    }

    public void profitVisibleLinearList() {
        textProfit = (TextView) findViewById(R.id.profit);

        textProfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                DialogClass dialogClass = new DialogClass();
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