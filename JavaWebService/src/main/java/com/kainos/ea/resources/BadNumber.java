package com.kainos.ea.resources;

public class BadNumber extends NumberFormatException{
    public BadNumber() {
        }

    public BadNumber(String s) {
            super(s);
        }
}
