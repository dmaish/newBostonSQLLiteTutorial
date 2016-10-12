package com.example.danielmaina.sqllite;

/**
 * Created by danielmaina on 10/5/16.
 */
public class Products {
    //its good to start the names of your column names with underscores

    private int _id;
    private String _productname;

    //create some constructors
    public Products(){

    }

    public Products(String productname) {
        this._productname = productname;
    }

    public Products(int id) {
        this._id = id;
    }

    //instantiate some getters and setters


    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public String get_productname() {
        return _productname;
    }
}