/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concatcorbaserver;

import ConcatApp.Concat;
import ConcatApp.ConcatPOA;
import org.omg.CORBA.ORB;

/**
 *
 * @author Vaishnavi Dhadiwal
 */
public class ConcatCorbaServerImpl extends ConcatPOA {
    private ORB orb;
    
    public void setOrb(ORB a){
        orb = a;
    }

    @Override
    public String concat_string(String s1, String s2) {
        return s1+s2;
    }   
}
