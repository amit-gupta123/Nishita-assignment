package com.amit.emi.services;
import com.amit.emi.dto.EMIDTO;
import com.amit.emi.dto.EMIResultDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateEMIService {
    List<EMIResultDTO> emiResultDTOList = null;

    // methods to calculate EMI
    public List<EMIResultDTO> calculateMonthlyEMI(EMIDTO emidto){
        System.out.println("MONTHLY EMI");
        emiResultDTOList = new ArrayList<EMIResultDTO>();
        int noOfPayment = emidto.getNoOfPayment();
        double principleAmount = emidto.getPrincipleAmount();
        double remainingPrincipleAmount = principleAmount;

//        // list to store rows of table
//         emiResultDTOList = new ArrayList<>();

        double monthlyRate = (emidto.getRateOfInterest()/12.0)/100.0;
        double numerator = principleAmount * monthlyRate * Math.pow((1+monthlyRate),noOfPayment);
        double denominator = Math.pow((1+monthlyRate),noOfPayment)-1;
        double monthlyEmi = (double) (numerator/denominator);

        double totalInterestPayment = 0.0;
        for( int month = 1; month <= noOfPayment; month++ ){
            double currentMonthInterestPayment = Math.round((remainingPrincipleAmount * monthlyRate)*100)/100.0;
            totalInterestPayment+=currentMonthInterestPayment;
            double currentMonthPrinciplePayment = Math.round((monthlyEmi - currentMonthInterestPayment)*100)/100.0;
            remainingPrincipleAmount = Math.round((remainingPrincipleAmount - currentMonthPrinciplePayment)*100)/100.0;
            emiResultDTOList.add(new EMIResultDTO(
                    currentMonthInterestPayment,
                    currentMonthPrinciplePayment,
                    remainingPrincipleAmount,
                    totalInterestPayment,
                    monthlyEmi
            ));
        }

        return emiResultDTOList;
    }

    //calculate daily EMI
    public List<EMIResultDTO> calculateDailyEmi(EMIDTO emidto){

        int noOfPayment = emidto.getNoOfPayment();
        double principleAmount = emidto.getPrincipleAmount();
        double remainingPrincipleAmount = principleAmount;

        // list to store rows of table
        emiResultDTOList = new ArrayList<>();

        double dailyRate = (double)((emidto.getRateOfInterest()/365.0)/100.0);

        double dailyEmi =  (double)((principleAmount * dailyRate * Math.pow((1+dailyRate),noOfPayment))/
                (Math.pow((1+dailyRate),noOfPayment)-1));


//        System.out.println(dailyRate);
//        System.out.println(dailyEmi);
        double totalInterestPayment = 0.0;
        for( int day = 1; day <= noOfPayment; day++ ) {

            double currentDayInterestPayment = Math.round((remainingPrincipleAmount * dailyRate)*100)/100.0;
            totalInterestPayment += currentDayInterestPayment;
            double currentDayPrinciplePayment = Math.round((dailyEmi - currentDayInterestPayment)*100)/100.0;
            remainingPrincipleAmount = Math.round((remainingPrincipleAmount - currentDayPrinciplePayment)*100)/100.0;
            emiResultDTOList.add(new EMIResultDTO(
                    currentDayInterestPayment,
                    currentDayPrinciplePayment,
                    remainingPrincipleAmount,
                    totalInterestPayment,
                    dailyEmi
            ));
        }
        return emiResultDTOList;
    }

    // calculate weekly EMI
    public List<EMIResultDTO> calculateWeeklyEMI(EMIDTO emidto){

        emiResultDTOList = new ArrayList<EMIResultDTO>();

        double principleAmount = emidto.getPrincipleAmount();
        int noOfPayment = emidto.getNoOfPayment();
        double rateOfInterest = emidto.getRateOfInterest();
        double remainingPrincipleAmount = principleAmount;

        double weeklyRate = (double)((rateOfInterest/52.0)/100.0);
        double weeklyEMI =  (double)((principleAmount * weeklyRate * Math.pow((1+weeklyRate),noOfPayment))/
                                    (Math.pow((1+weeklyRate),noOfPayment)-1));
        //System.out.println(weeklyEMI);

        double totalInterestPayment = 0.0;
        for( int week = 1; week <= noOfPayment; week++ ){
            double currentWeekInterestPayment = Math.round((remainingPrincipleAmount * weeklyRate)*100)/100.0;
            totalInterestPayment += currentWeekInterestPayment;
            double currentMonthPrinciplePayment = Math.round((weeklyEMI- currentWeekInterestPayment)*100)/100.0;
            remainingPrincipleAmount = Math.round((remainingPrincipleAmount - currentMonthPrinciplePayment)*100)/100.0;
            emiResultDTOList.add(new EMIResultDTO(
                    currentWeekInterestPayment,
                    currentMonthPrinciplePayment,
                    remainingPrincipleAmount,
                    totalInterestPayment,
                    weeklyEMI
            ));
        }

        return emiResultDTOList;
    }

    // calculate yearly EMI
    public List<EMIResultDTO> calculateYearlyEMI(EMIDTO emidto){
        emiResultDTOList = new ArrayList<EMIResultDTO>();

        double principleAmount = emidto.getPrincipleAmount();
        int noOfPayment = emidto.getNoOfPayment();
        double rateOfInterest = emidto.getRateOfInterest();
        double remainingPrincipleAmount = principleAmount;
        double yearlyEMI = (double)(principleAmount * 0.1 * Math.pow((1+0.1),noOfPayment)/(Math.pow((1+0.1),2)-1));
        System.out.println(yearlyEMI);

        double totalInterestPayment = 0.0;
        for( int year = 1; year <= noOfPayment; year++ ){
            double currentYearInterestPayment = Math.round((remainingPrincipleAmount * rateOfInterest/100)*100)/100.0;
            totalInterestPayment += currentYearInterestPayment;
            double currentMonthPrinciplePayment = Math.round((yearlyEMI - currentYearInterestPayment)*100)/100.0;
            remainingPrincipleAmount = Math.round((remainingPrincipleAmount - currentMonthPrinciplePayment)*100)/100.0;
            emiResultDTOList.add(new EMIResultDTO(
                    currentYearInterestPayment,
                    currentMonthPrinciplePayment,
                    remainingPrincipleAmount,
                    totalInterestPayment,
                    yearlyEMI
            ));
        }

        return emiResultDTOList;
    }
}
