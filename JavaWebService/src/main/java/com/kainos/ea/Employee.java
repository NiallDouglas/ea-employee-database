package com.kainos.ea;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kainos.ea.resources.BadNumber;

import java.util.Objects;

import java.util.Objects;

public class Employee implements Comparable<Employee>, Payable {

    public static final float MIN_SALARY = 7_000_00.00f;

    private short number; // employee number

    private String name;  // employee name

    private String address;

    private String NIN;

    private String bankAccountNo;

    private String Department;

    public String getaddress() {
        return address;
    }

    private float salary;

    private String department;

    private float grossPay;

    public Employee() {
        number = -1;
    }

    public Employee(short newNumber) {
        this();
        setNumber(newNumber);
    }

    public Employee(float newSalary) {
        this();
        setSalary(newSalary);
    }

    public Employee(short newNumber, float newSalary, String newName) {
        this(newNumber); // good
        setSalary(newSalary);
        setName(newName);
    }

    public Employee(short newNumber, String newName, String newAddress, String newNIN, String newBankAcctNo,
                    float newSalary, String newDepartment, float newGrossPay) {
        this(newNumber); // good
        setName(newName);
        setAddress(newAddress);
        setNIN(newNIN);
        setBankAccountNo(newBankAcctNo);
        setSalary(newSalary);
        setDepartment(Department);
        setGrossPay(newGrossPay);
    }

    public short getNumber() {
        return number;
    }

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

    public float getSalary() {
        return salary;
    }


    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(float grossPay) {
        this.grossPay = grossPay;
    }

    public float calcPay() { // return the monthly pay
        return getSalary() / 12;
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
                "Employee Number: " + number +
                "Employee Name: " + name +
                "Employee Address: " + address +
                "Employee National Insurance Number: " + NIN +
                "Employee Bank Account Number: " + bankAccountNo +
                "Employee Salary: £" + salary +
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

