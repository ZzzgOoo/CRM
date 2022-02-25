package com.example.crm.ov;


import java.util.List;

public class PaginationOv<T> {
    private int total;
    private List<T> datalist;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<T> datalist) {
        this.datalist = datalist;
    }
}
