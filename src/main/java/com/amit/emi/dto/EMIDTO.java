package com.amit.emi.dto;

import com.amit.emi.constans.PaymentsInterval;

public class EMIDTO {
    private String paymentInterval;
    private double principleAmount;
    private double rateOfInterest;
    private int noOfPayment;


    public String getPaymentInterval() {
        return paymentInterval;
    }

    public void setPaymentInterval(String paymentInterval) {
        this.paymentInterval = paymentInterval;
    }

    public double getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(int principleAmount) {
        this.principleAmount = principleAmount;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(int rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public int getNoOfPayment() {
        return noOfPayment;
    }

    public void setNoOfPayment(int noOfPayment) {
        this.noOfPayment = noOfPayment;
    }
}
