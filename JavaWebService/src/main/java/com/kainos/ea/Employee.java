package com.kainos.ea;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kainos.ea.resources.BadNumber;

import java.util.Objects;

import java.util.Objects;

public class Employee implements Comparable<Employee>, Payable {

    public static final int MIN_SALARY = 7_000_00;

    private short number; // employee number

    public short getNumber() {
        return number;
    }

    private String address;

    private String NIN;

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    private String Department;

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    private double grossPay;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNIN() {
        return NIN;
    }

    public void setNIN(String NIN) {
        this.NIN = NIN;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    private String bankAccountNo;


    public boolean setNumber(short thisNumber) {
        if (thisNumber > 0) {
            number = thisNumber;
            return true;
        } else {
            return false;
        }
    }

    public boolean setNumber(String thisNumber) {
        try {
            short s = Short.parseShort(thisNumber);
            return setNumber(s);
        } catch (NumberFormatException e) {
            throw new BadNumber(e.getMessage());
        }
    }

    protected int salary;   // employee salary in pence
    private String name;  // employee name

    public int calcPay() { // return the monthly pay
        return getSalary() / 12;
    }

    public Employee() {
        number = -1;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String setName() {
        return null;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        } else {
            throw new RuntimeException("Name cannot be empty when adding a new employee");
        }
    }

    public Employee(short newNumber) {
        this();
        setNumber(newNumber);
    }

    public Employee(int newSalary) {
        this();
        setSalary(newSalary);
    }

    public Employee(short newNumber, int newSalary, String newName) {
        this(newNumber); // good
        setSalary(newSalary);
        setName(newName);
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getNumber() == employee.getNumber() && getSalary() == employee.getSalary() && Objects.equals(getName(), employee.getName());
    }

    public int hashCode() {
        return Objects.hash(getNumber(), getSalary(), getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Employee Number:" + number +
                ", Salary: £" + salary +
                ", Name: " + name +
                +'}';
    }

    @Override
    public int compareTo(Employee o) {
        return Float.compare(this.getSalary(), o.getSalary());
    }

    @JsonCreator
    public Employee(@JsonProperty("name") String name) {
        this.setName(name);
    }
}

