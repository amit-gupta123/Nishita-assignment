package com.amit.emi.dto;

public class EMIResultDTO {
    private double balance;
    private double interest;
    private double principle;
    private double totalInterest;
    private double EMI;

    public EMIResultDTO() {

    }

    public EMIResultDTO(double interest, double principle, double balance, double totalInterest, double monthlyEMI) {
        this.balance = balance;
        this.interest = interest;
        this.principle = principle;
        this.totalInterest = totalInterest;
        this.EMI = monthlyEMI;
    }

    public double getEMI() {
        return EMI;
    }

    public void setEMI(double monthlyEMI) {
        this.EMI = monthlyEMI;
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
