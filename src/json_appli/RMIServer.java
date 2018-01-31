/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import json_appli.JSON;
import json_appli.Picture;

/**
 *
 * @author 5im14anbui
 */
public class RMIServer extends UnicastRemoteObject implements Feedback {
    private JSON json = new JSON();
    int i = 1;

    public RMIServer() throws RemoteException {
    }

    @Override
    public String getFeedback(String nameOfCaller) throws RemoteException {
        return "Hallo " + nameOfCaller + ", Sie sind der " + (i++) + ". Kunde!!!";

    }
    
    public void testJSON(){
        json.getMap("Car");
        for (Picture pic : json.getPictures("boy")) {
            System.out.println(pic.getLink());
        }
    }

    /**
     *
     * @param keyword
     * @return
     * @throws RemoteException
     */
    public ArrayList<Picture> getPics   (String keyword) throws RemoteException {
        return json.getPictures(keyword);

    }

    public static void main(String[] args) {
      
        
        try {
             RMIServer impl = new RMIServer();
             impl.testJSON();
            LocateRegistry.createRegistry(1099);  // Use default Port 1099
            String motdService = "Andy";
            Naming.rebind("//localhost/" + motdService, impl);

        } catch (RemoteException e) {
            System.out.println("Could not start Registry"); // Kann auch bedeuten, dass die Registry schon läuft
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
