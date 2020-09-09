package com.example.android_v4_debit_credit.classes;


public class Money {

    // Категория, к которой будут относится записанные операции
        private Category category;
        // Количество, которое пользователь потратил или получил
        private String amount;
        // Дата, когда данная операция была совершена
//    private Date date;


    public Money(Category category,String amount) {
        this.category = category;
        this.amount = amount;
    }


    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
