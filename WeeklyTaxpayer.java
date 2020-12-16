/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06;
import java.text.*;
/**
 *
 * @author atkins01
 */
public class WeeklyTaxpayer extends Taxpayer {
 
    public WeeklyTaxpayer(String name, int ssn, double grossPay){
        super(name, ssn, grossPay);
    }
    
    @Override
    public double computeStateTax(double grossPay)
   {
       double tax = 0;
       if(grossPay < 154)
           tax = grossPay * 0.0400;
       else if (grossPay < 212)
           tax = 6.15+((grossPay - 154) * 0.0450);
       else if (grossPay < 250)
           tax = 8.75 + ((grossPay - 212) * 0.0525);
       else if (grossPay < 385)
           tax = 10.77 + ((grossPay - 250) * 0.0590);
       else if (grossPay < 1731)
           tax = 18.71 + ((grossPay - 385) * 0.0685);
       else if (grossPay < 1923)
           tax = 110.92 + ((grossPay - 1731) * 0.0764);
       else if (grossPay < 2885)
           tax = 125.62 + ((grossPay - 1923) * 0.0814);
       else 
           tax = 203.92 + ((grossPay - 2885) * 0.0935);
       return tax;
   }
    
    @Override
    public double computeFederalTax(double grossPay)
   {
       double tax = 0;
       double withholdingAmount = 0;
       double adjustedPay = 0;
       
       withholdingAmount = 65.38;
               
       adjustedPay = grossPay - withholdingAmount;
       
       if(adjustedPay < 51)
           tax = ((adjustedPay - 0) * 0.0) + 0;
       else if(adjustedPay < 195)
           tax = ((adjustedPay - 51) * .10);
       else if(adjustedPay < 645)
           tax = ((adjustedPay - 195) * .15) + 14.40;
       else if (adjustedPay < 1482)
           tax = ((adjustedPay - 645) * .25) + 81.90;
       else if (adjustedPay < 3131)
           tax = (((adjustedPay) - 1482) * .28) + 291.15;
       else if (adjustedPay < 6763)
           tax = ((adjustedPay - 3131) * .33) + 752.87;
       else
           tax = ((adjustedPay - 6763) * .35) + 1951.43;
       
       return tax;
   }
    
    @Override
    public String toString()
    {
        DecimalFormat prec1 = new DecimalFormat("$#.00");
        double stateTax = computeStateTax(grossPay);
        double fedTax = computeFederalTax(grossPay);
        double netPay = grossPay - (stateTax + fedTax);
        String outputStr = super.toString();
        outputStr += "\nState Tax for Pay Period: "
                + prec1.format(stateTax)
                + " Federal Tax for Pay Period: "
                + prec1.format(fedTax)
                + " Net Pay: " + prec1.format(netPay);
        return outputStr;
    }
}
