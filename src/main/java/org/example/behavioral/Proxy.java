package org.example.behavioral;

interface OfficeNetAccess{
    public void grantNetAccess();
}

class RealNetAccess implements OfficeNetAccess{
    private String employeeName;

    public RealNetAccess(String empName){
        this.employeeName = empName;
    }

    @Override
    public void grantNetAccess() {
        System.out.println("Access granted to employee "+employeeName);
    }
}

class ProxyNetAccess implements OfficeNetAccess{
    private String employeeName;
    private RealNetAccess realNetAccess;

    public ProxyNetAccess(String employeeName){
        this.employeeName=employeeName;
    }

    public int getRole(String empName){
        return empName.length();
    }

    @Override
    public void grantNetAccess() {
        if(getRole(employeeName) > 4){
            realNetAccess = new RealNetAccess(employeeName);
            realNetAccess.grantNetAccess();
        }
        else
            System.out.println("Access not granted. Your job level is below 5");
    }
}
public class Proxy {
    public static void main(String args[]){
        OfficeNetAccess officeNetAccess = new ProxyNetAccess("Satya");
        officeNetAccess.grantNetAccess();
    }
}