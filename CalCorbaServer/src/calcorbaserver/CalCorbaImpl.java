/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcorbaserver;

import CalculatorApp.CalculatorPOA;
import org.omg.CORBA.ORB;

/**
 *
 * @author ubuntu
 */
public class CalCorbaImpl extends CalculatorPOA {
    private ORB orb;
    
    public void setOrb(ORB a){
        orb = a;
    }

    @Override
    public double getSum(double a, double b) {
        return a+b;
    }

    @Override
    public double getDiff(double a, double b) {
        return a-b;
    }

    @Override
    public double getMul(double a, double b) {
        return a*b;
    }

    @Override
    public double getDiv(double a, double b) {
        return a/b;
    }
    
}
