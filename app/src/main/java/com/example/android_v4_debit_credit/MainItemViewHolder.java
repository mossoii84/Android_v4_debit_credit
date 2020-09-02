package com.example.android_v4_debit_credit;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_v4_debit_credit.data.Money;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainItemViewHolder extends RecyclerView.ViewHolder {
    private TextView amountView;
    private TextView categoryView;
    private TextView dateView;
    // Используем для преобразования из Date в строку необходимого формата https://divancoder.ru/2017/12/simpledateformat/
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.getDefault());

    public MainItemViewHolder(@NonNull View itemView) {
        super(itemView);
        amountView = itemView.findViewById(R.id.tv_cost);
        categoryView = itemView.findViewById(R.id.tv_category_name);
        dateView = itemView.findViewById(R.id.tv_date);

    }

    public void bind(Money money) {
        if (money.getAmount().charAt(0) == '+') {
            amountView.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.positiveColor));
        } else {
            amountView.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.negativeColor));
        }
        amountView.setText(money.getAmount());
        categoryView.setText(money.getCategory().getName());
        dateView.setText(format.format(money.getDate()));
    }
}