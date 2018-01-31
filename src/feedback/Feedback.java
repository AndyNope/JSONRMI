package feedback;
 
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Feedback extends Remote
{
    public ArrayList<Picture> getFeedback(String keyword) throws RemoteException;

}
