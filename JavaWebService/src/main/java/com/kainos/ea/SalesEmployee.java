package com.kainos.ea;

import java.util.Objects;

public class SalesEmployee extends Employee {

    private float commissionRate;
    private int salesTotal;

    public SalesEmployee(short newNumber, float newSalary, String newName) {
        super(newNumber, newSalary, newName);
    }

    public SalesEmployee(short newNumber, String newName, String newAddress, String newNIN, String newBankAcctNo,
                         float newSalary, String newDepartment, float newGrossPay, float newCommissionRate,
                         int newSalesTotal) {
        super(newNumber, newName, newAddress, newNIN, newBankAcctNo, newSalary, newDepartment, newGrossPay);
        setCommissionRate(newCommissionRate);
        setSalesTotal(newSalesTotal);
    }

    public SalesEmployee(float newCommissionRate, int newSalesTotal) {
        setCommissionRate(newCommissionRate);
        setSalesTotal(newSalesTotal);
    }

    public float getCommissionRate() {

        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {

        this.commissionRate = commissionRate;
    }

    public int getSalesTotal() {

        return salesTotal;
    }

    public void setSalesTotal(int salesTotal) {

        this.salesTotal = salesTotal;
    }

    @Override
    public float calcPay() {

        return super.calcPay() + Math.round(commissionRate * salesTotal);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        SalesEmployee that = (SalesEmployee) obj;
        return Float.compare(that.commissionRate, commissionRate) == 0 && salesTotal == that.salesTotal;
    }

    @Override
    public String toString() {
        return super.toString() + " Employee Commission Rate: " + getCommissionRate() + " Employee Total Sales: £"
                + getSalesTotal();
    }

    /*
    @Override
    public String toString() {
        return "SalesEmployee{" +
                "commissionRate=" + commissionRate +
                ", salesTotal=" + salesTotal +
                '}';
    }
    */
}
