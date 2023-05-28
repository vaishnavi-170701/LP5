/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package concatcorbaclient;

import ConcatApp.Concat;
import ConcatApp.ConcatHelper;
import java.util.Scanner;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author ubuntu
 */
public class ConcatCorbaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Initialize the ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            //Get root naming context   
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            //Interoperable Naming service
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            Concat calc = ConcatHelper.narrow(ncRef.resolve_str("Concat"));

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter 1st no : ");
            String s1 = sc.nextLine();
            System.out.print("Enter 2nd no : ");
            String s2 = sc.nextLine();

            System.out.println("Addition is " + calc.concat_string(s1, s2));

            System.out.println("EXIT");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
