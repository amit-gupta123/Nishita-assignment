package com.amit.emi.controllers;
import com.amit.emi.dto.EMIDTO;
import com.amit.emi.dto.EMIResultDTO;
import com.amit.emi.services.CalculateEMIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/emi-calculator")
@Controller
@RestController
public class EmiCalculator {
    // injecting services.
    private CalculateEMIService calculateEMIService = new CalculateEMIService();

    // creating variable to store object.
    private EMIResultDTO emiResultDTO;

    @RequestMapping("/test")
    public String sayHi(){
        return "Application is running fine";
    }

    @GetMapping("/calculate")
    public List<EMIResultDTO> calculate( @RequestBody EMIDTO emiDTO){

        List<EMIResultDTO> emiResultDTOList = null;
        String paymentInterval = emiDTO.getPaymentInterval();
        if(emiDTO.getPaymentInterval().toLowerCase().equals("monthly")){
              emiResultDTOList = calculateEMIService.calculateMonthlyEMI(emiDTO);
        }
        else if(emiDTO.getPaymentInterval().toLowerCase().equals("daily")){
            emiResultDTOList = calculateEMIService.calculateDailyEmi(emiDTO);
        }
        else if(emiDTO.getPaymentInterval().toLowerCase().equals("yearly")){
            emiResultDTOList = calculateEMIService.calculateYearlyEMI(emiDTO);
        }
        else if(emiDTO.getPaymentInterval().toLowerCase().equals("weekly")){
            emiResultDTOList = calculateEMIService.calculateWeeklyEMI(emiDTO);
        }
        return emiResultDTOList;
    }
}
