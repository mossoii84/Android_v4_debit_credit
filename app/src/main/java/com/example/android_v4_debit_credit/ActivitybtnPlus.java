//package com.example.android_v4_debit_credit;


import android.graphics.Paint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.android_v4_debit_credit.classes.Money;
//
//import java.util.ArrayList;
//
//import static com.example.android_v4_debit_credit.R.id.btn_cancel;
//import static com.example.android_v4_debit_credit.R.id.itemPlus;
//
//public class ActivitybtnPlus extends AppCompatActivity {
//
//
//    private boolean x = false;
//    LinearLayout linearLayout;
//    TextView textExpense;
//    TextView textProfit;
//
//
//    //Делаем наш RecyclerView
//    private ArrayList<Money> items = new ArrayList<>();
//
//    public Button button_insert;
//    public EditText editText;
//    String getInputNumber;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activitybtn_plus);
//
//        // активируем наш турбар для всех, добавить правильный импорт import androidx.appcompat.widget.Toolbar;
//        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbaraoca);
//        setSupportActionBar(toolbar);
//        //Добавили титр в Тоообар
//        getSupportActionBar().setTitle("Add expense or profit");
//        //кнопка возврата "назад" к странице родителя
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//
//
//        //Наши поля ввода input
//        editText = findViewById(R.id.inputNumber);
//        button_insert = findViewById(R.id.btn_add);
//
//        button_insert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Получаем наши введенные данные и приобрезауем их
//                getInputNumber = editText.getText().toString();
//                //зановим их в наш ArrayList (массив)
//                items.add(new Money(getInputNumber));
//
//                //всплывающее надпись
//                Toast.makeText(ActivitybtnPlus.this, getInputNumber, Toast.LENGTH_LONG).show();
//            }
//        });
//
//
//        //podcherkivanie(); // нажатие на TextView
//        expenseVisibleLinearList();
//        profitVisibleLinearList();
//        btnTextCancel();
//
//    }
//
//
//
//
//    //При нажатии на textView(expense) появляется выплывающее меню
//    public void expenseVisibleLinearList() {
//        textExpense = (TextView) findViewById(R.id.expense);
//        linearLayout = (LinearLayout)findViewById(R.id.categoryList);
//
//        textExpense.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        linearLayout.setVisibility(View.VISIBLE);
//               //подчеркивание текста
//           textExpense.setPaintFlags(textExpense.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//    }
// });
//}
//    public void profitVisibleLinearList() {
//        textProfit = (TextView) findViewById(R.id.profit);
//        linearLayout = (LinearLayout)findViewById(R.id.categoryList);
//
//        textProfit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                linearLayout.setVisibility(View.VISIBLE);
//                //подчеркивание текста
//                textProfit.setPaintFlags(textProfit.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//            }
//        });
//    }
//
//
//
//
//
//    //Диалоговое окно
//    public void btnTextCancel() {
//        Button btn_cancel = (Button) findViewById(R.id.btn_cancel);
//        btn_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDialog();
//            }
//
//            private void openDialog() {
//                DialogClass dialogClass = new DialogClass();
//                dialogClass.show(getSupportFragmentManager(),"example dialog");
//            }
//        });
//    }
//
//
//
//
//
//
//
//}