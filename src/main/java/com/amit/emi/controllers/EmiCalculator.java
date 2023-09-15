package com.amit.emi.controllers;
import com.amit.emi.dto.EMIDTO;
import com.amit.emi.dto.EMIResultDTO;
import com.amit.emi.services.CalculateEMIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/emi-calculator")
@Controller
@RestController
public class EmiCalculator {
    // injecting services.
    private CalculateEMIService calculateEMIService = new CalculateEMIService();

    // testing application

    @RequestMapping("/test")
    public String sayHi(){
        return calculateEMIService.sayHi();
    }



    // creating variable to store object.
    private EMIResultDTO emiResultDTO;

    @GetMapping("/calculate")
    public EMIResultDTO calculate( @RequestBody EMIDTO emiDTO){

        System.out.println(emiDTO.getPaymentInterval());
        System.out.println(emiDTO.getNoOfPayment());
        System.out.println(emiDTO.getPrincipleAmount());
        System.out.println(emiDTO.getRateOfInterest());


        String paymentInterval = emiDTO.getPaymentInterval();
        if(emiDTO.getPaymentInterval().toLowerCase().equals("monthly")){
            emiResultDTO = calculateEMIService.calculateMonthlyEMI(emiDTO);

        }

        else if(emiDTO.getPaymentInterval().toLowerCase().equals("daily")){
            emiResultDTO = calculateEMIService.calculateDailyEmi(emiDTO);
        }
        else if(emiDTO.getPaymentInterval().equals("yearly")){

        }
        else if(emiDTO.getPaymentInterval().toLowerCase().equals("weekly")){
            emiResultDTO = calculateEMIService.calculateWeeklyEMI(emiDTO);
        }
        return emiResultDTO;
    }



}
