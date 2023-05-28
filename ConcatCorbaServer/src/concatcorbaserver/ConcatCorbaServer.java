/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package concatcorbaserver;

import ConcatApp.Concat;
import ConcatApp.ConcatHelper;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author ubuntu
 */
public class ConcatCorbaServer {

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
            ConcatCorbaServerImpl imp = new ConcatCorbaServerImpl();
            imp.setOrb(orb);
            
            // get the object reference from the servant class 
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(imp);
            Concat href = ConcatHelper.narrow(ref);
            
            //Get root naming context 
            //NameService invokes the name service 
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            
            //use NamingContextExt which is part of the Interoperable Naming Service (INS) specification
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            //Binding the obj reference to naming
            NameComponent path[] = ncRef.to_name("Concat");
            ncRef.rebind(path, href);
            
            System.out.println("Concat Server ready and waiting....");
            orb.run();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Server shutting down.");
    }
}
