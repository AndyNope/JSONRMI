/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback;


import java.net.MalformedURLException;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author 5im14anbui
 */


public class RMIServer extends UnicastRemoteObject implements Feedback {

    private JSON json = new JSON();

    public RMIServer() throws RemoteException {
    }

    @Override

    public ArrayList<Picture> getFeedback(String keyword) throws RemoteException {
        json.getPictures(keyword);
        return getPics(keyword);

    }

    public void testJSON() {
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
    public ArrayList<Picture> getPics(String keyword) throws RemoteException {

        return json.getPictures(keyword);

    }

    public static void main(String[] args) {

        try {

            //impl.testJSON();
            LocateRegistry.createRegistry(1099);  // Use default Port 1099
            RMIServer impl = new RMIServer();
            String motdService = "JSON";
            Naming.rebind("//localhost/" + motdService, impl);

        } catch (RemoteException e) {
            System.out.println("Could not start Registry"); // Kann auch bedeuten, dass die Registry schon läuft

        } catch (MalformedURLException exc) {

        }

    }
}
