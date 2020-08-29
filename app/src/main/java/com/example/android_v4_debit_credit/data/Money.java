package com.example.android_v4_debit_credit.data;

import java.util.Date;

public class Money {
    // Категория, к которой будут относится записанные операции
    private Category category;
    // Количество, которое пользователь потратил или получил
    private String amount;
    // Дата, когда данная операция была совершена
    private Date date;

    public Money(Category category, String amount, Date date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public String getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
