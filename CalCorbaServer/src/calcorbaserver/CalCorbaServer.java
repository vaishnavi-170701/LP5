/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calcorbaserver;

import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author ubuntu
 */
public class CalCorbaServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Initialize the ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            
            // initialize the BOA/POA and activate POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            
            // Create servant and register with ORB
            CalCorbaImpl imp = new CalCorbaImpl();
            imp.setOrb(orb);
            
            // get the object reference from the servant class 
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(imp);
            Calculator href = CalculatorHelper.narrow(ref);
            
            //Get root naming context 
            //NameService invokes the name service 
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            
            //use NamingContextExt which is part of the Interoperable Naming Service (INS) specification
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            //Binding the obj reference to naming
            NameComponent path[] = ncRef.to_name("Calculator");
            ncRef.rebind(path, href);
            
            System.out.println("Calculator Server ready and waiting....");
            orb.run();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Server shutting down.");
    }
    
}
