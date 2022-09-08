package com.kainos.ea;

public interface Payable {
    //Changed from int to float to match the changes in Employee class
    public float calcPay();

    public String getName();
    public String setName();
}
