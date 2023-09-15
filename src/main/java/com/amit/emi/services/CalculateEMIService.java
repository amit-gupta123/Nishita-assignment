package com.amit.emi.services;
import com.amit.emi.dto.EMIDTO;
import com.amit.emi.dto.EMIResultDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateEMIService {

    List<EMIResultDTO> miResultDTOList = new ArrayList<EMIResultDTO>();
    public String sayHi(){
        return "HI!, Set up is fine and working properly";
    }

    // get total interest

//    private double getTotalInterest(Double monthlyEMI, int noOfMonth){
//        double totalInterest = monthlyEMI*noOfMonth - ;
//
//    }

    // calculates monthly EMI
    public EMIResultDTO calculateMonthlyEMI(EMIDTO emidto){
        // calculate and return emi

        double monthlyRate = emidto.getRateOfInterest()/(12*100);
        double principleAmount = emidto.getPrincipleAmount();
        int noOfPayment = emidto.getNoOfPayment();
        // formula used to calculate monthly EMI
        // P x R x (1+R)^N / [(1+R)^N-1]
        double monthlyEmi = (principleAmount * monthlyRate * Math.pow((1+monthlyRate),noOfPayment))/
                            Math.pow((1+monthlyRate),noOfPayment-1);

        System.out.println(monthlyEmi);
        double totalAmountPaid = monthlyEmi*noOfPayment;
        System.out.println(totalAmountPaid);
        double totalInterest = totalAmountPaid - principleAmount;
        System.out.println(totalInterest);
        EMIResultDTO emiResultDTO = new EMIResultDTO();
        emiResultDTO.setTotalInterest(totalInterest);
        emiResultDTO.setMonthlyEMI(monthlyEmi);
        return emiResultDTO;
    }

    //calculate daily EMI
    public EMIResultDTO calculateDailyEmi(EMIDTO emidto){
        return null;
    }


    // calcualte weekly EMI
    public EMIResultDTO calculateWeeklyEMI(EMIDTO emidto){
        return null;
    }


    // calculate yearly EMI
    public EMIResultDTO calculateYearlyEMI(EMIDTO emidto){
        return null;
    }
}
