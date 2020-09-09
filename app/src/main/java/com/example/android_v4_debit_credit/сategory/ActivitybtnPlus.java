package com.example.android_v4_debit_credit.сategory;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_v4_debit_credit.DialogClass;
import com.example.android_v4_debit_credit.R;
import com.example.android_v4_debit_credit.classes.Category;

import java.util.ArrayList;
import java.util.List;


public class ActivitybtnPlus extends AppCompatActivity {

    private boolean x = false;
    LinearLayout linearLayout;
    TextView textExpense;
    TextView textProfit;
    RecyclerView recycler;

    //Category
    EditText inputCategory;
    CategoryAdapter categoryAdapter = new CategoryAdapter();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitybtn_plus);

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

        categoryAdapter.setOnCategoryClickListener(new OnCategoryClickListener() {
            @Override
            public void onCategoryClick(Category category) {
                inputCategory.setText(category.getName());
            }
        });

        categoryAdapter.updateList(getCategoryList());


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
