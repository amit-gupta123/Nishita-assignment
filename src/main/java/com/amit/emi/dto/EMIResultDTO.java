package com.amit.emi.dto;

public class EMIResultDTO {
    private double balance;
    private double interest;
    private double principle;
    private double totalInterest;
    private double monthlyEMI;

    public EMIResultDTO() {

    }

    public EMIResultDTO(double balance, double interest, double principle, double totalInterest, double monthlyEMI) {
        this.balance = balance;
        this.interest = interest;
        this.principle = principle;
        this.totalInterest = totalInterest;
        this.monthlyEMI = monthlyEMI;
    }



    public double getMonthlyEMI() {
        return monthlyEMI;
    }

    public void setMonthlyEMI(double monthlyEMI) {
        this.monthlyEMI = monthlyEMI;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public double getPrinciple() {
        return principle;
    }

    public void setPrinciple(int principle) {
        this.principle = principle;
    }
}
