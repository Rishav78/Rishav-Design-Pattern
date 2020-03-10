package org.example.creational;
import java.io.*;

abstract class Plan {
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units) {
        System.out.print("Bill Calculated : ");
        System.out.println(units*rate);
    }
}

class DomesticPlan extends Plan {
    public void getRate() {
        this.rate = 3.75;
    }
}

class CommercialPlan extends Plan {
    public void getRate() {
        this.rate = 7.52;
    }
}

class InstitutionPlan extends Plan {
    public void getRate() {
        this.rate = 5.56;
    }
}

class GetPlan {
    public Plan getPlanType(String planType) {
        if(planType ==null)
            return null;
        else if(planType.equalsIgnoreCase("domestic"))
            return new DomesticPlan();
        else if(planType.equalsIgnoreCase("commercial"))
            return new CommercialPlan();
        else if(planType.equalsIgnoreCase("institution"))
            return new InstitutionPlan();
        else
            throw new Error("Input is Null");
    }
}


public class FactoryMethod {
    public static void main(String args[]) throws IOException {
        GetPlan getPlan = new GetPlan();
        System.out.println("Enter \"Domestic\" / \"Commercial\" / \"Institution\"");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String planType = br.readLine();
        System.out.println("Enter number of units for bill");
        int units = Integer.parseInt(br.readLine());

        Plan p = getPlan.getPlanType(planType);
        p.getRate();
        p.calculateBill(units);
    }
}